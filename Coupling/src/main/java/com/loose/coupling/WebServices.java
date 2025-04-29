package com.loose.coupling;

public class WebServices implements DatabaseProvider{

    @Override
    public String getUserDetails() {
        return "Web Services Database";
    }
}
