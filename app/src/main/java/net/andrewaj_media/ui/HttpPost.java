package net.andrewaj_media.ui;

import android.os.AsyncTask;
import android.widget.TextView;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;



public class HttpPost extends AsyncTask<String, Void, Integer> {

    int responseCode = 0;

    protected Integer doInBackground(String... Strings) {


        try {

            URL url = new URL("http://153.90.51.136:8080/WebServicesTest/test-resbeans.html");

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("POST");
            connection.setRequestProperty("USER-AGENT", "Mozilla/5.0");
            connection.setRequestProperty("ACCEPT-LANGUAGE", "en-US,en;0.5");

            connection.setDoOutput(true);
            DataOutputStream dStream = new DataOutputStream(connection.getOutputStream());

            //if button is clicked it will send
          //  if(nameSelected == true) {
          //      dStream.writeBytes(name);
          //  }
          //  if(phoneSelected == true) {
          //      dStream.writeBytes(phone);
          //  }
          //  if(emailSelected == true) {
          //      dStream.writeBytes(email);
          //  }

            dStream.flush();
            dStream.close();


            responseCode = connection.getResponseCode();

            System.out.println(responseCode);


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return responseCode;
    }


}

