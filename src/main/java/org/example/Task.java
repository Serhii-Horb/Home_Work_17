package org.example;

/* 1 уровень сложности: Создать статический метод который принимает на вход три параметра: login, password и confirmPassword.

Login:
1) Длина login должна быть меньше 20 символов и начинаться с латинской буквы.
2*) Login должен содержать только латинские буквы, цифры и знак подчеркивания.
Если login не соответствует этим требованиям, необходимо выбросить WrongLoginException.

Password:
1) Длина password должна быть меньше 20 символов.
2*) Должен содержать только латинские буквы, цифры.
Также password и confirmPassword должны быть равны.
Если password не соответствует этим требованиям, необходимо выбросить WrongPasswordException.

WrongPasswordException и WrongLoginException - пользовательские классы исключения с конструкторами:
1) один по умолчанию;
2*) второй принимает сообщение исключения и передает его в конструктор класса Exception.

Метод возвращает true, если значения верны или false в другом случае.
Обработка исключений проводится в вызывающем методе. */
public class Task {
    public static void main(String[] args) throws WrongLoginException, WrongPasswordException {
        if (isUserRegistration("login", "password", "password")) {
            System.out.println("Check passed");
        }
    }

    public static boolean isUserRegistration(String login, String password, String confirmPassword)
            throws WrongLoginException, WrongPasswordException {
        if (login.length() >= 20 || !Character.isLetter(login.charAt(0)) || !login.matches("[a-zA-Z0-9_]+")) {
            throw new WrongLoginException("Login is not valid");
        }
        if (password.length() >= 20 || !password.matches("^[a-zA-Z0-9]*$") || !password.equals(confirmPassword)) {
            throw new WrongPasswordException("Password is not valid");
        }
        return true;
    }
}