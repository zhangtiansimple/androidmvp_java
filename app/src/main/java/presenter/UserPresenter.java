package presenter;

import base.BasePresenter;
import bean.UserBean;
import module.UserModule;
import view.UserView;

public class UserPresenter extends BasePresenter<UserView> {
    private UserModule userModule;

    public UserPresenter() {
        this.userModule = new UserModule();
    }

    public void getUser(String userName) {
        userModule.getUser(userName, new UserModule.CallBackListener() {
            @Override
            public void onSuccess(UserBean userBean) {
                if (getView() != null) {
                    getView().onGetUser(userBean);
                }
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }
}
