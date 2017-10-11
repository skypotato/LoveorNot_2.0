package org.skypotato.love_or_not;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.tsengvn.typekit.TypekitContextWrapper;

public class IntroActivity extends AppCompatActivity {

    Handler handler; // 핸들러 선언

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        handler= new Handler(); //딜래이를 주기 위해 핸들러 생성
        handler.postDelayed(runnable, 2000); // 딜레이 ( 런어블 객체는 mrun, 시간 2초)
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(TypekitContextWrapper.wrap(newBase));
    }

    Runnable runnable = new Runnable(){
        @Override
        public void run(){
            Log.i("function", "run()");
            Intent intent = new Intent(IntroActivity.this, MainActivity.class); //인텐트 생성(현 액티비티, 새로 실행할 액티비티)
            startActivity(intent);
            finish();
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        }
    };

    @Override
    protected void onDestroy() {
        Log.i("function", "onDestroy()");
        handler.removeCallbacks(runnable);
        super.onDestroy();
    }
}
