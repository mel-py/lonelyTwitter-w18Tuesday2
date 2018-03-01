package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Represents a happy mood class extended from Mood
 *
 * @author Melissa Buljubasic
 * @Version 1.0
 * @see Mood
 */

public class HappyMood extends Mood {
    HappyMood() {}

    /**
     * Construct a happy mood class
     *
     * @param date Date of the mood
     */
    HappyMood(Date date) {
        super(date);
    }

    /**
     * Returns a string representation of the mood
     * @return
     */
    @Override
    public String getMood() {
        return "Happy";
    }
}
