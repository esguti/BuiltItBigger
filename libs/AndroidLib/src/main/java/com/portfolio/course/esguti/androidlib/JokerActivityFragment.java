package com.portfolio.course.esguti.androidlib;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A placeholder fragment containing a simple view.
 */
public class JokerActivityFragment extends Fragment {

    public JokerActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_joke, container, false);
        Intent intent = getActivity().getIntent();
        String joke = intent.getStringExtra(JokerActivity.JOKE_KEY);
        TextView jokeTextView = (TextView) root.findViewById(R.id.jokeTextView);
        if (joke != null && joke.length() != 0) {
            jokeTextView.setText(joke);
        }

        return root;

    }
}
