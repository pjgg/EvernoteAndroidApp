package com.example.pjgg.evernoteapp.connector;


import android.util.Log;

import com.evernote.client.android.EvernoteSession;
import com.example.pjgg.evernoteapp.session.Session;

public class EvernoteConnectorImpl implements Connector{

    private static final String TAG = "EvernoteConnectorImpl";

    private static final String CONSUMER_KEY = "pablo-gonzalez-granados";
    private static final String CONSUMER_SECRET = "6bca1ca25f002882";
    private static final EvernoteSession.EvernoteService EVERNOTE_SERVICE = EvernoteSession.EvernoteService.SANDBOX;
    private static final boolean SUPPORT_APP_LINKED_NOTEBOOKS = true;
    private static final boolean FORCE_AUTHENTICATION_IN_THIRD_PARTY_APP = true;

    @Override
    public Boolean isLoggedIn() {
        Log.d(TAG, "isLoggedIn");
        return retrieveEvernoteSession().isLoggedIn();
    }

    private EvernoteSession retrieveEvernoteSession(){
        EvernoteSession mEvernoteSession = new EvernoteSession.Builder(Session.getInstance().getApplicationContext())
                .setEvernoteService(EVERNOTE_SERVICE)
                .setSupportAppLinkedNotebooks(SUPPORT_APP_LINKED_NOTEBOOKS)
                .setForceAuthenticationInThirdPartyApp(FORCE_AUTHENTICATION_IN_THIRD_PARTY_APP)
                .build(CONSUMER_KEY, CONSUMER_SECRET)
                .asSingleton();

        return EvernoteSession.getInstance();
    }
}
