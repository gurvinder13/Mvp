package com.example.uidemo.interfaces;

import com.example.uidemo.model.UserResponse;

import java.util.List;

public interface UserView {
    void onUserSuccess(List<UserResponse> response);

    void onUserFailed(String error);
}
