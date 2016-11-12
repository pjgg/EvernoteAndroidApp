package com.example.pjgg.evernoteapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.test.InstrumentationTestCase;

import com.evernote.client.android.EvernoteSession;
import com.example.pjgg.evernoteapp.connector.EvernoteConnectorImpl;
import com.example.pjgg.evernoteapp.session.Session;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest({Session.class, EvernoteSession.class})
public class EvernoteConnectorImplTest {

    @Test
    public void isLoggedIn(){

        //Mock
        Context context = mock(Context.class);
        SharedPreferences pref = mock(SharedPreferences.class);

        EvernoteSession evernoteSession = mock(EvernoteSession.class);
        Session session = mock(Session.class);
        Whitebox.setInternalState(Session.class, "INSTANCE", session);
        Whitebox.setInternalState(EvernoteSession.class, "sInstance", evernoteSession);

        //Stubbing
        when(context.getSharedPreferences("evernote.preferences", Context.MODE_PRIVATE)).thenReturn(pref);
        when(context.getApplicationContext()).thenReturn(context);
        when(session.getApplicationContext()).thenReturn(context);

        //Invoke
        EvernoteConnectorImpl connector = new EvernoteConnectorImpl();
        Boolean result = connector.isLoggedIn();

        //Assert
        assertTrue(result == true);

    }


}
