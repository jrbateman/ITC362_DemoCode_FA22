package com.bateman.shadesii;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class InformationFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.information_fragment, container, false);
        return view;

    }

    public void setText (String item) {
        TextView view = getView().findViewById(R.id.textView1);
        view.setText(item);
    }


}
