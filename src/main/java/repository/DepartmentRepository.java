package repository;

import com.google.gson.reflect.TypeToken;
import dto.department.DepartmentCreateDto;
import dto.department.DepartmentDto;
import dto.department.DepartmentUpdateDto;
import repository.base.AbstractRepository;
import repository.base.GenericCrudRepository;
import repository.base.GenericRepository;
import settings.Types;

import java.util.List;

public class DepartmentRepository extends AbstractRepository
        implements GenericCrudRepository<DepartmentDto, DepartmentCreateDto, DepartmentUpdateDto, Long>{

    @Override
    public Long create(DepartmentCreateDto dto) {
        prepareArguments(gson.toJson(dto), sessionUserId());
        return callProcedure(property.get("department.create"), Long.class);
    }

    @Override
    public Boolean update(DepartmentUpdateDto dto) {
        prepareArguments(gson.toJson(dto), sessionUserId());
        return callProcedure(property.get("department.update"), Boolean.class);
    }

    @Override
    public Boolean delete(Long id) {
        prepareArguments(id, sessionUserId());
        return callProcedure(property.get("department.delete"), Boolean.class);
    }

    @Override
    public DepartmentDto get(Long id) {
        prepareArguments(id, sessionUserId());
        String jsonData = callProcedure(property.get("department.get"), String.class);
        return gson.fromJson(jsonData, DepartmentDto.class);
    }

    @Override
    public List<DepartmentDto> getAll() {
        prepareArguments(sessionUserId());
        String jsonData = callProcedure(property.get("department.getAll"), String.class);
        return gson.fromJson(jsonData, new TypeToken<List<DepartmentDto>>() {
        }.getType());
    }

    public Boolean block(Long id) {
        prepareArguments(id, sessionUserId());
        return callProcedure(property.get("department.block"), Boolean.class);
    }

    public Boolean unblock(Long id) {
        prepareArguments(id, sessionUserId());
        return callProcedure(property.get("department.unblock"), Boolean.class);
    }
}
