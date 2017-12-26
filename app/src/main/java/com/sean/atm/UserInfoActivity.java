package com.sean.atm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class UserInfoActivity extends AppCompatActivity {


    private EditText edName;
    private EditText edPhoneNum;
    private Spinner age;
    private String TAG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        edName = (EditText) findViewById(R.id.ed_name);
        edPhoneNum = (EditText) findViewById(R.id.ed_phonenum);
        String name = getSharedPreferences("info", MODE_PRIVATE)
                .getString("NAME" ,"");
        String phonenum = getSharedPreferences("info", MODE_PRIVATE)
                .getString("PHONENUM" ,"");
        edName.setText(name);
        edPhoneNum.setText(phonenum);
        // 12/19 下拉式捲軸 sipnner
        age = (Spinner) findViewById(R.id.age);
//        ArrayList<String> data = new ArrayList<>();//能運用陣列   以下兩種方法
//        for (int i = 15; i <= 40 ; i++){
//            data.add(i+"");
//        }
//        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, data);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.aaa, android.R.layout.simple_list_item_1);  //利用values>>strings.xml  來儲存資料
        age.setAdapter(adapter);

    }
    public void address(View view){
        startActivity(new Intent(this, CityActivity.class));
    }
    public void ok(View view){
        Log.d(TAG, "ok" +age.getSelectedItem().toString());
        String name = edName.getText().toString();
        String phonenum = edPhoneNum.getText().toString();
        getIntent().putExtra("INFO_NAME",name);
        getIntent().putExtra("INFO_PHONENUM",phonenum);
        setResult(RESULT_OK,getIntent());
        finish();
    }
}
