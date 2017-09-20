package com.terry.mybasedlib.baseapi;

import android.content.Context;
import android.text.TextUtils;

import com.terry.mybasedlib.utils.Convert;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 *
 */
public abstract class RetrofitManager {

    private static final long REASONABLE_DISK_SIZE = 1024 * 1024; // 1 MB
    private static final int REASONABLE_MEM_ENTRIES = 50; // 50 entries
    private Retrofit retrofit;
    private static String DEFAULT_RX_CACHE;
    private OkHttpClient okHttpClient;
    private LinkedHashMap<String, Retrofit> hashMap = new LinkedHashMap<>();


    public abstract Context getAppContext();

    public abstract String getBaseUrl();

    public abstract String getRxCache();


//    public static RetrofitManager getInstance() {
//        if (instance == null) {
//            synchronized (RetrofitManager.class) {
//                if (instance == null) {
//                    instance = new RetrofitManager();
//                }
//            }
//        }
//        return instance;
//    }


    public RetrofitManager() {
        initOkhttp(getAppContext());
    }


    private void initOkhttp(final Context context) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        //打印请求log日志
//        if (BuildConfig.DEBUG) {
//            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
//            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//            builder.addInterceptor(loggingInterceptor);
//        }
        //设置缓存 默认开启
        File cacheFile = new File(context.getExternalCacheDir(), getRxCache());
        Cache cache = new Cache(cacheFile, 1024 * 1024 * 50);
//        Interceptor cacheInterceptor = new CacheInterceptor(context, true);
        builder.cache(cache);
//        builder.interceptors().add(cacheInterceptor);//添加本地缓存拦截器，用来拦截本地缓存
//        builder.networkInterceptors().add(cacheInterceptor);//添加网络拦截器，用来拦截网络数据
        builder.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                return null;
            }
        });
        //设置超时
        builder.connectTimeout(15, TimeUnit.SECONDS);
        builder.readTimeout(20, TimeUnit.SECONDS);
        builder.writeTimeout(20, TimeUnit.SECONDS);
        //错误重连
        builder.retryOnConnectionFailure(true);


        okHttpClient = builder.build();

    }


    public Retrofit getRetrofit(String baseUrl) {
        String url = !TextUtils.isEmpty(baseUrl) ? baseUrl : getBaseUrl();
        if (hashMap.get(url) == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .client(okHttpClient)
//                    .addCallAdapterFactory(RxCacheCallAdapterFactory.create(getBaseCache(), false))
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create(Convert.create()))
                    .build();
            hashMap.put(url, retrofit);
        } else {
            return hashMap.get(url);
        }
        return retrofit;
    }

    public Retrofit getRetrofit() {
        return getRetrofit(null);


    }

    public Retrofit getRetrofitString(String baseUrl) {
        String url = !TextUtils.isEmpty(baseUrl) ? baseUrl : getBaseUrl();
        if (hashMap.get(url) == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .client(okHttpClient)
//                    .addCallAdapterFactory(RxCacheCallAdapterFactory.create(getBaseCache(), false))
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .build();
            hashMap.put(url, retrofit);
        } else {
            return hashMap.get(url);
        }
        return retrofit;


    }


}