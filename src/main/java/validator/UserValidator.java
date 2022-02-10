package validator;

import dto.user.UserCreateDto;
import dto.user.UserUpdateDto;
import validator.base.GenericValidator;

public class UserValidator extends GenericValidator<UserCreateDto, UserUpdateDto, Long> {
    @Override
    public void validKey(Long id) {

    }

    @Override
    public void validOnCreate(UserCreateDto dto) {

    }

    @Override
    public void validOnUpdate(UserUpdateDto dto) {

    }
}
