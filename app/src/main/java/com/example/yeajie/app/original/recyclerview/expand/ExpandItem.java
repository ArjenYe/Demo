package com.example.yeajie.app.original.recyclerview.expand;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.example.yeajie.app.original.recyclerview.AbstractExpandableItem;

/**
 * @author arjen
 */

public class ExpandItem extends AbstractExpandableItem<ExpandSubItem> implements MultiItemEntity {
    private String itemName;

    public ExpandItem(int index) {
        itemName = "This is" + (index + 1);
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    @Override
    public int getItemType() {
        return ExpandAdapter.TYPE_LEVEL_0;
    }

    @Override
    public int getLevel() {
        return 0;
    }
}
