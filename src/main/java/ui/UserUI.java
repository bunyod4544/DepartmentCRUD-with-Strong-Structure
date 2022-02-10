package ui;

import dto.user.UserCreateDto;
import dto.user.UserDto;
import dto.user.UserUpdateDto;
import exceptions.ApiRuntimeException;
import response.Data;
import response.ResponseEntity;
import security.SecurityHolder;
import service.UserService;
import ui.base.AbstractUI;
import uz.jl.utils.Color;
import uz.jl.utils.Input;
import uz.jl.utils.Print;

import java.util.List;
import java.util.Locale;


public class UserUI extends AbstractUI<UserService> {

    public UserUI(UserService service) {
        super(service);
    }


    public void get() {
        try {
            if (isSession()){
                String id = Input.getStr("Enter user id-> ");
                ResponseEntity<Data<UserDto>> response = service.get(Long.parseLong(id));
                showResponse(Color.GREEN, response.getBody());
            }else {
                Print.println(Color.RED, "You are not logged in!!!");
            }
        } catch (ApiRuntimeException e) {
            showResponse(e.getMessage());
        }
    }

    public void update() {
        UserUpdateDto dto = new UserUpdateDto();

        String id = Input.getStr("User id ->");
        dto.setId(Long.parseLong(id));

        String uname = Input.getStr("Do you wanna change Username? YES/NO");
        if (uname.toLowerCase(Locale.ROOT).startsWith("y")) {
            String username = Input.getStr("Username -> ");
            dto.setUsername(username);
        }
        String fname = Input.getStr("Do you wanna change First name? YES/NO");
        if (fname.toLowerCase(Locale.ROOT).startsWith("y")) {
            String firstName = Input.getStr("First name -> ");
            dto.setFirstName(firstName);
        }
        String lname = Input.getStr("Do you wanna change Last name? YES/NO");
        if (lname.toLowerCase(Locale.ROOT).startsWith("y")) {
            String lastName = Input.getStr("Last name -> ");
            dto.setLastName(lastName);
        }
        String dep = Input.getStr("Do you wanna change Department id? YES/NO");
        if (dep.toLowerCase(Locale.ROOT).startsWith("y")) {
            String depId = Input.getStr("Depart id -> ");
            dto.setDepartId(Long.parseLong(depId));
        }

        try{
            ResponseEntity<Data<Boolean>> response = service.update(dto);
            showResponse(Color.GREEN, response.getBody());
        }catch (ApiRuntimeException e){
            showResponse(e.getMessage());
        }
    }

    public void create() {
        String username = Input.getStr("Enter username-> ");
        String password = Input.getStr("Enter password-> ");
        String firsName = Input.getStr("Enter firsName-> ");
        String lastName = Input.getStr("Enter lastName-> ");
        String depId = Input.getStr("Enter depart id-> ");
        UserCreateDto dto = UserCreateDto.childBuilder()
                .password(password)
                .departId(Long.parseLong(depId))
                .firstName(firsName)
                .lastName(lastName)
                .username(username)
                .build();

        try {
            ResponseEntity<Data<Long>> response = service.create(dto);
            showResponse(Color.GREEN, response.getBody());
        } catch (ApiRuntimeException e) {
            showResponse(e.getMessage());
        }

    }

    public void delete() {
        String id = Input.getStr("Enter user id -> ");
        try {
            ResponseEntity<Data<Boolean>> response = service.delete(Long.parseLong(id));
            showResponse(Color.GREEN, response.getBody());
        } catch (ApiRuntimeException e){
            showResponse(e.getMessage());
        }
    }

    public void logout() {
        SecurityHolder.setSessionUser(null);
        Print.println(Color.GREEN, "Successfully logged out! ");
    }

    public void getAll() {
        String id = Input.getStr("Department id -> ");
        try {
            ResponseEntity<Data<List<UserDto>>> response = service.listOfMembers(Long.parseLong(id));
            showResponse(Color.GREEN, response.getBody());
        } catch (ApiRuntimeException e){
            showResponse(e.getMessage());
        }
    }

    public void blockUser() {
        String id = Input.getStr("Enter user id -> ");
        try {
            ResponseEntity<Data<Boolean>> response = service.blockUser(Long.parseLong(id));
            showResponse(Color.GREEN, response.getBody());
        } catch (ApiRuntimeException e){
            showResponse(e.getMessage());
        }
    }

    public void unBlockUser() {
        String id = Input.getStr("Enter user id -> ");
        try {
            ResponseEntity<Data<Boolean>> response = service.unBlockUser(Long.parseLong(id));
            showResponse(Color.GREEN, response.getBody());
        } catch (ApiRuntimeException e){
            showResponse(e.getMessage());
        }
    }
}
