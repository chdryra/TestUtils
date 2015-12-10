/*
 * Copyright (c) 2014, Rizwan Choudrey - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Author: Rizwan Choudrey
 * Date: 3 December, 2014
 */

package com.chdryra.android.testutils;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

/**
 * Created by: Rizwan Choudrey
 * On: 03/12/2014
 * Email: rizwan.choudrey@gmail.com
 */
public class RandomString {
    private static final int MIN = 3;
    private static final int MAX = 8;

    private static final String DELIMITERS = ".!?";
    private static Random mRand = new Random();
    private String[] mSentences;

    //Static methods
    public static String nextSentence() {
        String sentence = "";
        int numWords = randomLength();
        for (int w = 0; w < numWords; ++w) {
            sentence += nextWord() + " ";
        }

        return sentence.trim();
    }

    public static String nextWord() {
        return RandomStringUtils.randomAlphabetic(randomLength());
    }

    public static String nextWordLowerCase() {
        return nextWord().toLowerCase();
    }

    private static int randomLength() {
        return MIN + mRand.nextInt(MAX - MIN);
    }

    //public methods
    public String[] getSentencesForParagraph() {
        return mSentences;
    }

    public String nextParagraph() {
        String comment = "";
        int numSentences = randomLength();
        mSentences = new String[numSentences];
        for (int w = 0; w < numSentences; ++w) {
            String sentence = nextSentence() + randomDelimiter();
            comment += sentence + " ";
            mSentences[w] = sentence;
        }

        return comment.trim();
    }

    private char randomDelimiter() {
        return DELIMITERS.charAt(mRand.nextInt(DELIMITERS.length()));
    }
}
