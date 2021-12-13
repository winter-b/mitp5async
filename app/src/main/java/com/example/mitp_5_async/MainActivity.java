package com.example.mitp_5_async;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button callButton;
    private ListView simpleList;
    ArrayAdapter<String> adapter;
    ArrayList<String> listItems=new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        callButton = (Button) findViewById(R.id.buttonCall);
        simpleList = (ListView) findViewById(R.id.listView);
        adapter=new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                listItems);
        setListAdapter(adapter);
        callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    new DataLoaderService(adapter, listItems).execute("https://api.coindesk.com/v1/bpi/currentprice.json");
                }
                catch (Exception e){
                    Log.e("Error", e.toString());
                }
            }
        });
    }
    protected void setListAdapter(ListAdapter adapter) {
        getListView().setAdapter(adapter);
    }
    protected ListView getListView() {
        if (simpleList == null) {
            simpleList = (ListView) findViewById(R.id.listView);
        }
        return simpleList;
    }

}
