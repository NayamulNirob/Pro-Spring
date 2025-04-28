package com.loose.coupling;

public class LooseCouplingExample {
    public static void main(String[] args) {

        UserDataProvider databaseProvider =new UserDatabaseProvider();
        UserManager userManagerWithDB = new UserManager(databaseProvider);
        System.out.println(userManagerWithDB.getUserInfo());


        UserDataProvider webServiceProvider = new WebServiceProvider();
        UserManager webServiceUserManager = new UserManager(webServiceProvider);
        System.out.println(webServiceUserManager.getUserInfo());



        UserDataProvider newDBProvider = new NewDatabaseProvider();
        UserManager newDBManager = new UserManager(newDBProvider);
        System.out.println(newDBManager.getUserInfo());

    }
}
