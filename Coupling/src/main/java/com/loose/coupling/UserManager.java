package com.loose.coupling;

public class UserManager {
   private DatabaseProvider databaseProvider;

    public UserManager(DatabaseProvider databaseProvider) {
        this.databaseProvider = databaseProvider;
    }

    public String userInfo(){
        return databaseProvider.getUserDetails();
    }
}
