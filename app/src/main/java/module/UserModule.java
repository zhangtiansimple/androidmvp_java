package module;

import net.BaseSubscriber;
import net.SourceFactory;

import bean.UserBean;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class UserModule {

    public interface CallBackListener {
        void onSuccess(UserBean userBean);

        void onFailure(Throwable t);
    }

    public void getUser(String userName, final CallBackListener listener) {
        SourceFactory.getInstance().create()
                .getUser(userName)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseSubscriber<UserBean>() {

                    @Override
                    public void onSuccess(UserBean userBean) {
                        if (listener != null) {
                            listener.onSuccess(userBean);
                        }
                    }

                    @Override
                    public void onFailure(Throwable t) {
                        if (listener != null) {
                            listener.onFailure(t);
                        }
                    }
                });
    }

}
