/*
 * Copyright (C) 2018 Melissa Buljubasic
 * You may use, distribute or modify the code under terms and conditions of the Code of Student Behaviour at University of Alberta.
 * You can find a copy of the license in this project. Otherwise please contact contact@abc.ca
 */

package ca.ualberta.cs.lonelytwitter;

import android.app.Activity;

/**
 * Created by Melissa on 2018-03-01.
 */

public class EditTweetActivityTest {
    private Solo solo;

    public EditTweetActivityTest() {
        super(ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity.class);
    }

    public void testStart() throws Exception {
        Activity activity = getActivity();
    }

    public void setUp() throws Exception{
        solo = new Solo(getInstrumentation(), getActivity());
    }

    public void testEditViewText() throws Exception {
        EditTweetActivity activity = (EditTweetActivity) solo.getCurrentActivity();
        solo.assertCurrentActivity("Wrong Activity!", EditTweetActivity.class);

        final String editTweet = activity.getOldTweet();
        assertEquals("Tweet test!", editTweet);
    }

    @Override
    public void tearDown() throws Exception{
        solo.finishOpenedActivities();
    }
}
