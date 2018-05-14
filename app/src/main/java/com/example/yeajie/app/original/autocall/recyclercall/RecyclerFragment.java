package com.example.yeajie.app.original.autocall.recyclercall;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.yeajie.app.R;
import com.example.yeajie.app.original.autocall.AddContactActivity;
import com.example.yeajie.app.original.autocall.recyclercall.api.RecyclerDialView;
import com.example.yeajie.app.original.autocall.recyclercall.presenter.RecyclerDialPresenter;
import com.example.yeajie.app.original.autocall.recyclercall.presenter.RecyclerDialPresenterImpl;
import com.example.widget.core.LincBaseFragment;
import com.example.widget.core.OnItemClick;
import com.example.widget.util.DividerItemDecoration;
import com.example.platform.local.DialEntity;

import java.util.List;

public class RecyclerFragment extends LincBaseFragment implements RecyclerDialView, OnItemClick {
    private RecyclerView recyclerView;
    private AppCompatButton addContactBtn;
    private RecyclerDialAdapter adapter;
    private RecyclerDialPresenter presenter;

    public static RecyclerFragment newInstance() {
        return new RecyclerFragment();
    }

    @Override
    protected void initView() {
        recyclerView = findViewById(R.id.recycler_view);
        addContactBtn = findViewById(R.id.add_contact_btn);

        adapter = new RecyclerDialAdapter(this);
        presenter = new RecyclerDialPresenterImpl(this);

        initRecyclerView();
        addContactBtn.setOnClickListener(view -> onAddContactClick());
    }

    private void onAddContactClick() {
        Intent intent = new Intent(getContext(), AddContactActivity.class);
        startActivity(intent);
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.loadContact();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_recycler;
    }

    @Override
    public void refreshContacts(List<DialEntity> dialEntities) {
        adapter.setItems(dialEntities);
    }

    @Override
    public void onItemClick(int position) {
        DialEntity dialEntity = adapter.getItem(position);

        String phoneNum = dialEntity.getPhoneNum();
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setData(Uri.parse("tel:" + phoneNum));
        startActivity(intent);
    }

    private void initRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(adapter);
    }
}
