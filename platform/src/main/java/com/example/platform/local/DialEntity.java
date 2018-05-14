package com.example.platform.local;

import org.litepal.crud.DataSupport;

/**
 * @author arjen
 */

public class DialEntity extends DataSupport {
    private int id;
    private String contact;
    private String phoneNum;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
}
