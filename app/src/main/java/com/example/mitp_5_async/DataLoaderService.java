package com.example.mitp_5_async;



import android.os.AsyncTask;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;



public class DataLoaderService extends AsyncTask<String, String, List<BtcExchangeRates>> {
    private ParserService _parserService = new ParserService();
    ArrayList<String> listItems;
    ArrayAdapter<String> adapter;
    public DataLoaderService(ArrayAdapter<String> adapterino,  ArrayList<String> listItemo){
        adapter = adapterino;
        listItems = listItemo;
    }
    @Override
    protected List<BtcExchangeRates> doInBackground(String... params) {

        BufferedReader reader = null;
        HttpURLConnection connection = null;

        try {
            URL url = new URL(params[0]);
            connection = (HttpURLConnection) url.openConnection();
            connection.connect();

            InputStream stream = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(stream));
            String line = reader.readLine();
            List<BtcExchangeRates> rates = _parserService.СonvertFromJson(line);
            return rates;
        } catch (MalformedURLException e) {
            e.printStackTrace();
            Log.e("Error", e.toString());
        } catch (IOException e) {
            e.printStackTrace();
            Log.e("Error", e.toString());
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
                Log.e("Error", e.toString());
            }
        }
        return null;
    }
    @Override
    protected void onPostExecute(List<BtcExchangeRates> result) {
        super.onPostExecute(result);
        addItems(result);
    }
    public void addItems(List<BtcExchangeRates> btcExchangeRates) {
        for (int i=0; i<btcExchangeRates.size(); i++)
        {
            listItems.add(MessageFormat.format("{0} - {1}", btcExchangeRates.get(i).Price, btcExchangeRates.get(i).Marker));
        }
        adapter.notifyDataSetChanged();
    }
}
