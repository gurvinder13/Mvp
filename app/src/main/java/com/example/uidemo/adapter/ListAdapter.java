package com.example.uidemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uidemo.R;
import com.example.uidemo.model.UserPostList;

import java.util.List;


public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    private List<UserPostList> userPostLists;
    private Context context;

    public ListAdapter(List<UserPostList> userPostLists, Context context) {
        this.userPostLists = userPostLists;
        this.context = context;
    }

    @NonNull
    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rv_layout, parent, false);
        ListAdapter.ViewHolder myViewHolder = new ListAdapter.ViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ListAdapter.ViewHolder holder, int position) {
        UserPostList list = userPostLists.get(position);
        holder.tvTitle.setText("Title: -" + list.getTitle());
        holder.tvBody.setText("Body: -"+list.getBody());
        holder.tvCompany.setText("Company: -"+list.getCompany());
    }

    @Override
    public int getItemCount() {
        return userPostLists.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvTitle, tvBody, tvCompany;

        public ViewHolder(View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvBody = itemView.findViewById(R.id.tvBody);
            tvCompany = itemView.findViewById(R.id.tvCompany);

        }
    }
}