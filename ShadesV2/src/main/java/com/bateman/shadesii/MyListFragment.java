package com.bateman.shadesii;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyListFragment extends Fragment {
    private OnItemSelectedListener listener;
    List<String> shadelisting;
    List<String> shadeNameDetail;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        shadelisting = new ArrayList<String>(Arrays.asList(DummyData.shade_name));
        shadeNameDetail = new ArrayList<String>(Arrays.asList(DummyData.shade_detail));

        // Now that we have some dummy shade data, create an ArrayAdapter.
        // The ArrayAdapter will take data from a source (like our dummy shades) and
        // use it to populate the ListView it's attached to.
        final ArrayAdapter<String> mShadeAdapter =
                new ArrayAdapter<String>(
                        getActivity(), // The current context (this activity)
                        R.layout.list_item_shade, // The name of the layout ID.
                        R.id.list_item_shade_textview, // The ID of the textview to populate.
                        shadelisting);

        View rootView =
                inflater.inflate(R.layout.color_list_fragment,
                        container,
                        false);

        // Get a reference to the ListView, and attach this adapter to it.
        ListView listView = rootView.findViewById(R.id.listview_shades);
        listView.setAdapter(mShadeAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String shadeIndexString = mShadeAdapter.getItem(i);
                String information = shadeIndexString + "\n\n\n" + shadeNameDetail.get(i);
                updateDetail(information);
            }

        });

        return rootView;
    }
    public interface OnItemSelectedListener {
        void onColorItemSelected(String link);

    }
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof OnItemSelectedListener) {
            listener = (OnItemSelectedListener) activity;
        } else {
            throw new ClassCastException(activity.toString()
                    + " must implement MyListFragment.OnItemSelectedListener");
        }
    }
    public void updateDetail(String information) {
        listener.onColorItemSelected(information);
    }

}
