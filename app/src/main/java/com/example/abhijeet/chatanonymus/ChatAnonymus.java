package com.example.abhijeet.chatanonymus;

import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Created by Abhijeet on 10/1/2016.
 */

public class ChatAnonymus extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Firebase.setAndroidContext(this);
    }
}
