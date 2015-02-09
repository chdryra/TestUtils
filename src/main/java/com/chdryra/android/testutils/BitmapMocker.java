/*
 * Copyright (c) 2014, Rizwan Choudrey - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Author: Rizwan Choudrey
 * Date: 16 December, 2014
 */

package com.chdryra.android.testutils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

import java.util.Random;

/**
 * Created by: Rizwan Choudrey
 * On: 16/12/2014
 * Email: rizwan.choudrey@gmail.com
 */
public class BitmapMocker {
    private static final int    WIDTH  = 400;
    private static final int    HEIGHT = 300;
    private static final Random rand   = new Random();

    public static Bitmap nextBitmap(boolean landscape) {
        return landscape ? nextBitmap(WIDTH, HEIGHT) : nextBitmap(HEIGHT, WIDTH);
    }

    public static Bitmap nextBitmap(int width, int height) {
        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(bitmap);
        String text = RandomStringGenerator.nextWord();
        float x = width / 2;
        float y = height / 2;

        c.drawText(text, x, y, new Paint());

        return bitmap;
    }
}
