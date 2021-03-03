package com.example.uidemo.presenter;

import android.content.Context;

import com.example.uidemo.interfaces.UserView;
import com.example.uidemo.model.UserResponse;
import com.example.uidemo.network.BaseRetrofitHandler;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class UserPresenter {
    private final String TAG = UserPresenter.class.getSimpleName();
    private UserView userView;
    private Context mContext;

    /**
     * UserPresenter  Constructor
     *
     * @param mContext
     * @param userView
     */
    public UserPresenter(Context mContext, UserView userView) {
        this.userView = userView;
        this.mContext = mContext;
    }

    /**
     * method to call get user data api
     *
     * @param
     */
    public void getData() {
        Observable<List<UserResponse>> observable = BaseRetrofitHandler.getInstance()
                .apiService.getUser();
        observable.subscribeOn(Schedulers.newThread()).
                observeOn(AndroidSchedulers.mainThread())
                .map(UserResponse -> UserResponse).subscribe(new Observer<List<UserResponse>>() {
            @Override
            public void onSubscribe(Disposable d) {
            }

            @Override
            public void onNext(@NonNull List<UserResponse> userResponses) {
                userView.onUserSuccess(userResponses);

            }


            @Override
            public void onError(Throwable e) {
                userView.onUserFailed(e.getMessage());

            }

            @Override
            public void onComplete() {

            }
        });
    }
}
