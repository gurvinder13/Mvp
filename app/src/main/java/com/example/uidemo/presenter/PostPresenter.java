package com.example.uidemo.presenter;

import android.content.Context;

import com.example.uidemo.interfaces.PostView;
import com.example.uidemo.model.PostResponse;
import com.example.uidemo.network.BaseRetrofitHandler;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class PostPresenter {
    private final String TAG = PostPresenter.class.getSimpleName();
    private PostView postView;
    private Context mContext;

    /**
     * PostPresenter  Constructor
     *
     * @param mContext
     * @param postView
     */
    public PostPresenter(Context mContext, PostView postView) {
        this.postView = postView;
        this.mContext = mContext;
    }

    /**
     * method to call get post data api
     *
     * @param
     */
    public void getData() {
        Observable<List<PostResponse>> observable = BaseRetrofitHandler.getInstance()
                .apiService.getPost();
        observable.subscribeOn(Schedulers.newThread()).
                observeOn(AndroidSchedulers.mainThread())
                .map(PostResponse -> PostResponse).subscribe(new Observer<List<PostResponse>>() {
            @Override
            public void onSubscribe(Disposable d) {
            }

            @Override
            public void onNext(@NonNull List<PostResponse> postResponses) {
                postView.onPostSuccess(postResponses);
            }


            @Override
            public void onError(Throwable e) {
                postView.onPostFailed(e.getMessage());

            }

            @Override
            public void onComplete() {

            }
        });
    }
}
