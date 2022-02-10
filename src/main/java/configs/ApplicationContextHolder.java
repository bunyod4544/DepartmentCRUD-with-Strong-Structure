package configs;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import property.ApplicationProperties;
import property.DatabaseProperties;
import repository.AuthUserRepository;
import repository.DepartmentRepository;
import repository.UserRepository;
import service.AuthUserService;
import service.DepartmentService;
import service.UserService;
import ui.AuthUserUI;
import ui.DepartmentUI;
import ui.UserUI;
import validator.DepartmentValidator;
import validator.UserValidator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ApplicationContextHolder {
    private static final Gson GSON;

    private static final ApplicationProperties APPLICATION_PROPERTIES;
    private static final DatabaseProperties DATABASE_PROPERTIES;

    private static Connection CONNECTION;

    private static final UserValidator USER_VALIDATOR;
    private static final DepartmentValidator DEPARTMENT_VALIDATOR;

    private static final AuthUserRepository AUTH_USER_REPOSITORY;
    private static final UserRepository USER_REPOSITORY;
    private static final DepartmentRepository DEPARTMENT_REPOSITORY;

    private static final AuthUserService AUTH_USER_SERVICE;
    private static final UserService USER_SERVICE;
    private static final DepartmentService DEPARTMENT_SERVICE;

    private static final AuthUserUI AUTH_USER_UI;
    private static final UserUI USER_UI;
    private static final DepartmentUI DEPARTMENT_UI;


    static {

        GSON = new GsonBuilder().setPrettyPrinting().create();

        APPLICATION_PROPERTIES = new ApplicationProperties();
        DATABASE_PROPERTIES = new DatabaseProperties();

        try {
            CONNECTION = DriverManager.getConnection(
                    APPLICATION_PROPERTIES.get("db.jdbc"),
                    APPLICATION_PROPERTIES.get("db.username"),
                    APPLICATION_PROPERTIES.get("db.password"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        USER_VALIDATOR = new UserValidator();
        DEPARTMENT_VALIDATOR = new DepartmentValidator();

        AUTH_USER_REPOSITORY = new AuthUserRepository();
        USER_REPOSITORY = new UserRepository();
        DEPARTMENT_REPOSITORY = new DepartmentRepository();

        AUTH_USER_SERVICE = new AuthUserService(AUTH_USER_REPOSITORY, USER_VALIDATOR);
        USER_SERVICE = new UserService(USER_REPOSITORY, USER_VALIDATOR);
        DEPARTMENT_SERVICE = new DepartmentService(DEPARTMENT_REPOSITORY, DEPARTMENT_VALIDATOR);

        AUTH_USER_UI = new AuthUserUI(AUTH_USER_SERVICE);
        USER_UI = new UserUI(USER_SERVICE);
        DEPARTMENT_UI = new DepartmentUI(DEPARTMENT_SERVICE);

    }

    public static <T> T getBean(Class<T> clazz) {
        return getBean(clazz.getSimpleName());
    }

    private static <T> T getBean(String name) {
        return switch (name.toUpperCase()) {
            case "GSON" -> (T) GSON;
            case "APPLICATIONPROPERTIES" -> (T) APPLICATION_PROPERTIES;
            case "DATABASEPROPERTIES" -> (T) DATABASE_PROPERTIES;
            case "CONNECTION" -> (T) CONNECTION;

            case "USERREPOSITORY" -> (T) USER_REPOSITORY;
            case "AUTHUSERREPOSITORY" -> (T) AUTH_USER_REPOSITORY;
            case "DEPARTMENTREPOSITORY" -> (T) DEPARTMENT_REPOSITORY;

            case "AUTHUSERSERVICE" -> (T) AUTH_USER_SERVICE;
            case "USERSERVICE" -> (T) USER_SERVICE;
            case "DEPARTMENTSERVICE" -> (T) DEPARTMENT_SERVICE;

            case "USERVALIDATOR" -> (T) USER_VALIDATOR;
            case "DEPARTMENTVALIDATOR" -> (T) DEPARTMENT_VALIDATOR;

            case "USERUI" -> (T) USER_UI;
            case "AUTHUSERUI" -> (T) AUTH_USER_UI;
            case "DEPARTMENTUI" -> (T) DEPARTMENT_UI;

            default -> throw new RuntimeException("Bean Not Found Exception");
        };
    }
}
