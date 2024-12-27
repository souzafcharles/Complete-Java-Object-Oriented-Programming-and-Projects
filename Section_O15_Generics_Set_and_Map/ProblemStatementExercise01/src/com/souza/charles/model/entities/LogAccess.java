package com.souza.charles.model.entities;

import java.time.Instant;
import java.util.Objects;

public class LogAccess {
    private String userName;
    private Instant moment;

    public LogAccess(String userName, Instant moment) {
        this.userName = userName;
        this.moment = moment;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        LogAccess logAccess = (LogAccess) o;
        return Objects.equals(userName, logAccess.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(userName);
    }
}
