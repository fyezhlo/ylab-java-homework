package com.ylab.homework.hw3.passwordValidator;

import java.util.regex.Pattern;

public class PasswordValidator {
    public static boolean validate(String login, String password, String confirmPassword) {

        return isLoginValid(login) && isPasswordValid(password, confirmPassword);
    }

    private static boolean isLoginValid(String login) {
        String regex = "[a-zA-Z0-9_]{0,19}";
        Pattern pattern = Pattern.compile(regex);
        if (login.length() >= 20) {
            try {
                throw new WrongLoginException("Логин слишком длинный");
            } catch (Exception e) {
                System.out.println(e.getMessage());;
            }
            return false;
        } else if (!pattern.matcher(login).matches()) {
            try {
                throw new WrongLoginException("Логин содержит недопустимые символы");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            return false;
        } else {
            return true;
        }
    }

    private static boolean isPasswordValid(String password, String confirmPassword) {
        String regex = "[a-zA-Z0-9_]{0,19}";
        if (password.length() >= 20) {
            try {
                throw new WrongPasswordException("Пароль слишком длинный");
            } catch (Exception e) {
                System.out.println(e.getMessage());;
            }
            return false;
        } else if (!Pattern.matches(regex, password)) {
            try {
                throw new WrongPasswordException("Пароль содержит недопустимые символы");
            } catch (Exception e) {
                System.out.println(e.getMessage());;
            }
            return false;
        } else if (!password.equals(confirmPassword)) {
            try {
                throw new WrongPasswordException("Пароль и подтверждение не совпадают");
            } catch (Exception e) {
                System.out.println(e.getMessage());;
            }
            return false;
        } else {
            return true;
        }
    }
}
