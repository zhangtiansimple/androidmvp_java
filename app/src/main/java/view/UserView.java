package view;

import base.IBaseView;
import bean.UserBean;

public interface UserView extends IBaseView {

    void onGetUser(UserBean userBean);
}
