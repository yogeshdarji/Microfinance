package com.raizada.ankush.microfinance;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomerList extends AppCompatActivity {

    ArrayList<customer> fillMaps=new ArrayList<>();
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);

        //micro finance business logic
        //listView declaration
        lv = (ListView) findViewById(R.id.listView);

        //business logic starts now
        //reading from parse database

        Parse.enableLocalDatastore(this);
        Parse.initialize(this, "lpxsG8UTf5eMl1kNTVKPv5ROrXG4MQTC81TZuVy0", "sr7T9vGQFITASh8rrIY1OoHDpDS3fw3bOXvbykJi");

        //ParseObject MicroFinance = new ParseObject("MicroFinance");
//        MicroFinance.put("score", 1337);
//        MicroFinance.put("playerName", "Sean Plott");
//        MicroFinance.put("cheatMode", false);
        //MicroFinance.saveInBackground();

//        String name1 = MicroFinance.getString("name");
//        System.out.println("name1"+name1);

        //populating the arraylist with all customers
        ParseQuery<ParseObject> query = ParseQuery.getQuery("MicroFinance");
        query.findInBackground(new FindCallback<ParseObject>() {

            @Override
            public void done(List<ParseObject> object, com.parse.ParseException e) {
                if (e == null) {
                    System.out.println("Came here finally!");
                    for (int i = 0; i < object.size(); i++) {
                        fillMaps.add(new customer(object.get(i).getString("company"), object.get(i).getInt("price"),
                                object.get(i).getString("desc"), object.get(i).getLong("Rating")));
                        System.out.println("object here in for" + object.get(i).getString("company"));
                    }
                } else {
                    System.out.println("I will come here atleast now");
                    e.printStackTrace();
                }

                //Sorting the arraylist of customers
                Collections.sort(fillMaps, customer.StuNameComparator);

                // fill in the grid_item layout

            }
        });

        StatusAdapter adapter= new StatusAdapter(this, fillMaps);
        lv.setAdapter(adapter);

        //lv.setAdapter(new ArrayAdapter<customer>(this,R.layout.homepagecustomlayout ,android.R.id.text1 ,fillMaps));
    }
}
