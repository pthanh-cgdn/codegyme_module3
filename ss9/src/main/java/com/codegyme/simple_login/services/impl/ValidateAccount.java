package com.codegyme.simple_login.services.impl;

import com.codegyme.simple_login.services.IValidateAccount;

public class ValidateAccount implements IValidateAccount {
    @Override
    public boolean checkLogin(String username, String password) {
        if ("admin".equals(username) && "admin".equals(password)) {
            return true;
        }
        return false;
    }
}
