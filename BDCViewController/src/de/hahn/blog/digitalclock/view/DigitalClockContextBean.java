package de.hahn.blog.digitalclock.view;


public class DigitalClockContextBean {
    String initTime = null;

    public void setInitTime(String time) {
        this.initTime = time;
    }

    public String getInitTime() {
        return initTime;
    }

    public DigitalClockContextBean() {
        super();
    }
}
