package com.example.uidemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.uidemo.R;
import com.example.uidemo.model.Article;

import java.util.List;


public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ViewHolder> {
    private List<Article> articleList;
    private Context context;

    public ArticleAdapter(List<Article> articleList, Context context) {
        this.articleList = articleList;
        this.context = context;
    }

    @NonNull
    @Override
    public ArticleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.article_rv_layout, parent, false);
        ArticleAdapter.ViewHolder myViewHolder = new ArticleAdapter.ViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleAdapter.ViewHolder holder, int position) {
        Article article=articleList.get(position);
        holder.tvTitle.setText(article.getTitle());
        holder.tvAuther.setText(article.getAuthor());
        holder.tvDescription.setText(article.getDescription());
        Glide.with(context).load(articleList.get(position).getUrlToImage()).apply(new RequestOptions()
                .placeholder(R.drawable.veg)).into(holder.ivCoverImage);


    }

    @Override
    public int getItemCount() {
        return articleList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvTitle,tvAuther,tvDescription;
        private ImageView ivCoverImage;


        public ViewHolder(View itemView) {
            super(itemView);
            tvTitle=itemView.findViewById(R.id.tvTitle);
            tvAuther=itemView.findViewById(R.id.tvAuthorAndPublishedAt);
            tvDescription=itemView.findViewById(R.id.tvDescription);
            ivCoverImage=itemView.findViewById(R.id.imgViewCover);

        }
    }
}