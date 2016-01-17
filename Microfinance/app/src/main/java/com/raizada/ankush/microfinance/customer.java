package com.raizada.ankush.microfinance;

import java.util.Comparator;

/**
 * Created by ankush on 1/17/2016.
 */
public class customer {

        customer(String name, int price, String desc, long rating){
            this.name=name;
            this.rating=rating;
            this.desc=desc;
            this.price=price;
        }

        int id;
        String name;
        String desc;
        int price;
        String city;
        String company;
        long rating;

        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }
        public void setId(int id) {
            this.id= id;
        }

        public int getPrice() {
            return price;
        }
        public void setPrice(int price) {
            this.price = price;
        }

        public String getCity() {
            return city;
        }
        public void setCity(String city) {
            this.city = city;
        }

        public String getCompany() {
            return company;
        }
        public void setCompany(String company) {
            this.company = company;
        }

        public long getRating() {
            return rating;
        }
        public void setRating(long rating) {
            this.rating= rating;
        }

        public String getDesc() {
            return desc;
        }
        public void setDesc(String desc) {
            this.desc = desc;
        }

        public static Comparator<customer> StuNameComparator = new Comparator<customer>() {

            public int compare(customer c1, customer c2) {
                String contactName1 = c1.getName().toUpperCase();
                String contactName2 = c2.getName().toUpperCase();

                //ascending order
                return contactName1.compareTo(contactName2);

                //descending order
                //return StudentName2.compareTo(StudentName1);
            }};



//<android.support.design.widget.CoordinatorLayout xmlns:android="http://schemas.android.com/apk/res/android"
//        xmlns:app="http://schemas.android.com/apk/res-auto"
//        xmlns:tools="http://schemas.android.com/tools"
//        android:layout_width="match_parent"
//        android:layout_height="match_parent"
//        android:fitsSystemWindows="true"
//        tools:context="com.raizada.ankush.mircofinance.CustomerList">
//
//<android.support.design.widget.AppBarLayout
//        android:layout_width="match_parent"
//        android:layout_height="wrap_content"
//        android:theme="@style/AppTheme.AppBarOverlay">
//
//<android.support.v7.widget.Toolbar
//        android:id="@+id/toolbar"
//        android:layout_width="match_parent"
//        android:layout_height="?attr/actionBarSize"
//        android:background="?attr/colorPrimary"
//        app:popupTheme="@style/AppTheme.PopupOverlay" />
//
//</android.support.design.widget.AppBarLayout>
//</android.support.design.widget.CoordinatorLayout>

}
