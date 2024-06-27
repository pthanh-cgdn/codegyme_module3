package com.codegyme.simple_login.services;

public interface IValidateAccount {
    boolean checkLogin(String username, String password);
}
