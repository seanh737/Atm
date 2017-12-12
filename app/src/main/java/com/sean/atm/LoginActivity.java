package com.sean.atm;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    public void login(View view){
        EditText edUserid = (EditText) findViewById(R.id.userid);
        EditText edpasswd = (EditText) findViewById(R.id.passwd);
        String userid = edUserid.getText().toString();
        String passwd = edpasswd.getText().toString();
        if(userid.equals("jack") && passwd.equals("12345")){
            Toast.makeText(this , "登入成功" , Toast.LENGTH_LONG).show();
            getIntent().putExtra("LOGIN_USERID", userid);
            getIntent().putExtra("LOGIN_PASSWD", passwd);
            setResult(RESULT_OK, getIntent());
            finish();
        }else{      //登入失敗
            new AlertDialog.Builder(this)
                    .setTitle("錯誤")
                    .setMessage("登入失敗")
                    .setPositiveButton("OK",null)
                    .show();
        }
    }
    public  void cancel(View view){

    }

}
