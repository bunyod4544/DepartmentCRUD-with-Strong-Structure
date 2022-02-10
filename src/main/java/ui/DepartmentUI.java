package ui;

import dto.department.DepartmentCreateDto;
import dto.department.DepartmentDto;
import dto.department.DepartmentUpdateDto;
import exceptions.ApiRuntimeException;
import response.Data;
import response.ResponseEntity;
import service.DepartmentService;
import ui.base.AbstractUI;
import uz.jl.utils.Color;
import uz.jl.utils.Input;

import java.util.List;


public class DepartmentUI extends AbstractUI<DepartmentService> {

    public DepartmentUI(DepartmentService service) {
        super(service);
    }

    public void create() {
        try {
            String name = Input.getStr("Enter department's name-> ");
            String phoneNumber = Input.getStr("Enter department's phone number-> ");
            DepartmentCreateDto dto = DepartmentCreateDto
                    .builder()
                    .name(name)
                    .phoneNumber(phoneNumber)
                    .build();
            ResponseEntity<Data<Long>> response = service.create(dto);
            showResponse(Color.GREEN, response.getBody());
        } catch (ApiRuntimeException e) {
            showResponse(e.getMessage());
        }
    }

    public void update() {
        DepartmentUpdateDto dto = new DepartmentUpdateDto();
        String id = Input.getStr("Enter department's id-> ");
        dto.setId(Long.parseLong(id));
        if (Input.getStr("Do you wanna change name? YES/NO: ").toLowerCase().startsWith("y")) {
            String name = Input.getStr("Name-> ");
            dto.setName(name);
        }
        if (Input.getStr("Do you wanna change phone number? YES/NO: ").toLowerCase().startsWith("y")) {
            String phoneNumber = Input.getStr("Phone number-> ");
            dto.setPhoneNumber(phoneNumber);
        }
        try {
            ResponseEntity<Data<Boolean>> response = service.update(dto);
            showResponse(Color.GREEN, response.getBody());
        } catch (ApiRuntimeException e) {
            showResponse(e.getMessage());
        }
    }

    public void delete() {
        try {
            String id = Input.getStr("Enter department id-> ");
            ResponseEntity<Data<Boolean>> response = service.delete(Long.parseLong(id));
            showResponse(Color.GREEN, response.getBody());
        } catch (ApiRuntimeException e) {
            showResponse(e.getMessage());
        }
    }

    public void get() {
        try {
            String id = Input.getStr("Enter department id-> ");
            ResponseEntity<Data<DepartmentDto>> response = service.get(Long.parseLong(id));
            showResponse(Color.GREEN, response.getBody());
        } catch (ApiRuntimeException e) {
            showResponse(e.getMessage());
        }
    }

    public void getAll() {
        try {
            ResponseEntity<Data<List<DepartmentDto>>> response = service.getAll();
            showResponse(Color.GREEN, response.getBody());
        } catch (ApiRuntimeException e) {
            showResponse(e.getMessage());
        }
    }

    public void block() {
        try {
            String id = Input.getStr("Enter department id-> ");
            ResponseEntity<Data<Boolean>> response = service.block(Long.parseLong(id));
            showResponse(Color.GREEN, response.getBody());
        } catch (ApiRuntimeException e) {
            showResponse(e.getMessage());
        }
    }

    public void unblock() {
        try {
            String id = Input.getStr("Enter department id-> ");
            ResponseEntity<Data<Boolean>> response = service.unblock(Long.parseLong(id));
            showResponse(Color.GREEN, response.getBody());
        } catch (ApiRuntimeException e) {
            showResponse(e.getMessage());
        }
    }
}
