import configs.ApplicationContextHolder;
import ui.AuthUserUI;
import ui.DepartmentUI;
import ui.UserUI;
import uz.jl.utils.Input;
import uz.jl.utils.Print;


public class Application {
    private static final UserUI userUI = ApplicationContextHolder.getBean(UserUI.class);
    private static final AuthUserUI authUserUI = ApplicationContextHolder.getBean(AuthUserUI.class);
    private static final DepartmentUI departmentUI = ApplicationContextHolder.getBean(DepartmentUI.class);

    public static void main(String[] args) {
        run();
    }

    public static void run() {

        Print.println("1. LOGIN");
        Print.println("2. User Delete");
        Print.println("3. User Create");
        Print.println("4. User Update");
        Print.println("5. User Get");
        Print.println("6. Users list");
        Print.println("7. Block user");
        Print.println("8. Unblock user");
        Print.println("9. Department Info");
        Print.println("10. Departments list");
        Print.println("11. Create Department");
        Print.println("12. Update Department");
        Print.println("13. Delete Department");
        Print.println("14. LOG OUT");
        Print.println("Exit");


        String choice = Input.getStr("Choose -> ");
        switch (choice) {
            case "1" -> authUserUI.login();
            case "2" -> userUI.delete();
            case "3" -> userUI.create();
            case "4" -> userUI.update();
            case "5" -> userUI.get();
            case "6" -> userUI.getAll();
            case "7" -> userUI.blockUser();
            case "8" -> userUI.unBlockUser();
            case "9" -> departmentUI.get();
            case "10" -> departmentUI.getAll();
            case "11" -> departmentUI.create();
            case "12" -> departmentUI.update();
            case "13" -> departmentUI.delete();
            case "14" -> userUI.logout();
            case "e" -> {
                return;
            }

        }
        run();
    }
}
