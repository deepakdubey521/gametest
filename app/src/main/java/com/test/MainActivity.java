package com.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.amazonaws.mobile.AWSMobileClient;
import com.amazonaws.mobileconnectors.pinpoint.analytics.AnalyticsClient;
import com.amazonaws.mobileconnectors.pinpoint.analytics.AnalyticsEvent;
import com.amazonaws.mobileconnectors.pinpoint.analytics.monetization.GooglePlayMonetizationEventBuilder;
import com.example.gamestest.R;

public class MainActivity extends AppCompatActivity {
    AnalyticsClient analyticsClient;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        analyticsClient =  AWSMobileClient.defaultMobileClient().getPinpointManager().getAnalyticsClient();
    }

    @Override
    protected void onStart() {
        super.onStart();


    }

    public void  button1(View view){

        {
            final AnalyticsEvent event = analyticsClient.createEvent("DemoCustomEvent1")
                    .withAttribute("Country", "India")
                    .withAttribute("City", "Bangalore")
                    .withMetric("Age", Math.random());

            analyticsClient.recordEvent(event);
            analyticsClient.submitEvents();
        }


        {
            final AnalyticsEvent event = analyticsClient.createEvent("DemoCustomEvent1")
                    .withAttribute("Country", "US")
                    .withAttribute("City", "Delhi")
                    .withMetric("Age", Math.random());

            analyticsClient.recordEvent(event);
            analyticsClient.submitEvents();
        }



        Toast.makeText(this, "Button1 click",
                Toast.LENGTH_LONG).show();
    }
    public void  button2(View view){

        final AnalyticsEvent event = analyticsClient.createEvent("DemoCustomEvent2")
                .withAttribute("Country", "US")
                .withAttribute("City", "New York")
                .withMetric("Age", Math.random());

        analyticsClient.recordEvent(event);
        analyticsClient.submitEvents();
        Toast.makeText(this, "Button2 click",
                Toast.LENGTH_LONG).show();
    }
    public void  button3(View view){

        final AnalyticsEvent event = analyticsClient.createEvent("DemoCustomEvent3")
                .withAttribute("Name", "Deepak")
                .withAttribute("Gender", "Male")
                .withMetric("Age", Math.random());

        analyticsClient.recordEvent(event);
        analyticsClient.submitEvents();
        Toast.makeText(this, "Button3 click",
                Toast.LENGTH_LONG).show();
    }
    public void  button4(View view){

        final AnalyticsEvent event = analyticsClient.createEvent("DemoCustomEvent4")
                .withAttribute("Name", "Saurabh")
                .withAttribute("Gender", "Male")
                .withMetric("Age", Math.random());

        analyticsClient.recordEvent(event);
        analyticsClient.submitEvents();
        Toast.makeText(this, "Button4 click",
                Toast.LENGTH_LONG).show();
    }
    public void  button5(View view){

        final AnalyticsEvent event = analyticsClient.createEvent("DemoCustomEvent5")
                .withAttribute("Country", "UK")
                .withAttribute("City", "London")
                .withMetric("Age", Math.random());

        analyticsClient.recordEvent(event);
        analyticsClient.submitEvents();
        Toast.makeText(this, "Button5 click",
                Toast.LENGTH_LONG).show();
    }
}
