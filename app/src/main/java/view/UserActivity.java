package view;

import android.os.Bundle;
import android.widget.TextView;

import com.lucky.javamvp.R;

import base.BaseMvpActivity;
import bean.UserBean;
import presenter.UserPresenter;

public class UserActivity extends BaseMvpActivity<UserView, UserPresenter> implements UserView {

    private TextView mNameTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mNameTv = findViewById(R.id.tv);

        getPresenter().getUser("JakeWharton");
    }

    @Override
    public UserPresenter createPresenter() {
        return new UserPresenter();
    }

    @Override
    public UserView createView() {
        return this;
    }

    @Override
    public void onGetUser(UserBean userBean) {
        mNameTv.setText(userBean.getLogin());
    }
}
