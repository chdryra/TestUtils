/*
 * Copyright (c) 2014, Rizwan Choudrey - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Author: Rizwan Choudrey
 * Date: 25 November, 2014
 */

package com.chdryra.android.testutils;

import junit.framework.Assert;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by: Rizwan Choudrey
 * On: 25/11/2014
 * Email: rizwan.choudrey@gmail.com
 */
public class ExceptionTester {
    private ExceptionTester() {
    }

    //Static methods
    public static void test(Object obj, String methodName, Class<? extends Exception> expected,
                            String exceptionMessage) {
        Method method = getMethod(obj, methodName, null);
        invokeMethod(obj, method, null, expected, exceptionMessage);
    }

    public static void test(Object obj, String methodName, Object[] params, Class<? extends
            Exception> expected, String exceptionMessage) {
        Method method = getMethod(obj, methodName, params);
        invokeMethod(obj, method, params, expected, exceptionMessage);
    }

    private static Method getMethod(Object obj, String methodName, Object[] params) {
        Method method = null;
        try {
            if (params == null) {
                method = obj.getClass().getMethod(methodName);
            } else {
                Class[] paramClasses = new Class[params.length];
                for (int i = 0; i < params.length; ++i) {
                    paramClasses[i] = params[i].getClass();
                }
                method = obj.getClass().getMethod(methodName, paramClasses);
            }
        } catch (SecurityException e) {
            e.printStackTrace();
            Assert.fail("SecurityException");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            Assert.fail("NoSuchMethodException");
        }

        return method;
    }

    private static void invokeMethod(Object obj, Method method, Object[] params, Class<? extends
            Exception> expected, String exceptionMessage) {
        try {
            if (method != null) {
                if (params == null) {
                    method.invoke(obj);
                } else {
                    method.invoke(obj, params);
                }
            }
            Assert.fail(expected.toString() + " expected");
        } catch (InvocationTargetException e) {
            Throwable thrown = e.getTargetException();
            if (expected.equals(thrown.getClass())) {
                Assert.assertEquals(exceptionMessage, thrown.getMessage());
            } else {
                Assert.fail("Wrong exception thrown. Expected: " + expected.toString() + " got: "
                        + e.getTargetException().toString());
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            Assert.fail("IllegalAccessException");
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            Assert.fail("IllegalArgumentException");
        }
    }
}
