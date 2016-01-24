/*
 * Copyright (c) Rizwan Choudrey 2016 - All Rights Reserved
 * Unauthorized copying of this file via any medium is strictly prohibited
 * Proprietary and confidential
 * rizwan.choudrey@gmail.com
 *
 */

package com.chdryra.android.testutils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by: Rizwan Choudrey
 * On: 16/12/2014
 * Email: rizwan.choudrey@gmail.com
 */
public class BitmapMocker {
    private static final int WIDTH = 40;
    private static final int HEIGHT = 31;

    //Static methods
    public static Bitmap nextBitmap() {
        return nextBitmap(true);
    }

    public static Bitmap nextBitmap(boolean landscape) {
        return landscape ? nextBitmap(WIDTH, HEIGHT) : nextBitmap(HEIGHT, WIDTH);
    }

    public static Bitmap nextBitmap(int width, int height) {
        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(bitmap);
        String text = RandomString.nextWord();
        float x = width / 2;
        float y = height / 2;

        c.drawText(text, x, y, new Paint());

        return bitmap;
    }
}
