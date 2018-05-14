package com.example.yeajie.app.original.recyclerview.expand;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * @author arjen
 */

public class ExpandSubItem implements MultiItemEntity {
    private int snSize = 0;
    private boolean done;
    private String subItemName;

    public ExpandSubItem(int index) {
        subItemName = "Sub item: " + (index + 1);
        snSize = index + 1;
        done = (index + 1) % 2 == 0;
    }

    public String getSubItemName() {
        return subItemName + (done ? "EA" : "BOX");
    }

    public int getSnSize() {
        return snSize;
    }

    public boolean isDone() {
        return done;
    }

    public void setSubItemName(String subItemName) {
        this.subItemName = subItemName;
    }

    @Override
    public int getItemType() {
        return ExpandAdapter.TYPE_LEVEL_1;
    }
}
