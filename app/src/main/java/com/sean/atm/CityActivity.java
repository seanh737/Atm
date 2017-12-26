package com.sean.atm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class CityActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private String[] cities;
    public  static final int REQUEST_CITY = 1 ;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CITY){
            Toast.makeText(this ,"中正區", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);
        ListView city = (ListView) findViewById(R.id.city);
        cities = new String[]{"基隆市", "新北市", "台北市"};
        ArrayAdapter adapter = new ArrayAdapter(this , android.R.layout.simple_list_item_1, cities);
        city.setAdapter(adapter);
        city.setOnItemClickListener(this);



    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        if (position == 0) {
            Intent intent = new Intent(this, AreaActivity.class);
            startActivityForResult(intent, REQUEST_CITY);
        }
        if (position == 1) {
            Intent intent = new Intent(this, AreaActivity.class);
            startActivityForResult(intent, REQUEST_CITY);
        }
        if (position == 2) {
            Intent intent = new Intent(this, AreaActivity.class);
            startActivityForResult(intent, REQUEST_CITY);
        }

    }
}
