package com.example.widget.core;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.widget.R;


public abstract class LincBaseFragment extends Fragment {
    protected View rootView;
    protected FragmentActivity fragmentActivity;

    public LincBaseFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (null == rootView) {
            rootView = inflater.inflate(getLayoutId(), container, false);
        }
        initView();
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        fragmentActivity = getActivity();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    protected abstract int getLayoutId();

    public CharSequence getTabTitle() {
        return "";
    }

    public int getTabTitleResource() {
        return R.string.unknown_tab_title;
    }

    protected abstract void initView();

    public <T extends View> T findViewById(int viewId) {
        return (T) rootView.findViewById(viewId);
    }
}
