package com.sean.atm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Area3Activity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private String[] areas;
    private ListView list_area;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area3);
        list_area = (ListView) findViewById(R.id.area_T);
        areas = new String[]{"信義區","大安區","士林區"};
        ArrayAdapter adapter = new ArrayAdapter(this , android.R.layout.simple_list_item_1, areas);
        list_area.setAdapter(adapter);
        list_area.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        getIntent().putExtra("AREA_T",areas[position]);
        setResult(RESULT_OK,getIntent());
        finish();
    }
}
