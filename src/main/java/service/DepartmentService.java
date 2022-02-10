package service;

import dto.department.DepartmentCreateDto;
import dto.department.DepartmentDto;
import dto.department.DepartmentUpdateDto;
import exceptions.ApiRuntimeException;
import exceptions.CustomSQLException;
import repository.DepartmentRepository;
import response.Data;
import response.ResponseEntity;
import service.base.AbstractService;
import service.base.GenericCrudService;
import service.base.GenericService;
import validator.DepartmentValidator;

import java.util.List;

public class DepartmentService extends AbstractService<DepartmentRepository, DepartmentValidator>
        implements GenericCrudService<DepartmentCreateDto, DepartmentUpdateDto, Long>,
        GenericService<DepartmentDto, Long> {

    public DepartmentService(DepartmentRepository repository, DepartmentValidator validator) {
        super(repository, validator);
    }

    @Override
    public ResponseEntity<Data<Long>> create(DepartmentCreateDto dto) {
        try {
            validator.validOnCreate(dto);
            return new ResponseEntity<>(new Data<>(repository.create(dto)));
        } catch (CustomSQLException e) {
            throw new ApiRuntimeException(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<Data<Boolean>> update(DepartmentUpdateDto dto) {
        try {
            validator.validOnUpdate(dto);
            return new ResponseEntity<>(new Data<>(repository.update(dto)));
        } catch (CustomSQLException e) {
            throw new ApiRuntimeException(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<Data<Boolean>> delete(Long id) {
        try {
            return new ResponseEntity<>(new Data<>(repository.delete(id)));
        } catch (CustomSQLException e) {
            throw new ApiRuntimeException(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<Data<DepartmentDto>> get(Long id) {
        try {
            return new ResponseEntity<>(new Data<>(repository.get(id)));
        } catch (CustomSQLException e) {
            throw new ApiRuntimeException(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<Data<List<DepartmentDto>>> getAll() {
        try {
            List<DepartmentDto> dtoList = repository.getAll();
            return new ResponseEntity<>(new Data<>(dtoList, dtoList.size()));
        } catch (CustomSQLException e) {
            throw new ApiRuntimeException(e.getMessage());
        }
    }

    public ResponseEntity<Data<Boolean>> block(Long id) {
        try {
            return new ResponseEntity<>(new Data<>(repository.block(id)));
        } catch (CustomSQLException e) {
            throw new ApiRuntimeException(e.getMessage());
        }
    }

    public ResponseEntity<Data<Boolean>> unblock(Long id) {
        try {
            return new ResponseEntity<>(new Data<>(repository.unblock(id)));
        } catch (CustomSQLException e) {
            throw new ApiRuntimeException(e.getMessage());
        }
    }
}
