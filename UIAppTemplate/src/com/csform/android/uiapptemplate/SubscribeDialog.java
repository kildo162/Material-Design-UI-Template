package com.csform.android.uiapptemplate;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Patterns;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Pattern;



public class SubscribeDialog extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_subscribe);
        this.setFinishOnTouchOutside(false);
        SharedPreferences sp = getSharedPreferences("SUBSCRIBE", MODE_PRIVATE);
        SharedPreferences.Editor ed = sp.edit();
        ed.putBoolean("active", true);
        ed.apply();
        final TextView cancel = (TextView)findViewById(R.id.dialog_subscribe_cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               cancelSubscription();
            }
        });
        final TextView subscribe = (TextView)findViewById(R.id.dialog_subscribe_ok);
        subscribe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                proceedSubscription();
            }
        });

    }

    public void cancelSubscription() {
        finish();
    }

    private class AsyncRequest extends AsyncTask<String, Void, String> {

        @Override
        protected void onPreExecute() {

        }

        @Override
        protected String doInBackground(String... params) {
            String email = params[0];
            String json = "{\"email_address\":\"" + email + "\", \"status\":\"subscribed\"}";
            try {
                URL url = new URL(params[1]);

                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setConnectTimeout(5000);
                conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
                String mkey = "user:" + getResources().getString(R.string.mailchimp_key);
                final String basicAuth = "Basic " + Base64.encodeToString(mkey.getBytes(), Base64.NO_WRAP);

                conn.setRequestProperty("Authorization", basicAuth);
                conn.setDoOutput(true);
                conn.setDoInput(true);
                conn.setRequestMethod("POST");

                OutputStream os = conn.getOutputStream();
                os.write(json.getBytes("UTF-8"));
                os.close();
                StringBuilder sb = new StringBuilder();
                int HttpResult = conn.getResponseCode();
                if (HttpResult == HttpURLConnection.HTTP_OK) {
                 /*   Uncomment to see what is connection returning

                  BufferedReader br = new BufferedReader(
                            new InputStreamReader(conn.getInputStream(), "utf-8"));
                    String line = null;

                    while ((line = br.readLine()) != null) {
                        sb.append(line + "\n");
                    }
                    br.close();
                   // System.out.println("" + sb.toString());
                } else {
                    System.out.println(conn.getResponseMessage());*/
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return "ok";
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
        }

    }

    public void proceedSubscription() {
        if(isOnline()) {
            EditText enteredEmail;
            String query = "https://"+getResources().getString(R.string.server_num) + ".api.mailchimp.com/3.0/lists/" + getResources().getString(R.string.mailchimp_list_id) + "/members";
            enteredEmail = (EditText) findViewById(R.id.dialog_subscribe_email);
            String email = enteredEmail.getText().toString();
            if (isValidEmail(email)) {
                new AsyncRequest().execute(email, query);
            } else {
                Toast.makeText(this, "Please provide valid email address", Toast.LENGTH_SHORT).show();
                return;
            }

            Toast.makeText(this, "Subscribed", Toast.LENGTH_SHORT).show();
            SharedPreferences sp = getSharedPreferences("SUBSCRIBE", MODE_PRIVATE);
            SharedPreferences.Editor ed = sp.edit();
            ed.putInt("subscribed", 1);
            ed.apply();
            finish();
        } else Toast.makeText(this, "No connection detected", Toast.LENGTH_SHORT).show();


    }

    private boolean isValidEmail(String email) {
        Pattern pattern = Patterns.EMAIL_ADDRESS;
        return pattern.matcher(email).matches();
    }

    public boolean isOnline() {
        ConnectivityManager cm =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }
}
