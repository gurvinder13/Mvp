package com.example.uidemo.interfaces;

import com.example.uidemo.model.ArticleResponse;

public interface ArticleView {
    void onArticleSuccess(ArticleResponse articleResponse);

    void onArticleFailed(String error);
}
