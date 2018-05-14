package com.example.yeajie.app.original.autocall.test;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yeajie.app.R;
import com.example.widget.core.OnItemClick;

import java.util.Arrays;
import java.util.List;

/**
 * @author arjen
 */

public class TestAdapter extends RecyclerView.Adapter<TestViewHolder> {
    private OnItemClick onItemClick;
    private List<String> btnNames = Arrays.asList("1", "2", "3", "4", "5", "6", "7");

    public TestAdapter(OnItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }

    @Override
    public TestViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_test, parent, false);
        return new TestViewHolder(view, onItemClick);
    }

    @Override
    public void onBindViewHolder(TestViewHolder holder, int position) {
        holder.testBtn.setText(btnNames.get(position));
    }

    @Override
    public int getItemCount() {
        return btnNames.size();
    }
}
