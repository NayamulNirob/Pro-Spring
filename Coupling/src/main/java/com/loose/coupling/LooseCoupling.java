package com.loose.coupling;

public class LooseCoupling {
    public static void main(String[] args) {

        DatabaseProvider databaseProvider =new UserDatabase();
        UserManager userManager = new UserManager(databaseProvider);
        System.out.println(userManager.userInfo());

        WebServices webService = new WebServices();
        UserManager userManager2 = new UserManager(webService);
        System.out.println(userManager2.userInfo());

    }
}
