package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Represents a normal tweet object
 *
 * @author Melissa Buljubasic
 * @version 1.0
 * @see Tweet
 */

public class NormalTweet extends Tweet {
    /**
     * Construct a normal tweet object
     *
     * @param message Tweet message
     */
    NormalTweet(String message) {
        super(message);
    }

    /**
     * Construct a normal tweet object
     *
     * @param message Tweet message
     * @param date Tweet Date
     */
    NormalTweet(String message, Date date){
        super(message, date);
    }

    /**
     * Unfortunatly this tweet is not important :(
     * @return
     */
    @Override
    public Boolean isImportant() {
        return Boolean.FALSE;
    }
}
