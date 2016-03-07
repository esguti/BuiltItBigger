package com.portfolio.course.esguti.builditbigger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

@Config(manifest=Config.NONE)
@RunWith(RobolectricTestRunner.class)
public class testAsyncTask implements EndpointsAsyncTask.EnpointResponse {

    @Test
    public void verifyEndpointResponse() throws Exception {
        EndpointsAsyncTask endp = new EndpointsAsyncTask(this, "localhost");
        endp.execute();
        Robolectric.flushForegroundThreadScheduler();
    }

    public void showJoke(String joke){
        if( joke != null ) System.out.println("Joke reponse: " + joke);
        else{ System.out.println("Null received"); }
        assert ( joke != null && joke.startsWith("Wh") );
    }

}
