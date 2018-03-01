package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Represents a sad mood extension of the class
 *
 * @author Melissa Buljubasic
 * @Version 1.0
 * @see Mood
 */
public class SadMood extends Mood {
    /**
     * Construct a sad mood
     */
    SadMood() {}

    /**
     * Construct a sad mood
     *
     * @param date Date of the mood
     */
    SadMood(Date date) {
        super(date);
    }

    /**
     * Returns a string representation of the mood
     *
     * @return
     */
    @Override
    public String getMood() {
        return "Sad";
    }
}
