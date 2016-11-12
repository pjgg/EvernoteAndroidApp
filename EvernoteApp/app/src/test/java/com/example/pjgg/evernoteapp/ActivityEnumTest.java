package com.example.pjgg.evernoteapp;

import com.example.pjgg.evernoteapp.session.ActivityEnum;

import org.junit.Test;

import static junit.framework.Assert.assertTrue;


public class ActivityEnumTest {

    @Test
    public void getCodeMainActivity(){
        //Mock
        ActivityEnum activityEnum = ActivityEnum.MAIN_ACTIVITY;

        //Invoke
        String result = activityEnum.getCode();

        //Assert
        assertTrue(result.equalsIgnoreCase("MainActivity"));

    }

    @Test
    public void getCodeLoginActivity(){
        //Mock
        ActivityEnum activityEnum = ActivityEnum.LOGIN_ACTIVITY;

        //Invoke
        String result = activityEnum.getCode();

        //Assert
        assertTrue(result.equalsIgnoreCase("LoginActivity"));

    }

    @Test
    public void getCodeUnknownActivity(){
        //Mock
        ActivityEnum activityEnum = ActivityEnum.UNKNOWN;

        //Invoke
        String result = activityEnum.getCode();

        //Assert
        assertTrue(result.equalsIgnoreCase("unknown"));

    }

    @Test
    public void getTypeMainActivity(){
        //Mock
        ActivityEnum activityEnum = ActivityEnum.MAIN_ACTIVITY;

        //Invoke
        ActivityEnum result = activityEnum.getType("MainActivity");

        //Assert
        assertTrue(result == ActivityEnum.MAIN_ACTIVITY);

    }

    @Test
    public void getTypeLoginActivity(){
        //Mock
        ActivityEnum activityEnum = ActivityEnum.LOGIN_ACTIVITY;

        //Invoke
        ActivityEnum result = activityEnum.getType("LoginActivity");

        //Assert
        assertTrue(result == ActivityEnum.LOGIN_ACTIVITY);

    }

    @Test
    public void getTypeUnknownActivity(){
        //Mock
        ActivityEnum activityEnum = ActivityEnum.UNKNOWN;

        //Invoke
        ActivityEnum result = activityEnum.getType("unknown");

        //Assert
        assertTrue(result == ActivityEnum.UNKNOWN);

    }
}
