package com.raizada.ankush.microfinance;

import android.app.ProgressDialog;

/**
 * Created by yogeshdarji on 1/17/16.
 */
public class ServerRequest {

    ProgressDialog progressDialog;
    public  static final int CONNECTION_TIMEOUT= 1000*15;
    public  static final String SERVER_ADDRESS = "";  //MY SERVER ADDRESS

//    public ServerRequests(Context context) {
//        progressDialog = new ProgressDialog(context);
//        progressDialog.setCancelable(false);
//        progressDialog.setTitle("Processing...");
//        progressDialog.setMessage("Please wait...");
//    }

    public void storeUserDataInBackground(com.example.yogeshdarji.loginregister.User user,
                                          GetUserCallback userCallBack) {
        progressDialog.show();
      //  new StoreUserDataAsyncTask(user, userCallBack).execute();
    }


}
