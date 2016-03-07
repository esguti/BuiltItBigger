/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.portfolio.course.esguti.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import javax.inject.Named;

import sun.rmi.runtime.Log;

/** An endpoint class we are exposing */
@Api(
  name = "jokeApi",
  version = "v1",
  namespace = @ApiNamespace(
    ownerDomain = "backend.esguti.course.portfolio.com",
    ownerName = "backend.esguti.course.portfolio.com",
    packagePath=""
  )
)
public class MyEndpoint {

    private static int m_id_joke = 0;
    private String[] m_jokes = {
            "Why do Farts stink? A: So that Deaf people can enjoy them too.",
            "Why did the Hedgehog cross the road? A: To see his Flat Mate.",
            "What do you call a Fish without an eye? A: A 'Fsh'!",
            "Why does it take 1 million sperm to fertilize one egg? A: They won't stop to ask directions.",
            "What's the difference between Big Foot and an intelligent man? A: Big Foot's been spotted several times.",
            "What do you call a handcuffed man? A: Trustworthy.",
            "What did the fish say when he hit a concrete wall? A: \"Dam\".",
            "Why is divorce so expensive? A: Because it's worth it.",
            "What is black, white and red all over? A. A skunk with nappy rash.",
            "Why did the man jump out of the window? A. He wanted to catch a butterfly.",
            "Why did the monkey put a piece of steak on his head? A. He thought he was a griller.",
            "What do you call a deer with no eyes? A. No eye deer.",
            "What do you call a deer with no eyes and no legs? A. Still no eye deer.",
            "Why was six afraid of seven? A. Because seven eight nine.",
            "Why did the dinosaur walk across the road? A. Because chickens were not invented yet.",
            "What has four wheels and flies? A. A rubbish truck.",
            "What's brown and sticky? A. A stick.",
            "When were vowels invented? A. When u and i were born.",
            "What's orange and sounds like a parrot? A. A carrot."
    };


    /** A simple endpoint method to tell a joke*/
    @ApiMethod(name = "getJoke")
    public MyBean getJoke() {
        MyBean response = new MyBean();

        m_id_joke = m_id_joke % m_jokes.length;
        response.setData(m_jokes[m_id_joke]);
        m_id_joke++;

        return response;
    }

}
