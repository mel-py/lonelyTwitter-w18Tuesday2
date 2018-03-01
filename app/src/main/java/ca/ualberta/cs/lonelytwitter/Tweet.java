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

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;

/**
 * Reperesents a tweet
 *
 * @author Melissa Buljubasic
 * @version 1.0
 * @see NormalTweet
 * @see ImportantTweet
 */

public abstract class Tweet implements Tweetable {
    ArrayList<Mood> mood;
    private String message;
    Date date;

    Tweet(String message) {
        this.message = message;
        date = new Date();
        mood = new ArrayList<Mood>();
    }

    /**
     * Constructs a tweet object
     *
     * @param message Tweet message
     * @param date Tweet date
     */
    Tweet(String message, Date date) {
        this.message = message;
        this.date = date;
        mood = new ArrayList<Mood>();
    }

    public String getMessage() {
        return message;
    }

    /**
     * Sets tweet message
     *
     * @param message tweet message
     * @throws TweetTooLongException the tweet message is over 140 characters
     */
    public void setMessage(String message) throws TweetTooLongException {
        if (message.length() < 140) {
            this.message = message;
        }
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void addMood(Mood mood) {
        this.mood.add(mood);
    }

    public ArrayList<Mood> getMoods() {
        return mood;
    }

    public abstract Boolean isImportant();

    public String toString() {
        return date.toString() + " | " + message;
    }
}