package com.example.pjgg.evernoteapp;

import android.content.Context;
import android.content.res.Resources;

import com.example.pjgg.evernoteapp.session.ActivityEnum;
import com.example.pjgg.evernoteapp.session.Session;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import static junit.framework.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest({Session.class})
public class SessionTest {

    @Test
    public void getCurrentActivity(){
        //Mock
        Session session = mock(Session.class);
        Whitebox.setInternalState(Session.class, "INSTANCE", session);

        //Stubbing
        when(session.getCurrentActivity()).thenReturn(ActivityEnum.MAIN_ACTIVITY);

        //Invoke
        ActivityEnum result = Session.getInstance().getCurrentActivity();

        //Assert
        assertTrue(result.getCode().equalsIgnoreCase("MainActivity"));

        //Verify
        verify(session, times(1)).getCurrentActivity();
    }

    @Test
    public void getApplicationContext(){
        //Mock
        Context context = mock(Context.class);
        Session session = mock(Session.class);
        Whitebox.setInternalState(Session.class, "INSTANCE", session);

        //Stubbing
        when(session.getApplicationContext()).thenReturn(context);

        //Invoke
        Context result = Session.getInstance().getApplicationContext();

        //Assert
        assertTrue(result == context);

        //Verify
        verify(session, times(1)).getApplicationContext();
    }

    @Test
    public void getResources(){
        //Mock
        Resources resource = mock(Resources.class);
        Session session = mock(Session.class);
        Whitebox.setInternalState(Session.class, "INSTANCE", session);

        //Stubbing
        when(session.getResources()).thenReturn(resource);

        //Invoke
        Resources result = Session.getInstance().getResources();

        //Assert
        assertTrue(result == resource);

        //Verify
        verify(session, times(1)).getResources();
    }
}
