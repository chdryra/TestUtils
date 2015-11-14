/*
 * Copyright (c) 2015, Rizwan Choudrey - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Author: Rizwan Choudrey
 * Date: 17 February, 2015
 */

package com.chdryra.android.testutils;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * Created by: Rizwan Choudrey
 * On: 17/02/2015
 * Email: rizwan.choudrey@gmail.com
 */
public class RandomDate {
    private static final Random RAND = new Random();

    //Static methods
    public static Date nextDate() {
        int year = 1900 + RAND.nextInt(114);
        int dayOfYear = 1 + RAND.nextInt(364);

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.DAY_OF_YEAR, dayOfYear);

        return calendar.getTime();
    }
}