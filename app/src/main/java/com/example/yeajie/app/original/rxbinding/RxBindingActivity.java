package com.example.yeajie.app.original.rxbinding;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.text.TextUtils;
import android.widget.CheckBox;

import com.example.widget.util.ToastUtil;
import com.example.yeajie.app.R;
import com.jakewharton.rxbinding.view.RxView;
import com.jakewharton.rxbinding.widget.RxCompoundButton;
import com.jakewharton.rxbinding.widget.RxTextView;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Observer;

/**
 * @author arjen
 */

public class RxBindingActivity extends FragmentActivity {
    private AppCompatButton loginBtn;
    private CheckBox checkBox;
    private AppCompatEditText userNameEdit;
    private AppCompatEditText passwordEdit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_binding);
        initViewLayout();

        //重复点击
        RxView.clicks(loginBtn).throttleFirst(2, TimeUnit.SECONDS)
                .subscribe(o -> ToastUtil.showToast(this, "Login click..."));

        //响应式界面
        RxCompoundButton.checkedChanges(checkBox)
                .subscribe(aBoolean -> {
                    loginBtn.setClickable(aBoolean);
                    loginBtn.setBackgroundColor(aBoolean ? Color.GREEN : Color.GRAY);
                });

        //合并最近N个结点
        Observable<CharSequence> userNameObservable = RxTextView.textChanges(userNameEdit).skip(1);
        Observable<CharSequence> passwordObservable = RxTextView.textChanges(passwordEdit).skip(1);
        Observable.combineLatest(userNameObservable, passwordObservable, (charSequence, charSequence2) -> {
            if (TextUtils.isEmpty(charSequence)) {
                userNameEdit.setError("Incorrect User Name");
            }

            if (TextUtils.isEmpty(charSequence)) {
                passwordEdit.setError("Incorrect password");
            }
            return !TextUtils.isEmpty(charSequence) && !TextUtils.isEmpty(charSequence2);

        }).subscribe(new Observer<Boolean>() {
            @Override
            public void onCompleted() {
                loginBtn.setClickable(true);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Boolean aBoolean) {

            }
        });


        //遍历数组、List
/*        String[] names = {"151f1f", "few1f51", "fefef"};
        List<String> names = Arrays.asList("jflsdk", "dsflkjs", "fjdlsk");
        Observable.from(names)
                .subscribe(s -> System.out.println("================================== " + s));*/
/*        List<User> userList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            User user = new User(i);
            userList.add(user);
        }
        Observable.from(userList)
                .subscribe(user -> System.out.println("=================================" + user.id));*/

        //定时操作 —— 3s后执行
/*        Observable.timer(3, TimeUnit.SECONDS)
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onCompleted() {
                        Log.d("RxBinding", "**********************onCompleted***********************");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("RxBinding", "*************************onError************************");
                    }

                    @Override
                    public void onNext(Long aLong) {
                        Log.d("RxBinding", "*************************onNext*************************");
                    }
                });*/

        //周期性操作
/*        Observable.interval(5, TimeUnit.SECONDS)
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onCompleted() {
                        ToastUtil.showToast("onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        ToastUtil.showToast("onError");
                    }

                    @Override
                    public void onNext(Long aLong) {
                        ToastUtil.showToast("onNext");
                    }
                });*/
    }

    private void initViewLayout() {
        loginBtn = (AppCompatButton) findViewById(R.id.login_btn);
        checkBox = (CheckBox) findViewById(R.id.check_box);
        userNameEdit = (AppCompatEditText) findViewById(R.id.input_username_edt);
        passwordEdit = (AppCompatEditText) findViewById(R.id.input_password_edt);
    }

    class User {
        private int id;

        User(int id) {
            this.id = id;
        }
    }
}
