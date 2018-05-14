package com.example.yeajie.app.original.autocall.model;

import com.example.platform.local.DialEntity;

import org.litepal.crud.DataSupport;

import java.util.List;

/**
 * @author arjen
 */

public class DialContactEntry {
    private List<DialEntity> dialEntities;

    public static DialContactEntry getInstance() {
        return new DialContactEntry();
    }

    public DialContactEntry addContacts() {
        DialEntity dialEntity = new DialEntity();
        dialEntity.setContact("arjen");
        dialEntity.setPhoneNum("18750939509");
        dialEntity.save();

        dialEntity = new DialEntity();
        dialEntity.setContact("test1");
        dialEntity.setPhoneNum("18750939509");
        dialEntity.save();

        dialEntity = new DialEntity();
        dialEntity.setContact("test2");
        dialEntity.setPhoneNum("18750939509");
        dialEntity.save();

        return this;
    }

    public List<DialEntity> getDialEntities() {
        return DataSupport.findAll(DialEntity.class);
    }

}
