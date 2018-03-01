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

import java.util.Date;

/**
 * Reperesents a mood
 *
 * @author Melissa Buljubasic
 * @version 1.0
 * @see HappyMood
 * @see SadMood
 */

public abstract class Mood {
    Date date;

    /**
     * Construct a mood
     */
    Mood() {
        this.date = new Date();
    }

    /**
     * Construct a mood
     * @param date Date of mood
     */
    Mood(Date date) {
        this.date = date;
    }

    /**
     * Return the mood date
     *
     * @return
     */
    public Date getDate() {
        return date;
    }

    /**
     * Set the mood date
     * @param date mood date
     */
    public void setDate(Date date) {
        this.date =  date;
    }

    /**
     * Returns a string representation of the mood
     *
     * @return
     */
    public abstract String getMood();
}
