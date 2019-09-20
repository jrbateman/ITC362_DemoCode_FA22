package com.bateman.shades;

import android.view.View;
import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;


public class MyListFragment extends Fragment {
    private OnItemSelectedListener listener;
    private String information;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.color_list_fragment, container,
                false);

        Button button1 = view.findViewById(R.id.button1);
        button1.setOnClickListener(ShadeChangeListener);

        Button button2 = view.findViewById(R.id.button2);
        button2.setOnClickListener(ShadeChangeListener);

        Button button3 = view.findViewById(R.id.button3);
        button3.setOnClickListener(ShadeChangeListener);



        return view;
    }

    private OnClickListener ShadeChangeListener = new OnClickListener() {
        public void onClick(View view) {
            String description = (String) view.getContentDescription();
            information = description;
            updateDetail();
        }
    };

    public interface OnItemSelectedListener {
        void onShadeItemSelected(String link);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof OnItemSelectedListener) {
            listener = (OnItemSelectedListener) activity;
        } else {
            throw new ClassCastException(activity.toString()
                    + " must implemenet MyListFragment.OnItemSelectedListener");
        }
    }

    public void updateDetail() {
        listener.onShadeItemSelected(information);
    }
}
