package repository.base;

import com.google.gson.Gson;
import configs.ApplicationContextHolder;
import exceptions.CustomSQLException;
import lombok.SneakyThrows;
import property.DatabaseProperties;
import security.SecurityHolder;
import settings.Types;

import java.io.Serializable;
import java.sql.*;
import java.util.Objects;

public abstract class AbstractRepository implements BaseGenericRepository {
    protected Connection connection = ApplicationContextHolder.getBean(Connection.class);
    private Object[] args;
    protected DatabaseProperties property = ApplicationContextHolder.getBean(DatabaseProperties.class);
    protected Gson gson = ApplicationContextHolder.getBean(Gson.class);


    protected Long sessionUserId() {
        return SecurityHolder.session.getId();
    }

    @SneakyThrows
    protected Serializable callProcedure(String query, int outType) {
        try {
            CallableStatement statement = connection.prepareCall(query);
            prepareToExecute(statement);
            ResultSet resultSet = statement.executeQuery();
            return prepareResultSet(resultSet, outType);
        } catch (SQLException ex) {
            throw new CustomSQLException(ex.getMessage(), ex.getCause());
        }
    }

    protected <T> T callProcedure(String query, Class<T> clazz) throws CustomSQLException {
        if (clazz.getSimpleName().equalsIgnoreCase("String"))
            return (T) callProcedure(query, Types.VARCHAR);
        if (clazz.getSimpleName().equalsIgnoreCase("Long"))
            return (T) callProcedure(query, Types.BIGINT);
        if (clazz.getSimpleName().equalsIgnoreCase("Boolean"))
            return (T) callProcedure(query, Types.BOOLEAN);
        if (clazz.getSimpleName().equalsIgnoreCase("Void"))
            return (T) callProcedure(query, Types.VOID);
        return null;
    }

    @SneakyThrows
    private Serializable prepareResultSet(ResultSet resultSet, int outType) {
        if (Objects.nonNull(resultSet) && resultSet.next()) {
            return switch (outType) {
                case Types.VARCHAR -> resultSet.getString(1);
                case Types.BIGINT -> resultSet.getLong(1);
                case Types.BOOLEAN -> resultSet.getBoolean(1);
                case Types.VOID -> -1;
                default -> throw new IllegalStateException("Unexpected value: " + outType);
            };
        }
        return null;
    }

    @SneakyThrows
    private void prepareToExecute(CallableStatement statement) {
        for (int i = 0; i < this.args.length; i++) {
            statement.setObject(i + 1, args[i]);
        }
    }

    protected void prepareArguments(Object... args) {
        this.args = args;
    }
}
