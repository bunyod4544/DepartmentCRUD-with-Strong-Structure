package security;

import dto.user.UserDto;


public class SecurityHolder {
    public static UserDto session;

    public static void setSessionUser(UserDto authUser) {
        session = authUser;
    }

    public static void killSession() {
        session = null;
    }
}
