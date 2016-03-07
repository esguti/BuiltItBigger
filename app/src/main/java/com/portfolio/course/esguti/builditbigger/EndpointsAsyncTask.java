package com.portfolio.course.esguti.builditbigger;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Pair;

import com.portfolio.course.esguti.JavaLib.Joker;

/**
 * Created by esguti on 07.03.16.
 */
public class EndpointsAsyncTask extends AsyncTask<Void, Void, String> {

    public interface EnpointResponse { void showJoke(String joke); }

    private EnpointResponse m_delegate = null;
    private String m_root_url = "";

    public EndpointsAsyncTask( EnpointResponse delegate, String root_url ){
        m_delegate = delegate;
        m_root_url = root_url;
    }

    @Override
    protected String doInBackground(Void... params) {
        Joker joker_class = new Joker(m_root_url);
        return joker_class.tellJoke();
    }

    @Override
    protected void onPostExecute(String result){
        if( m_delegate != null) m_delegate.showJoke(result);
    }
}
