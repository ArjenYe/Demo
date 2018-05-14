package com.example.platform.contactlist;

import android.graphics.Bitmap;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * @author arjen
 */

public class ContactEntry implements Serializable {
    @SerializedName("phoneBitMap")
    public Bitmap phoneBitMap;

    @SerializedName("name")
    public String name;

    @SerializedName("phone")
    public String phone;
}
