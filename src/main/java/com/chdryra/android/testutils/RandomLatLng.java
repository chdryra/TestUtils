/*
 * Copyright (c) Rizwan Choudrey 2016 - All Rights Reserved
 * Unauthorized copying of this file via any medium is strictly prohibited
 * Proprietary and confidential
 * rizwan.choudrey@gmail.com
 *
 */

package com.chdryra.android.testutils;

import com.google.android.gms.maps.model.LatLng;

import java.util.Random;

/**
 * Created by: Rizwan Choudrey
 * On: 04/12/2014
 * Email: rizwan.choudrey@gmail.com
 */
public class RandomLatLng {
    private static final Random RAND = new Random();

    //Static methods
    public static LatLng nextLatLng() {
        return new LatLng((RAND.nextDouble() - 0.5) * 180, (RAND.nextDouble() - 0.5) * 360);
    }
}
