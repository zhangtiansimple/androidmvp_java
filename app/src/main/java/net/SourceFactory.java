package net;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class SourceFactory {

    private volatile static SourceFactory mInstance;

    public static SourceFactory getInstance() {
        if (mInstance == null) {
            synchronized (SourceFactory.class) {
                if (mInstance == null) {
                    mInstance = new SourceFactory();
                }
            }
        }
        return mInstance;
    }

    private static Retrofit mRetrofit;

    private SourceFactory() {
        OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .build();

        mRetrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public RetrofitService create() {
        return mRetrofit.create(RetrofitService.class);
    }
}
