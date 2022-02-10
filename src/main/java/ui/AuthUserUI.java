package ui;

import dto.user.UserDto;
import exceptions.ApiRuntimeException;
import response.Data;
import response.ResponseEntity;
import service.AuthUserService;
import ui.base.AbstractUI;
import uz.jl.utils.Color;
import uz.jl.utils.Input;

public class AuthUserUI extends AbstractUI<AuthUserService> {

    public AuthUserUI(AuthUserService service) {
        super(service);
    }

    public void login() {
        try {
            String username = Input.getStr("Enter username-> ");
            String password = Input.getStr("Enter password-> ");
            ResponseEntity<Data<UserDto>> response = service.login(username, password);
            showResponse(Color.GREEN, response.getBody());
        } catch (ApiRuntimeException e) {
            showResponse(e.getMessage());
        }
    }
}
