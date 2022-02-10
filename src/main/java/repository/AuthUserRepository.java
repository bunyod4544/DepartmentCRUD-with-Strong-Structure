package repository;

import dto.user.UserDto;
import repository.base.AbstractRepository;
import settings.Types;


public class AuthUserRepository extends AbstractRepository {

    public UserDto login(String username, String password) {
        prepareArguments(username, password);
        String jsonData = (String) callProcedure(property.get("auth.login"), Types.VARCHAR);
        return gson.fromJson(jsonData, UserDto.class);
    }


}
