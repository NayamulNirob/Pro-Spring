package com.loose.coupling;

public class UserDatabase implements DatabaseProvider{

    @Override
    public String getUserDetails() {
        return "User Database Details By Provider";
    }
}
