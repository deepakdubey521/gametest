package com.test;

/**
 * Created by deepak on 21/12/16.
 */

import android.app.Application;
import android.util.Log;

import com.amazonaws.mobile.AWSMobileClient;
import com.amazonaws.mobile.util.AbstractApplicationLifeCycleHelper;
import com.amazonaws.mobileconnectors.pinpoint.PinpointManager;
// ...

public class GameTestApplication extends Application {
    private AbstractApplicationLifeCycleHelper applicationLifeCycleHelper;

    @Override
    public void onCreate() {
        super.onCreate();
        AWSMobileClient.initializeMobileClientIfNecessary(getApplicationContext());
        applicationLifeCycleHelper = new AbstractApplicationLifeCycleHelper(this) {
            @Override
            protected void applicationEnteredForeground() {
                final PinpointManager pinpointManager = AWSMobileClient.defaultMobileClient()
                        .getPinpointManager();
                pinpointManager.getSessionClient().startSession();
                // handle any events that should occur when your app has come to the foreground...
            }

            @Override
            protected void applicationEnteredBackground() {
                Log.d("Deepak", "Detected application has entered the background.");
                final PinpointManager pinpointManager = AWSMobileClient.defaultMobileClient()
                        .getPinpointManager();
                pinpointManager.getSessionClient().stopSession();
                pinpointManager.getAnalyticsClient().submitEvents();
                // handle any events that should occur when your app has gone into the background...
            }
        };
    }

    @Override
    public void onTrimMemory(final int level) {
        Log.d("Deepak", "onTrimMemory " + level);
        applicationLifeCycleHelper.handleOnTrimMemory(level);
        super.onTrimMemory(level);
    }
}
