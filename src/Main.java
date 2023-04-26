import exception.WrongLoginException;
import exception.WrongPasswordException;


public class Main {
    public static void main(String[] args) {
        String login = "qweqweqw123";
        String password = "Jokersaw233";
        String confirmPassword = "Unsu_e2";
        System.out.println(check(login,password,confirmPassword));
        System.out.println();
    }

    public static boolean included(String str) {
        String alp = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890_";
        for (int i = 0; i < str.length(); i++) {
            if (!(alp.contains(Character.toString(str.charAt(i))))) {
                return false;
            }
        }
        return true;
    }


    public static boolean check(String login, String password, String confirmPassword) {
        try {
            if (!(login.length() <= 20)) {
                throw new WrongLoginException("Логин слишком длинный ");
            }
            boolean a = included(login);
            if (!a) {
                throw new WrongLoginException("Логин не соответствует требованиям ");
            }
            if (!(password.length() < 20)) {
                throw new WrongPasswordException("Пароль слишком длинный ");
            }
            boolean b = included(password);
            if (!b) {
                throw new WrongPasswordException("Пароль не соответствует требованиям ");
            }
            if (!password.equals(confirmPassword)) {
                throw new WrongPasswordException("Пароли не совпадают");
            }
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

}