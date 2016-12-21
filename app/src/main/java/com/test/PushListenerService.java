package com.test;

import android.os.Bundle;

import com.amazonaws.mobile.AWSMobileClient;
import com.amazonaws.mobileconnectors.pinpoint.targeting.notification.NotificationClient;
import com.google.android.gms.gcm.GcmListenerService;

/**
 * Created by deepak on 21/12/16.
 */

public class PushListenerService extends GcmListenerService {
    @Override
    public void onMessageReceived(final String from, final Bundle data) {
        AWSMobileClient.initializeMobileClientIfNecessary(this.getApplicationContext());
        final NotificationClient notificationClient = AWSMobileClient.defaultMobileClient()
                .getPinpointManager().getNotificationClient();

        NotificationClient.CampaignPushResult pushResult =
                notificationClient.handleGCMCampaignPush(from, data, this.getClass());

        if (!NotificationClient.CampaignPushResult.NOT_HANDLED.equals(pushResult)) {
            // The push message was due to a Dartboard campaign and an event was recorded.
            // If the app was in the background, a notification was added in the notification center.
            if (NotificationClient.CampaignPushResult.APP_IN_FOREGROUND.equals(pushResult)) {
                // If the app was in the foreground, you may want to add logic here to send
                // a broadcast back to your main activity to show something to the user.
            }
            return;
        }

        // ... handle any non Amazon Pinpoint GCM messages here ...
    }
}