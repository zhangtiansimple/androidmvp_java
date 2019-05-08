package base;

public class BasePresenter<T extends IBaseView> {

    private T view;

    public void attachView(T view) {
        this.view = view;
    }

    public void detachView() {
        this.view = null;
    }

    public T getView() {
        return view;
    }
}
