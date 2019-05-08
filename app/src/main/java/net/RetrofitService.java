package net;

import bean.UserBean;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RetrofitService {

    @GET("/users/{user}")
    Observable<UserBean> getUser(@Path("user") String user);
}
