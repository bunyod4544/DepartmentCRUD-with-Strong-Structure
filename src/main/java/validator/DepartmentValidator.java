package validator;

import dto.department.DepartmentCreateDto;
import dto.department.DepartmentUpdateDto;
import enums.HttpStatus;
import exceptions.ApiRuntimeException;
import validator.base.GenericValidator;

import java.util.Objects;

public class DepartmentValidator extends GenericValidator<DepartmentCreateDto, DepartmentUpdateDto, Long> {
    @Override
    public void validKey(Long id) {

    }

    @Override
    public void validOnCreate(DepartmentCreateDto dto) {
        if (Objects.isNull(dto.getName()) || Objects.isNull(dto.getPhoneNumber())) {
            throw new ApiRuntimeException("BAD_CREDENTIALS");
        }
    }

    @Override
    public void validOnUpdate(DepartmentUpdateDto dto) {
        if (Objects.isNull(dto.getId())) {
            throw new ApiRuntimeException("BAD_CREDENTIALS");
        }

    }
}
