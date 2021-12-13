package com.example.mitp_5_async;

import android.util.Log;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ParserService {
    public List<BtcExchangeRates> СonvertFromJson(String line) {
        List<BtcExchangeRates> btcExchangeRates = new ArrayList<BtcExchangeRates>();
        try {
            JSONObject bpiJson = new JSONObject(line);
            String bpiResult = bpiJson.getString("bpi");
            JSONObject result = new JSONObject(bpiResult);
            String usd = result.getString("USD");
            String eur = result.getString("EUR");
            String pound = result.getString("GBP");
            JSONObject usdResult = new JSONObject(usd);
            JSONObject eurResult = new JSONObject(eur);
            JSONObject poundResult = new JSONObject(pound);
            btcExchangeRates.add(new BtcExchangeRates(Double.parseDouble(usdResult.getString("rate_float")), usdResult.getString("code")));
            btcExchangeRates.add(new BtcExchangeRates(Double.parseDouble(eurResult.getString("rate_float")), eurResult.getString("code")));
            btcExchangeRates.add(new BtcExchangeRates(Double.parseDouble(poundResult.getString("rate_float")), poundResult.getString("code")));
        }
        catch (Exception e){
            Log.e("Error", e.toString());
        }
        return btcExchangeRates;
    }
}
