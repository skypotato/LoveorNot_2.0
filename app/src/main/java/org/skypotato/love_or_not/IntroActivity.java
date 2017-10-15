package org.skypotato.love_or_not;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tsengvn.typekit.TypekitContextWrapper;

public class IntroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
    }

    private void init(){
        Log.i("Function", "init()");
        startTitleAnim();
    }
    private void startTitleAnim(){
        LinearLayout laTitle = (LinearLayout) findViewById(R.id.laTitle);

        /* anim 폴더 안에 정의되어 있는 애니메이션 액션 정보를 로딩한다. */
        Animation animlaTitle = AnimationUtils.loadAnimation(this, R.anim.spreadout);
        /* Animation 상태를 확인할 listener를 등록한다. */
        animlaTitle.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                Log.i("Animation", "anim : spreadout.xml Start");
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Log.i("Animation", "anim : spreadout.xml End");
                startEdtTitleAnim();
                /* 2초 딜레이 후 화면전환을 한다. */
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                Log.i("Animation", "anim : spreadout.xml Repeat");
            }
        });
        /* Animation을 시작한다. */
        laTitle.startAnimation(animlaTitle);
    }

    private void startEdtTitleAnim(){
        TextView edtTitle = (TextView)findViewById(R.id.edtTitle);
        TextView edtSubTitle = (TextView)findViewById(R.id.edtSubTitle);

        Animation animFaidIn = AnimationUtils.loadAnimation(this, R.anim.faidin);
        /* Animation 상태를 확인할 listener를 등록한다. */
        animFaidIn.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                Log.i("Animation", "anim : spreadout.xml Start");
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Log.i("Animation", "anim : spreadout.xml End");
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                Log.i("Animation", "anim : spreadout.xml Repeat");
            }
        });
        /* Animation을 시작한다. */
        edtTitle.startAnimation(animFaidIn);
        edtSubTitle.startAnimation(animFaidIn);
    }

    private boolean startFadeInAnim(View view){
        /* 기본값 False */
        boolean result = false;

        Animation animFadeIn = AnimationUtils.loadAnimation(this, android.R.anim.fade_in);
        view.startAnimation(animFadeIn);

        /* 결과리턴 */
        return result;
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

}
