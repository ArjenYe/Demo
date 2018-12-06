package com.example.yeajie.app.original.autocall.recyclercall;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.platform.local.DialEntity;
import com.example.widget.core.OnItemClick;
import com.example.widget.util.CollectionUtil;
import com.example.widget.util.ImageUtils;
import com.example.yeajie.app.R;

import java.util.List;

/**
 * @author arjen
 */

public class RecyclerDialAdapter extends RecyclerView.Adapter<RecyclerDialViewHolder> {
    private OnItemClick onItemClick;
    private OnDeleteEvent onDeleteEvent;

    private boolean isDeletable;
    private List<DialEntity> dialEntities;

    public RecyclerDialAdapter(OnItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }

    @Override
    public RecyclerDialViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recycler_dial, parent, false);
        return new RecyclerDialViewHolder(view, onItemClick);
    }

    @Override
    public void onBindViewHolder(RecyclerDialViewHolder holder, int position) {
        DialEntity dialEntity = dialEntities.get(position);
        holder.contactTxt.setText(dialEntity.getContact());
        holder.phoneNumTxt.setText(dialEntity.getPhoneNum());
        holder.contactImg.setImageBitmap(ImageUtils.getimage(dialEntity.getPhotoPath()));
        holder.contactItemLayout.setClickable(!isDeletable);
        holder.deleteContactImg.setVisibility(isDeletable ? View.VISIBLE : View.GONE);

        holder.deleteContactImg.setOnClickListener(view -> {
            if (onDeleteEvent != null) {
                onDeleteEvent.onDelete(holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return CollectionUtil.isNullOrEmpty(dialEntities) ? 0 : dialEntities.size();
    }

    public void setItems(List<DialEntity> dialEntities) {
        setItems(dialEntities, false);
    }

    public void setItems(List<DialEntity> dialEntities, boolean isDeletable) {
        this.isDeletable = isDeletable;
        this.dialEntities = dialEntities;
        notifyDataSetChanged();
    }

    public void removeItem(int position) {
        dialEntities.remove(position);
        notifyDataSetChanged();
    }

    public DialEntity getItem(int position) {
        return dialEntities.get(position);
    }

    public void setDeletable(boolean isDeletable) {
        this.isDeletable = isDeletable;
        notifyDataSetChanged();
    }

    public void setOnDeleteEvent(OnDeleteEvent onDeleteEvent) {
        this.onDeleteEvent = onDeleteEvent;
    }

    public interface OnDeleteEvent {
        void onDelete(int position);
    }
}
