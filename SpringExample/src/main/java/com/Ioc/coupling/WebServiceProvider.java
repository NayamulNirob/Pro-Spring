package com.Ioc.coupling;

public class WebServiceProvider implements UserDataProvider {
    @Override
    public String getUserDetails() {
        return "Fetching Data From WebService";
    }
}
