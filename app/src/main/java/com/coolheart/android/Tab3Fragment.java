package com.coolheart.android;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

/**
 * Created by JMac on 27/11/15.
 */
public class Tab3Fragment extends Fragment {

    List<String> mobileArray = Arrays.asList("Android", "IPhone", "WindowsMobile", "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X", "Android", "IPhone", "WindowsMobile", "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X", "Android", "IPhone", "WindowsMobile", "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X");

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.tab3, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        RecyclerView recList = (RecyclerView)getActivity().findViewById(R.id.cardList);
        recList.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recList.setLayoutManager(llm);

        ContactAdapter mAdapter = new ContactAdapter(getActivity(), mobileArray);
        recList.setAdapter(mAdapter);

        ContactAdapter.OnItemClickListener onItemClickListener = new ContactAdapter.OnItemClickListener() {

            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(getActivity(), "Clicked " + position, Toast.LENGTH_SHORT).show();
            }
        };
        mAdapter.SetOnItemClickListener(onItemClickListener);
    }

    public static class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {

        Context mContext;
        private List<String> contactList;
        OnItemClickListener mItemClickListener;

        public ContactAdapter(Context context, List<String> contactList) {
            this.mContext = context;
            this.contactList = contactList;
        }

        @Override
        public ContactAdapter.ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout, parent, false);
            return new ContactViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(ContactAdapter.ContactViewHolder holder, int position) {

            String mobile = contactList.get(position);
            holder.vName.setText(mobile);
        }

        @Override
        public int getItemCount() {
            return contactList.size();
        }

        //View Holder
        public class ContactViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

            protected TextView vName;

            public ContactViewHolder(View v) {
                super(v);

                vName =  (TextView) v.findViewById(R.id.txtName);
            }

            @Override
            public void onClick(View v) {

                if (mItemClickListener != null) {
                    mItemClickListener.onItemClick(v, getLayoutPosition());
                }
            }
        }

        public interface OnItemClickListener {
            void onItemClick(View view, int position);
        }

        public void SetOnItemClickListener(final OnItemClickListener mItemClickListener) {
            this.mItemClickListener = mItemClickListener;
        }
    }
}
