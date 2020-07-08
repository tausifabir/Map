package com.example.map.Presenters;

import com.example.map.Model.iUser;
import com.example.map.View.iLoginView;

public class LoginPresenter implements iLoginPresenter {

    iLoginView iLoginView;

    public LoginPresenter(com.example.map.View.iLoginView iLoginView) {
        this.iLoginView = iLoginView;
    }

    @Override
    public void onLoginResult(String email, String password) {

        iUser user = new iUser(email,password);

        boolean isLoginSuccess = user.isValidData();

        if(isLoginSuccess)
            iLoginView.onLoginResult("Success");
        else
            iLoginView.onLoginResult("Failed");
    }
}
