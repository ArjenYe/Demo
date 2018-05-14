package com.example.yeajie.app.original.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.View;

import com.example.widget.util.ToastUtil;
import com.example.yeajie.app.R;

/**
 * @author arjen
 */

public class MyDialogFragment extends DialogFragment {

//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater,
//                             @Nullable ViewGroup container,
//                             @Nullable Bundle savedInstanceState) {
//        return inflater.inflate(R.layout.view_login, container);
//    }

    /**
     * ↑↑↑↑↑↑↑↑↑   or   ↓↓↓↓↓↓↓↓↓
     */

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View view = getActivity().getLayoutInflater().inflate(R.layout.view_login, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity())
                .setView(view)
                .setTitle("Login")
                .setNegativeButton(R.string.btn_cancel, (dialog, i) -> dialog.dismiss())
                .setPositiveButton(R.string.btn_ok, (dialog, i) ->
                        ToastUtil.showToast(getActivity(), "Login success"));
        return builder.create();
    }
}