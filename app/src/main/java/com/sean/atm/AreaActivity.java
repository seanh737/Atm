package com.sean.atm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class AreaActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private String[] areas;
    private ListView list_area;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area);
        list_area = (ListView) findViewById(R.id.area);
        areas = new String[]{"中正區", "暖暖區", "八堵區"};
        ArrayAdapter adapter = new ArrayAdapter(this , android.R.layout.simple_list_item_1, areas);
        list_area.setAdapter(adapter);
        list_area.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
    finish();
    }
}
