package com.tight.coupling;

public class TightCoupling {
    public static void main(String[] args) {
        UserManager userManager = new UserManager();
        System.out.println(userManager.userInfo());
    }
}
