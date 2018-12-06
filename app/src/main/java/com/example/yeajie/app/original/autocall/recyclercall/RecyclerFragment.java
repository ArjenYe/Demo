package com.example.yeajie.app.original.autocall.recyclercall;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.platform.local.DialEntity;
import com.example.widget.core.LincBaseFragment;
import com.example.widget.core.OnItemClick;
import com.example.yeajie.app.R;
import com.example.yeajie.app.original.autocall.AddContactActivity;
import com.example.yeajie.app.original.autocall.recyclercall.api.RecyclerDialView;
import com.example.yeajie.app.original.autocall.recyclercall.presenter.RecyclerDialPresenter;
import com.example.yeajie.app.original.autocall.recyclercall.presenter.RecyclerDialPresenterImpl;

import java.util.List;

public class RecyclerFragment extends LincBaseFragment implements RecyclerDialView, OnItemClick {
    private RecyclerView recyclerView;
    private AppCompatButton addContactBtn;
    private AppCompatButton deleteContactBtn;
    private AppCompatButton cancelDeleteBtn;

    private RecyclerDialAdapter adapter;
    private RecyclerDialPresenter presenter;

    public static RecyclerFragment newInstance() {
        return new RecyclerFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_recycler;
    }

    @Override
    protected void initView() {
        presenter = new RecyclerDialPresenterImpl(this);

        initViewLayout();
        initRecyclerView();

        adapter.setOnDeleteEvent(this::showDeleteConfirmDialog);
        addContactBtn.setOnClickListener(view -> startActivity(new Intent(getContext(), AddContactActivity.class)));

        cancelDeleteBtn.setOnClickListener(view -> {
            adapter.setDeletable(false);
            addContactBtn.setVisibility(View.VISIBLE);
            deleteContactBtn.setVisibility(View.VISIBLE);
            cancelDeleteBtn.setVisibility(View.GONE);
        });

        deleteContactBtn.setOnClickListener(view -> {
            adapter.setDeletable(true);
            addContactBtn.setVisibility(View.GONE);
            deleteContactBtn.setVisibility(View.GONE);
            cancelDeleteBtn.setVisibility(View.VISIBLE);
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.loadContact();
    }

    @Override
    public void refreshContacts(List<DialEntity> dialEntities) {
        adapter.setItems(dialEntities);
    }

    @Override
    public void onItemClick(int position) {
        if (isGrantCall(getActivity())) {
            DialEntity dialEntity = adapter.getItem(position);
            String phoneNum = dialEntity.getPhoneNum();
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setData(Uri.parse("tel:" + phoneNum));
            startActivity(intent);
        }
    }

    private void showDeleteConfirmDialog(int adapterPosition) {
        DialEntity dialEntity = adapter.getItem(adapterPosition);
        new AlertDialog.Builder(getActivity())
                .setMessage("删除联系人 " + dialEntity.getContact() + "?")
                .setNegativeButton("取消", (dialogInterface, i) -> dialogInterface.dismiss())
                .setPositiveButton("确定", (dialogInterface, i) -> adapter.removeItem(adapterPosition))
                .show();
    }

    private boolean isGrantCall(Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M
                && activity.checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            activity.requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, 2);
            return false;
        }

        return true;
    }

    private void initRecyclerView() {
        adapter = new RecyclerDialAdapter(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
//        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(adapter);
    }

    private void initViewLayout() {
        recyclerView = findViewById(R.id.recycler_view);
        addContactBtn = findViewById(R.id.add_contact_btn);
        deleteContactBtn = findViewById(R.id.delete_contact_btn);
        cancelDeleteBtn = findViewById(R.id.cancel_delete_btn);
    }
}
