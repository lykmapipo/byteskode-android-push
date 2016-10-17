package com.github.byteskode.push;

import android.content.Context;
import com.google.firebase.FirebaseApp;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.shadows.ShadowApplication;

import java.util.Set;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author lally elias
 * @email lallyelias87@gmail.com, lally.elias@byteskode.com
 */

@RunWith(RobolectricTestRunner.class)
public class PushTest {
    private Context context;

    @Before
    public void setup() {
        context = ShadowApplication.getInstance().getApplicationContext();
        FirebaseApp.initializeApp(context);
    }


    @Test
    public void shouldBeAbleToGetPushInstance() {
        Push push = Push.getInstance(context);
        assertThat(push, is(not(equalTo(null))));
    }

    @Test
    public void shouldBeAbleToGetInstanceId() {
    }

    @Test
    public void shouldBeAbleToSubscribeToPushTopic() {
        String topic = "MAIZE";
        Set<String> topics = Push.getInstance(context).subscribe(topic);
        assertThat(topics.contains(topic), equalTo(true));
    }

    @Test
    public void shouldBeAbleToUnSubscribeToPushTopic() {
        String topic = "MAIZE";
        Set<String> topics = Push.getInstance(context).unsubscribe(topic);
        assertThat(topics.contains(topic), equalTo(false));
    }

    @After
    public void cleanup() {
        Push.getInstance(context).clear();
        context = null;
    }
}
