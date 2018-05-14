package com.example.yeajie.app;

import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;

import com.example.yeajie.app.original.coordinator.toolbar.HideToolbarActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author arjen
 */

public class NewItem extends HomeItem {

    private NewItem(@DrawableRes int itemImg, @StringRes int itemSummary, Class launcherClass) {
        this.itemImg = itemImg;
        this.itemSummary = itemSummary;
        this.launcherClass = launcherClass;
    }

    static List<HomeItem> getItems() {
        List<HomeItem> homeItems = new ArrayList<>();
        homeItems.add(new NewItem(R.drawable.ic_phone_forwarded_black_24dp, R.string.text_hide_toolbar, HideToolbarActivity.class));

        return homeItems;
    }
}
