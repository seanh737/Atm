package com.sean.atm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class UserInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

    }
    public void ok(View view){
        EditText edName = (EditText) findViewById(R.id.ed_name);
        EditText edPhoneNum = (EditText) findViewById(R.id.ed_phonenum);
        String name = edName.getText().toString();
        String phonenum = edPhoneNum.getText().toString();
        getIntent().putExtra("INFO_NAME",name);
        getIntent().putExtra("INFO_PHONENUM",phonenum);
        setResult(RESULT_OK,getIntent());
        finish();
    }
}
