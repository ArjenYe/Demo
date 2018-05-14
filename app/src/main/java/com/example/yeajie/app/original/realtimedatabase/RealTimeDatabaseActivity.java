package com.example.yeajie.app.original.realtimedatabase;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;

import com.example.widget.util.ToastUtil;
import com.example.yeajie.app.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


/**
 * @author arjen
 */

public class RealTimeDatabaseActivity extends FragmentActivity {
    private static final String TAG = RealTimeDatabaseActivity.class.getSimpleName();
    private Toolbar toolbar;
    private AppCompatTextView messageTxt;
    private TextInputEditText messageInputEdit;
    private AppCompatButton saveBtn;
    private AppCompatButton getDataBtn;
    private AppCompatTextView dataTxt;

    private FirebaseDatabase database;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_real_time_database);
        initViewLayout();

        database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference("message");

        saveBtn.setOnClickListener(view -> {

            String str = messageInputEdit.getText().toString().trim();
            if (TextUtils.isEmpty(str)) {
                ToastUtil.showErrorToast("还没输入要存储的内容嘞");
                return;
            }

            myRef.setValue(str);
        });

        myRef.child("1").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
//                HashMap<String, String> data = (HashMap<String, String>) dataSnapshot.getValue();
                String value = dataSnapshot.getValue(String.class);
                messageTxt.setText("显示：" + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                ToastUtil.showErrorToast("获取异常");
                Log.e(TAG, error.toException().toString());
            }
        });

        getDataBtn.setOnClickListener(view -> myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                dataTxt.setText(String.valueOf(dataSnapshot.getValue()));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        }));
    }

    private void initViewLayout() {
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        messageTxt = (AppCompatTextView) findViewById(R.id.message_txt);
        messageInputEdit = (TextInputEditText) findViewById(R.id.message_input_edit);
        saveBtn = (AppCompatButton) findViewById(R.id.save_btn);
        getDataBtn = (AppCompatButton) findViewById(R.id.get_data_btn);
        dataTxt = (AppCompatTextView) findViewById(R.id.data_txt);
    }
}
