/*
 * Copyright (c) Rizwan Choudrey 2016 - All Rights Reserved
 * Unauthorized copying of this file via any medium is strictly prohibited
 * Proprietary and confidential
 * rizwan.choudrey@gmail.com
 *
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

    public static Date nextDate() {
        int year = 1976 + RAND.nextInt(30);
        int dayOfYear = 1 + RAND.nextInt(364);

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.DAY_OF_YEAR, dayOfYear);

        return calendar.getTime();
    }
}
