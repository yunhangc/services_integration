package com.afm.notify.domain;

/**
 * Created by rchen on 2/19/16.
 */
public class Service {

    String name;
    String callBack;

    public String getCallBack() {
        return callBack;
    }

    public void setCallBack(String callBack) {
        this.callBack = callBack;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Service(String name, String callBack) {
        this.name = name;
        this.callBack = callBack;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Service service = (Service) o;

        return !(name != null ? !name.equals(service.name) : service.name != null);

    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
