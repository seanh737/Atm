package com.sean.atm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class UserInfoActivity extends AppCompatActivity {


    private EditText edName;
    private EditText edPhoneNum;

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

    }
    public void ok(View view){

        String name = edName.getText().toString();
        String phonenum = edPhoneNum.getText().toString();
        getIntent().putExtra("INFO_NAME",name);
        getIntent().putExtra("INFO_PHONENUM",phonenum);
        setResult(RESULT_OK,getIntent());
        finish();
    }
}
