package base;

import android.os.Bundle;

import androidx.annotation.Nullable;

//不需要Mvp的Activity的直接继承BaseActivity
public abstract class BaseMvpActivity<V extends IBaseView, P extends BasePresenter<V>> extends BaseActivity {

    private P presenter;
    private V view;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (presenter == null) {
            presenter = createPresenter();
        }

        if (view == null) {
            view = createView();
        }

        if (presenter != null && view != null) {
            presenter.attachView(view);
        }
    }

    public abstract P createPresenter();

    public abstract V createView();

    public P getPresenter() {
        return presenter;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null && view != null) {
            presenter.detachView();
        }
    }
}
