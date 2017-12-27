package org.skypotato.love_or_not;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.tsengvn.typekit.TypekitContextWrapper;

public class MainActivity extends AppCompatActivity {

   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       Button btStart = (Button)findViewById(R.id.btStart);
       Button btSetting = (Button)findViewById(R.id.btSetting);
       Button btEnd = (Button)findViewById(R.id.btEnd);

       btStart.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

           }
       });

       btStart.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               startSelectListActivity();
           }
       });

       btSetting.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               startSettingActivity();
           }
       });

       btEnd.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               finish();
           }
       });
    }

    private void startSelectListActivity(){
        Log.i("Function", "startSettingActivity()");
        /* 인텐트 생성(현 액티비티, 새로 실행할 액티비티) */
        Intent intent = new Intent(MainActivity.this, SelectListActivity.class);
        /* 액티비티 실행 */
        startActivity(intent);
        /* 자연스럽게 넘어가도록 Animation 주기 */
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    private void startSettingActivity(){
        Log.i("Function", "startSettingActivity()");
        /* 인텐트 생성(현 액티비티, 새로 실행할 액티비티) */
        Intent intent = new Intent(MainActivity.this, SettingActivity.class);
        /* 액티비티 실행 */
        startActivity(intent);
        /* 자연스럽게 넘어가도록 Animation 주기 */
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    /* 폰트적용 */
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(TypekitContextWrapper.wrap(newBase));
    }

}
