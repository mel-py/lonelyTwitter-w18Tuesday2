/*
 * Copyright (C) 2018 Melissa Buljubasic
 * You may use, distribute or modify the code under terms and conditions of the Code of Student Behaviour at University of Alberta.
 * You can find a copy of the license in this project. Otherwise please contact contact@abc.ca
 */

package ca.ualberta.cs.lonelytwitter;

import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by Melissa on 2018-03-01.
 */

public class EditTweetActivity {
    private String oldTweet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_tweet);
        oldTweet = getIntent().getStringExtra("OldList");

        final TextView editView =(TextView) findViewById(R.id.TweetDisplay);
        editView.setText(oldTweet);


    }

    public String getOldTweet(){
        return oldTweet;
    }
}
