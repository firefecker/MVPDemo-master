package com.autismbug.mvpdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.autismbug.mvpdemo.login.bean.User;
import com.autismbug.mvpdemo.login.presenter.UserLoginPresenter;
import com.autismbug.mvpdemo.login.view.IUserLoginView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UserLoginActivity extends AppCompatActivity implements IUserLoginView {

    @BindView(R.id.username_edit)
    EditText mUsernameEdit;
    @BindView(R.id.password_edit)
    EditText mPasswordEdit;
    @BindView(R.id.login_button)
    Button mLoginButton;
    @BindView(R.id.clear_button)
    Button mClearButton;
    @BindView(R.id.loading_progress)
    ProgressBar mLoadingProgress;

    private UserLoginPresenter mUserLoginPresenter = new UserLoginPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);
        ButterKnife.bind(this);
    }

    @Override
    public String getUserName() {
        return mUsernameEdit.getText().toString();
    }

    @Override
    public String getPassWord() {
        return mPasswordEdit.getText().toString();
    }

    @Override
    public void showLoading() {
        mLoadingProgress.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mLoadingProgress.setVisibility(View.GONE);
    }

    @Override
    public void toMainActiviy(User user) {
        Toast.makeText(this,
                user.getUsername() + " login success , to MainActivity", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showFailedError() {
        Toast.makeText(this,
                "login failed", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void clearUserName() {
        mUsernameEdit.setText("");
    }

    @Override
    public void clearPassWord() {
        mPasswordEdit.setText("");
    }

    @OnClick({R.id.login_button, R.id.clear_button})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.login_button:
                mUserLoginPresenter.login();
                break;
            case R.id.clear_button:
                mUserLoginPresenter.clear();
                break;
        }
    }
}
