package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Represents an important tweet
 *
 * @author Melissa Buljubasic
 * @version 1.0
 * @see Tweet
 */

public class ImportantTweet extends Tweet {
    /**
     * Construct an important tweet object
     * @param message Tweet message
     */
    ImportantTweet(String message) {
        super(message);
    }

    /**
     * Construct important tweet object
     * @param message Tweet message
     * @param date Tweet Date
     */
    ImportantTweet(String message, Date date) {
        super(message, date);
    }

    /**
     * Is the tweet important or not? In this case yes
     */
    @Override
    public Boolean isImportant() {
        return Boolean.TRUE;
    }
}
