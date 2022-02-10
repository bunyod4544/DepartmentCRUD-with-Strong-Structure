package repository;

import com.google.gson.reflect.TypeToken;
import dto.user.UserCreateDto;
import dto.user.UserDto;
import dto.user.UserUpdateDto;
import lombok.SneakyThrows;
import repository.base.AbstractRepository;
import repository.base.GenericCrudRepository;
import repository.base.GenericRepository;
import security.SecurityHolder;
import settings.Types;

import java.util.List;


public class UserRepository extends AbstractRepository
        implements GenericCrudRepository<UserDto, UserCreateDto, UserUpdateDto, Long> {
    @Override
    public Long create(UserCreateDto dto) {
        String json = gson.toJson(dto);
        prepareArguments(json, SecurityHolder.session.getId());
        return  callProcedure(property.get("user.create"), Long.class);
    }

    @Override
    public Boolean update(UserUpdateDto dto) {
        prepareArguments(gson.toJson(dto), sessionUserId());
        return callProcedure(property.get("user.update"), Boolean.class);
    }

    @Override
    public Boolean delete(Long id) {
        prepareArguments(id, sessionUserId());
        return callProcedure(property.get("user.delete"), Boolean.class);
    }

    @SneakyThrows
    @Override
    public UserDto get(Long id) {
        prepareArguments(id);
        String jsonDATA = callProcedure(property.get("user.get"), String.class);
        return gson.fromJson(jsonDATA, UserDto.class);
    }

    @Override
    public List<UserDto> getAll() {
        return null;
    }

    public List<UserDto> listOfUsers(Long id) {
        prepareArguments(id, sessionUserId());
        String jsonDATA = callProcedure(property.get("user.getAll"), String.class);
        return gson.fromJson(jsonDATA, new TypeToken<List<UserDto>>(){}.getType());
    }

    public Boolean block(Long id) {
        prepareArguments(id, sessionUserId());
        return  callProcedure(property.get("user.block"), Boolean.class);
    }

    public Boolean unBlock(Long id) {
        prepareArguments(id, sessionUserId());
        return  callProcedure(property.get("user.unblock"), Boolean.class);
    }
}
