package ui.base;

import com.google.gson.Gson;
import configs.ApplicationContextHolder;
import security.SecurityHolder;
import service.base.BaseGenericService;
import uz.jl.utils.Color;
import uz.jl.utils.Print;

import java.util.Objects;

public abstract class AbstractUI<S extends BaseGenericService> {
    protected S service;



    public AbstractUI(S service) {
        this.service = service;
    }

    protected <T> void showResponse(T response) {
        showResponse(Color.RED, response);
    }

    protected <T> void showResponse(String color, T response) {
        Print.println(color, ApplicationContextHolder.getBean(Gson.class).toJson(response));
    }

    protected boolean isSession(){
        return Objects.nonNull(SecurityHolder.session);
    }
}
