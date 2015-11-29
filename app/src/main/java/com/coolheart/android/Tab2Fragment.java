package com.coolheart.android;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by JMac on 27/11/15.
 */
public class Tab2Fragment extends Fragment {

    private List<HashMap<String, String>> myList = new ArrayList<HashMap<String, String>>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.tab2, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        for(int i=0; i<20; i++) {

            Map<String,String> data =  new HashMap<String,String>();
            data.put("title","Title " + i);
            data.put("subtitle","Description " + i);

            myList.add((HashMap<String, String>) data);
        }

        CustomAdapter adapter = new CustomAdapter(getActivity());
        ListView listView = (ListView)getView().findViewById(R.id.listView2);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                HashMap<String, String> data = myList.get(position);
                Toast.makeText(getActivity(), "Clicked at: " + data.get("title"),Toast.LENGTH_LONG).show();
            }
        });
    }

    public class CustomAdapter extends BaseAdapter {

        Context context;

        public CustomAdapter(Context ctx) {
            context = ctx;
        }

        @Override
        public int getCount() {
            return myList.size();
        }

        @Override
        public Object getItem(int position) {
            return myList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            if(convertView == null) {

                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.customlistitem, parent, false);
            }

            TextView title = (TextView)convertView.findViewById(R.id.textView1);
            TextView subtitle = (TextView)convertView.findViewById(R.id.textView2);

            HashMap<String, String> data = myList.get(position);
            title.setText(data.get("title"));
            subtitle.setText(data.get("subtitle"));

            return convertView;
        }
    }
}
