package com.example.yeajie.app.original.autocall.test;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.example.yeajie.app.R;
import com.example.widget.core.LincBaseFragment;
import com.example.widget.core.OnItemClick;
import com.example.widget.util.ToastUtil;

/**
 * @author arjen
 */

public class TestFragment extends LincBaseFragment implements OnItemClick {
    private RecyclerView recyclerView;
    private TestAdapter testAdapter;

    public static TestFragment newInstance() {
        return new TestFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_test;
    }

    @Override
    protected void initView() {
        recyclerView = findViewById(R.id.recycler_view);

        testAdapter = new TestAdapter(this);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
        recyclerView.setAdapter(testAdapter);
    }

    @Override
    public void onItemClick(int position) {
        ToastUtil.showToast(getContext(), "Click: " + (position + 1));
    }
}
