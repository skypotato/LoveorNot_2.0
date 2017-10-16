package org.skypotato.love_or_not;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tsengvn.typekit.TypekitContextWrapper;

public class IntroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        startAnim();
    }
    private void startAnim(){
        LinearLayout laTitle  = (LinearLayout)findViewById(R.id.laTitle);

        /* anim 폴더 안에 정의되어 있는 애니메이션 액션 정보를 로딩한다. */
        Animation animSpreadOut = AnimationUtils.loadAnimation(this, R.anim.spreadout);

        animSpreadOut.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                Log.i("Animation", "anim : spreadout.xml Start");
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Log.i("Animation", "anim : spreadout.xml End");
                startMainActivity();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                Log.i("Animation", "anim : spreadout.xml Repeat");
            }
        });
        laTitle.startAnimation(animSpreadOut);

    }

    private void startMainActivity(){
        Log.i("Function", "startMainActivity()");
        /* 인텐트 생성(현 액티비티, 새로 실행할 액티비티) */
        Intent intent = new Intent(IntroActivity.this, MainActivity.class);
        /* 액티비티 실행 */
        startActivity(intent);
        /* IntroActivity 닫기 */
        finish();
        /* 자연스럽게 넘어가도록 Animation 주기 */
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    /* 폰트적용 */
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(TypekitContextWrapper.wrap(newBase));
    }
}
