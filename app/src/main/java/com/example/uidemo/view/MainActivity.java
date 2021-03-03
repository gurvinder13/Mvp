package com.example.uidemo.view;

import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uidemo.R;
import com.example.uidemo.adapter.ListAdapter;
import com.example.uidemo.interfaces.PostView;
import com.example.uidemo.interfaces.UserView;
import com.example.uidemo.model.PostResponse;
import com.example.uidemo.model.UserPostList;
import com.example.uidemo.model.UserResponse;
import com.example.uidemo.presenter.PostPresenter;
import com.example.uidemo.presenter.UserPresenter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements PostView, UserView {
    private RecyclerView recyclerView;
    private UserPresenter userPresenter;
    private PostPresenter postPresenter;
    private int id;
    private int userId;
    private int postId;
    private List<UserResponse> userList = new ArrayList<>();
    private List<PostResponse> postList = new ArrayList<>();
    private List<UserPostList> userPostLists = new ArrayList<>();
    private Map<Integer, String> companyData = new HashMap<>();
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rv_article);
        postPresenter = new PostPresenter(this, this);
        userPresenter = new UserPresenter(this, this);
        LinearLayoutManager manager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
        userPresenter.getData();
        postPresenter.getData();
    }

    @Override
    public void onUserSuccess(List<UserResponse> response) {
        userList.addAll(response);
        for(int i=0;i<response.size();i++){
            UserResponse user = response.get(i);
            companyData.put(user.getId(),
                    user.getCompany().getName());
        }
    }

    @Override
    public void onUserFailed(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onPostSuccess(List<PostResponse> response) {
        postList.addAll(response);
        for (int i=0;i<response.size();i++){
            PostResponse postResponse = response.get(i);
            userPostLists.add(new UserPostList(postResponse.getTitle(),
                    postResponse.getBody(),
                    companyData.get(postResponse.getUserId()))
            );
        }
        updateListData();
    }

    @Override
    public void onPostFailed(String error) {

    }

    public void updateListData() {
        ListAdapter listAdapter = new ListAdapter(userPostLists, this);
        recyclerView.setAdapter(listAdapter);
        listAdapter.notifyDataSetChanged();
    }
}