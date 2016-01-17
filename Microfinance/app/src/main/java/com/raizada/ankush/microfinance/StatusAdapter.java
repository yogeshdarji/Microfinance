package com.raizada.ankush.microfinance;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ankush on 1/17/2016.
 */
public class StatusAdapter extends ArrayAdapter {
        public Context mContext;
        public List mStatus;

        public StatusAdapter(Context context, ArrayList<customer> status) {
            super(context, R.layout.homepagecustomlayout, status);
            mContext = context;
            mStatus = status;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            customer details = (customer) getItem(position);
            if (convertView == null) {
                convertView = LayoutInflater.from(mContext).inflate(
                        R.layout.homepagecustomlayout, null);
                holder = new ViewHolder();
                holder.custHomepage = (TextView) convertView
                        .findViewById(R.id.custName);
                holder.custDesc = (TextView) convertView
                        .findViewById(R.id.custDesc);
//                holder.custRating = (TextView) convertView
//                        .findViewById(R.id.custRating);

                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            //populate the data into the text fields
            holder.custHomepage.setText("   "+details.getName()+"                $"+details.getPrice());
            holder.custDesc.setText("          "+details.getDesc()+"                    "+details.getRating());
            //holder.custRating.setText("              "+details.getRating());
            return convertView;
        }

        public static class ViewHolder {
            TextView custHomepage;
            TextView custDesc;
            //TextView custRating;
//            TextView ;


        }


}
