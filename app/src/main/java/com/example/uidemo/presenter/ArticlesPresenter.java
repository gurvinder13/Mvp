package com.example.uidemo.presenter;

import android.content.Context;

import com.example.uidemo.interfaces.ArticleView;
import com.example.uidemo.model.ArticleResponse;
import com.example.uidemo.network.BaseRetrofitHandler;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ArticlesPresenter {
    private final String TAG = ArticlesPresenter.class.getSimpleName();
    private ArticleView articleView;
    private Context mContext;

    /**
     * ArticlesPresenter  Constructor
     *
     * @param mContext
     * @param articleView
     */
    public ArticlesPresenter(Context mContext, ArticleView articleView) {
        this.articleView = articleView;
        this.mContext = mContext;
    }

    /**
     * method to call get articles data api
     *
     * @param
     */
    public void getData(String sources, String apiKey) {
        Observable<ArticleResponse> observable = BaseRetrofitHandler.getInstance()
                .apiService.getArticle(sources, apiKey);
        observable.subscribeOn(Schedulers.newThread()).
                observeOn(AndroidSchedulers.mainThread())
                .map(ArticleResponse -> ArticleResponse).subscribe(new Observer<ArticleResponse>() {
            @Override
            public void onSubscribe(Disposable d) {
            }

            @Override
            public void onNext(ArticleResponse articleResponse) {
                articleView.onArticleSuccess(articleResponse);
            }

            @Override
            public void onError(Throwable e) {
                articleView.onArticleFailed(e.getMessage());

            }

            @Override
            public void onComplete() {

            }
        });
    }
}
