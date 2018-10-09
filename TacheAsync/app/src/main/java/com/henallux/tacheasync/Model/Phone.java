package com.henallux.tacheasync.Model;

public class Phone {
    public String home;
    public String mobile;

    public Phone(){
    }
    public Phone(String home, String mobile) {
        this.home = home;
        this.mobile = mobile;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
