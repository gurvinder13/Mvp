package com.example.uidemo.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.uidemo.R;
import com.example.uidemo.adapter.ArticleAdapter;
import com.example.uidemo.interfaces.ArticleView;
import com.example.uidemo.model.ArticleResponse;
import com.example.uidemo.presenter.ArticlesPresenter;

public class MainActivity extends AppCompatActivity implements ArticleView {
    private RecyclerView recyclerView;
    private ArticlesPresenter articlesPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rv_article);
        articlesPresenter=new ArticlesPresenter(this,this);
        LinearLayoutManager manager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
        articlesPresenter.getData("techcrunch","6660de72ec7b49af9f8e74824e20d06c");
    }

    @Override
    public void onArticleSuccess(ArticleResponse articleResponse) {
        ArticleAdapter articleAdapter = new ArticleAdapter(articleResponse.getArticles(), this);
        recyclerView.setAdapter(articleAdapter);
        articleAdapter.notifyDataSetChanged();
    }

    @Override
    public void onArticleFailed(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }
}