package com.example.yeajie.app.original.recyclerview.expand;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.example.yeajie.app.R;

import java.util.List;

/**
 * @author arjen
 */

public class ExpandAdapter extends BaseMultiItemQuickAdapter<MultiItemEntity, BaseViewHolder> {
    public static final int TYPE_LEVEL_0 = 0;
    public static final int TYPE_LEVEL_1 = 1;

    public ExpandAdapter(List<MultiItemEntity> data) {
        super(data);
        addItemType(TYPE_LEVEL_0, R.layout.view_level_0);
        addItemType(TYPE_LEVEL_1, R.layout.view_level_1);
    }

    @Override
    protected void convert(BaseViewHolder holder, MultiItemEntity item) {
        switch (holder.getItemViewType()) {
            case TYPE_LEVEL_0:
                ExpandItem expandItem = (ExpandItem) item;
//                holder.setImageResource(R.id.level_0_img, expandItem.isExpanded() ? R.mipmap.arrow_b : R.mipmap.arrow_r);
                holder.setBackgroundRes(R.id.level_0_img, expandItem.isExpanded()
                        ? R.drawable.ic_arrow_downward_black_24dp : R.drawable.ic_arrow_forward_black_24dp);
                holder.itemView.setOnClickListener(view -> {
                    int position = holder.getAdapterPosition();
                    if (expandItem.isExpanded()) {
                        collapse(position);
                    } else {
                        expand(position);
                    }
                });
                break;

            case TYPE_LEVEL_1:
                ExpandSubItem subItem = (ExpandSubItem) item;
                holder.setText(R.id.move_item_name_text, subItem.getSubItemName())
                        .setBackgroundRes(R.id.item_move_status_img, subItem.isDone()
                                ? R.drawable.ic_check_circle_green_24dp : 0)
                        .addOnClickListener(R.id.root_layout)
                        .addOnClickListener(R.id.show_sn_btn);
                break;
            default:
        }

    }
}
