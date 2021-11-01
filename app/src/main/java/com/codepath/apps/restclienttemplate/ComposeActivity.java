package com.codepath.apps.restclienttemplate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ComposeActivity extends AppCompatActivity {

    public static final int MAX_TWEET_LENGTH = 140;

    EditText etCompose;
    Button btnTweet;

    // TODO: google Android Snackbar for better error handling on user tweet creation than toasts

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compose);

        etCompose = findViewById(R.id.etCompose);
        btnTweet = findViewById(R.id.btnTweet);

        // set click listener on button so we can send text
        btnTweet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tweetContent = etCompose.getText().toString();

                // edge case handling
                if (tweetContent.isEmpty()) { // empty tweet
                    Toast.makeText(ComposeActivity.this,
                            "cannot have an empty tweet! add some text :)",
                            Toast.LENGTH_LONG).show();
                    return;
                } else if (tweetContent.length() > MAX_TWEET_LENGTH) { // tweet too large
                    Toast.makeText(ComposeActivity.this,
                            "you've exceeded the max amount of characters! shorten your tweet :)",
                            Toast.LENGTH_LONG).show();
                    return;
                }

                // valid tweet
                Toast.makeText(ComposeActivity.this,
                        tweetContent, Toast.LENGTH_LONG).show();

                // make an API call to Twitter to publish the tweet

            }
        });

    }
}