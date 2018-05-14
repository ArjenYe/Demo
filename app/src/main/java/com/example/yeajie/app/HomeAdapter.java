package com.example.yeajie.app;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.widget.util.CollectionUtil;

import java.util.List;

/**
 * @author arjen
 */

public class HomeAdapter extends RecyclerView.Adapter<HomeViewHolder> {
    private Context context;
    private List<HomeItem> items;

    @Override
    public HomeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_home_item, parent, false);
        return new HomeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(HomeViewHolder holder, int position) {
        HomeItem homeItem = items.get(position);
        if (homeItem.itemSummary != 0) {
            holder.itemNameTxt.setText(homeItem.itemSummary);
        }

        if (homeItem.itemImg != 0) {
            holder.itemImg.setBackgroundResource(homeItem.itemImg);
        }

        if (homeItem.launcherClass != null) {
            holder.itemLayout.setOnClickListener(view ->
                    context.startActivity(new Intent(context, homeItem.launcherClass)));
        }
    }

    @Override
    public int getItemCount() {
        return CollectionUtil.isNullOrEmpty(items) ? 0 : items.size();
    }

    public void setItems(List<HomeItem> items) {
        this.items = items;
        notifyDataSetChanged();
    }
}
