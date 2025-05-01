package com.Ioc.coupling;

public class UserDatabaseProvider implements UserDataProvider {


    @Override
    public String getUserDetails() {
        return "User Details from DatabaseProvider";
    }
}



