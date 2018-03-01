/*
 * Tweet
 *
 * Version 1.0
 *
 * January 30, 2018
 *
 * Copyright (C) 2018 Melissa Buljubasic
 * You may use, distribute or modify the code under terms and conditions of the Code of Student Behaviour at University of Alberta.
 * You can find a copy of the license in this project. Otherwise please contact contact@abc.ca
 */

package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


/**
 * Main Activity class
 * Lonely Twitter Implementation
 *
 * @author Melissa Buljubasic
 * @Version 1.0
 * @see Mood
 * @see Tweet
 */
public class LonelyTwitterActivity extends Activity {

	private static final String FILENAME = "tweets.sav";
	private EditText bodyText;
	private ListView oldTweetsList;

	private ArrayList<Tweet> tweetList;
	private ArrayAdapter<Tweet> adapter;

	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
		Button clearButton = (Button) findViewById(R.id.clear);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);

		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK);
				String text = bodyText.getText().toString();

                Tweet tweet = new NormalTweet(text);
                tweetList.add(tweet);

                adapter.notifyDataSetChanged();

				saveInFile();
			}
		});

		clearButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				tweetList.clear();

				adapter.notifyDataSetChanged();

				saveInFile();
			}
		});

		oldTweetsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Intent intent = new Intent(activity, EditTweetActivity.class);
				intent.putExtra("OldList", (String) oldTweetsList.getItemAtPosition(position));
				startActivity(intent);

			}
		});
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();

        loadFromFile();
        adapter = new ArrayAdapter<Tweet>(this, R.layout.list_item, tweetList);
        oldTweetsList.setAdapter(adapter);
	}


    /**
     * Loads tweets saved in a file
     */
	private void loadFromFile() {
        try {
            FileInputStream fis = openFileInput(FILENAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));

            Gson gson = new Gson();

            // Taken from Stack Overflow
            // 2018-01-23
            Type listType = new TypeToken<ArrayList<NormalTweet>>() {
            }.getType();
            tweetList = gson.fromJson(in, listType);

        } catch (FileNotFoundException e) {
            tweetList = new ArrayList<Tweet>();
        } catch (IOException e) {
            throw new RuntimeException();
        }
	}

    /**
     * Save all tweets to file
     */
	private void saveInFile() {
		try {
			FileOutputStream fos = openFileOutput(FILENAME,
					Context.MODE_PRIVATE);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));

            Gson gson = new Gson();
            gson.toJson(tweetList, out);
            out.flush();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}
	}
}