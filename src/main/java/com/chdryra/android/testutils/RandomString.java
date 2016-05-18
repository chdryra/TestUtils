/*
 * Copyright (c) Rizwan Choudrey 2016 - All Rights Reserved
 * Unauthorized copying of this file via any medium is strictly prohibited
 * Proprietary and confidential
 * rizwan.choudrey@gmail.com
 *
 */

package com.chdryra.android.testutils;

import android.support.annotation.NonNull;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;
import java.util.List;
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

    public static List<String> nextWordArray(int num) {
        ArrayList<String> words = new ArrayList<>();
        for(int i = 0; i < num; ++i) {
            words.add(nextWord());
        }

        return words;
    }

    public static String nextWordLowerCase() {
        return nextWord().toLowerCase();
    }


    @NonNull
    public static String toRandomCase(String stringPre) {
        String string = stringPre;
        int upperLower = mRand.nextInt(3);
        if (upperLower == 0) {
            string = stringPre.toUpperCase();
        } else if (upperLower == 1) {
            string = stringPre.toLowerCase();
        }
        return string;
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
