package com.example.trainschedule.core.activity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.StringUtils;
import com.example.trainschedule.R;
import com.example.trainschedule.base.BaseActivity;
import com.example.trainschedule.helper.EditTextInputHelper;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * <pre>
 *      @author hurley
 *      date    : 2019/4/9 1:16 PM
 *      github  : https://github.com/HurleyJames
 *      desc    :
 * </pre>
 */
public class LoginActivity extends BaseActivity {

    @BindView(R.id.et_login_username)
    EditText mEtUsername;
    @BindView(R.id.et_login_password)
    EditText mEtPassword;
    @BindView(R.id.btn_login_commit)
    Button mBtnCommit;
    @BindView(R.id.tv_register)
    TextView mTvRegister;
    @BindView(R.id.tv_login_forget)
    TextView mTvForget;

    private EditTextInputHelper mEditTextInputHelper;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        getSupportActionBar().setTitle("");
        mEditTextInputHelper = new EditTextInputHelper(mBtnCommit);
        mEditTextInputHelper.addViews(mEtUsername, mEtPassword);
    }

    @Override
    protected boolean showHomeAsUp() {
        return true;
    }

    @OnClick({R.id.btn_login_commit, R.id.tv_register, R.id.tv_login_forget})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login_commit:
                String username = mEtUsername.getText().toString();
                String password = mEtPassword.getText().toString();
                if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
                    //如果用户名或密码为空
                    toast(R.string.login_username_password_null);
                    return;
                }
                //mPresenter.login(username, password);
                break;
            case R.id.tv_register:
                //跳转至注册界面
                ActivityUtils.startActivity(RegisterActivity.class);
                break;
            case R.id.tv_login_forget:
                break;
            default:
                break;
        }
    }

    private void login(String username, String password) {

    }
}
