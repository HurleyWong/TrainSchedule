package com.example.trainschedule.core.activity;

import android.widget.Button;
import android.widget.EditText;

import com.blankj.utilcode.util.StringUtils;
import com.example.trainschedule.R;
import com.example.trainschedule.base.BaseActivity;
import com.example.trainschedule.helper.EditTextInputHelper;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * <pre>
 *      @author hurley
 *      date    : 2019/4/9 1:42 PM
 *      github  : https://github.com/HurleyJames
 *      desc    :
 * </pre>
 */
public class RegisterActivity extends BaseActivity {

    @BindView(R.id.et_register_username)
    EditText mEtUserName;
    @BindView(R.id.et_register_password)
    EditText mEtPassword;
    @BindView(R.id.et_register_confirm_password)
    EditText mEtConfirmPassword;
    @BindView(R.id.btn_register_commit)
    Button mBtnRegister;

    private EditTextInputHelper mEditTextInputHelper;

    @Override
    protected int getLayoutId() {
        return R.layout.register_activity;
    }

    @Override
    protected void initView() {
        getSupportActionBar().setTitle("");
        mEditTextInputHelper = new EditTextInputHelper(mBtnRegister);
        mEditTextInputHelper.addViews(mEtUserName, mEtPassword, mEtConfirmPassword);
    }

    @Override
    protected boolean showHomeAsUp() {
        return true;
    }

    @OnClick(R.id.btn_register_commit)
    public void onClick() {
        String username = mEtUserName.getText().toString().trim();
        String password = mEtPassword.getText().toString().trim();
        String repassword = mEtConfirmPassword.getText().toString().trim();
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password) || StringUtils.isEmpty(repassword)) {
            //如果用户名或密码为空
            toast(R.string.login_username_password_null);
            return;
        }
        if (!password.equals(repassword)) {
            //如果密码与确认密码不一致
            toast(R.string.confirm_password_input_error);
            return;
        }
        //mPresenter.register(username, password, repassword);
    }
}
