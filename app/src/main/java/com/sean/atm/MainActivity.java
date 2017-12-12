package com.sean.atm;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public  static final /*不再改變*/ int FUNC_LOGIN = 6 ;
    public  static final int REQUEST_LOGIN = 1 ;
    public  static final int REQUEST_USERINFO = 2 ;
    boolean logon = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(!logon){
            Intent intent = new Intent(this, LoginActivity.class);
//            startActivity(intent);
            startActivityForResult(intent , REQUEST_LOGIN);
        }
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this ,UserInfoActivity.class);
                startActivityForResult(intent , REQUEST_USERINFO);
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case REQUEST_LOGIN:
                    if(resultCode == RESULT_OK){
                        String userid = data.getStringExtra("LOGIN_USERID");
                        String passwd = data.getStringExtra("LOGIN_PASSWD");
//                Log.d("RESULT", userid + "/"+ passwd);
                        Toast.makeText(this,"LogingID"+userid,Toast.LENGTH_LONG).show();

                        getSharedPreferences("atm", MODE_PRIVATE)   //偏好設定  12/12
                                .edit()
                                .putString("USERID", userid)
                                .apply();

                    }else{
                        finish();
                }
                break;
            case REQUEST_USERINFO:
                if (resultCode == RESULT_OK){
                    String name = data.getStringExtra("INFO_NAME");
                    String phonenum = data.getStringExtra("INFO_PHONENUM");
                    Toast.makeText(this, "Name : " +name, Toast.LENGTH_LONG).show();
                    Toast.makeText(this, "Phone Number : " +phonenum, Toast.LENGTH_LONG).show();
                }
                break;
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
