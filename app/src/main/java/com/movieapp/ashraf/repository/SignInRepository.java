package com.movieapp.ashraf.repository;

import android.app.Application;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.MutableLiveData;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignInRepository {

    private Application application;
    private FirebaseAuth firebaseAuth;
    private MutableLiveData<FirebaseUser> userMutableLiveData;

    public SignInRepository(Application application) {
        this.application = application;

        firebaseAuth = FirebaseAuth.getInstance();
        userMutableLiveData = new MutableLiveData<>();
    }

    public void register(String email, String password){
        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(ContextCompat.getMainExecutor(application), task -> {
                    if(task.isSuccessful()){
                        userMutableLiveData.postValue(firebaseAuth.getCurrentUser());
                    } else {
                        Toast.makeText(application, "Register failed" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    public void signIn(String email, String password){
        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(ContextCompat.getMainExecutor(application), task -> {
                    if(task.isSuccessful()){
                        userMutableLiveData.postValue(firebaseAuth.getCurrentUser());
                    } else {
                        Toast.makeText(application, "Sign in failed" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    public MutableLiveData<FirebaseUser> getUserMutableLiveData() {
        return userMutableLiveData;
    }
}
