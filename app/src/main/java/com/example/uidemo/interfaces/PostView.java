package com.example.uidemo.interfaces;

import com.example.uidemo.model.PostResponse;
import com.example.uidemo.model.UserResponse;

import java.util.List;

public interface PostView {
    void onPostSuccess(List<PostResponse> response);

    void onPostFailed(String error);
}
