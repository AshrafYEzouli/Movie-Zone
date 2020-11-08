package com.movieapp.ashraf.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.google.firebase.auth.FirebaseUser;
import com.movieapp.ashraf.repository.SignInRepository;

public class SignInViewModel extends AndroidViewModel {

    private SignInRepository signInRepository;
    private MutableLiveData<FirebaseUser> userMutableLiveData;

    public SignInViewModel(@NonNull Application application) {
        super(application);

        signInRepository = new SignInRepository(application);
        userMutableLiveData = signInRepository.getUserMutableLiveData();
    }

    public void register(String email, String password){
        signInRepository.register(email, password);
    }

    public void signIn(String email, String password){
        signInRepository.signIn(email, password);
    }

    public MutableLiveData<FirebaseUser> getUserMutableLiveData() {
        return userMutableLiveData;
    }
}
