package com.example.platform.http.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * @author arjen
 */

public class BookEntry implements Serializable {
    @SerializedName("count")
    public int count;
}
