package com.Ioc.coupling;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IOCExample {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationIocLooseCouplingExample.xml");


        UserManager userManagerWithDB = (UserManager) context.getBean("userManagerWithUserDataProvider");
        System.out.println(userManagerWithDB.getUserInfo());


//        UserDataProvider databaseProvider =new UserDatabaseProvider();
//        UserManager userManagerWithDB = new UserManager(databaseProvider);
//        System.out.println(userManagerWithDB.getUserInfo());



        UserManager webServiceUserManager = (UserManager) context.getBean("userManagerWithWebServiceProvider");
        System.out.println(webServiceUserManager.getUserInfo());


//        UserDataProvider webServiceProvider = new WebServiceProvider();
//        UserManager webServiceUserManager = new UserManager(webServiceProvider);
//        System.out.println(webServiceUserManager.getUserInfo());



        UserManager newDBManager = (UserManager) context.getBean("userManagerWithNewDataBaseProvider");
        System.out.println(newDBManager.getUserInfo());

//        UserDataProvider newDBProvider = new NewDatabaseProvider();
//        UserManager newDBManager = new UserManager(newDBProvider);
//        System.out.println(newDBManager.getUserInfo());

    }
}
