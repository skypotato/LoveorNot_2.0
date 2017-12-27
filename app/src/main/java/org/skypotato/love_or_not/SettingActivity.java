package org.skypotato.love_or_not;

import android.content.Context;
import android.content.SharedPreferences;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.tsengvn.typekit.TypekitContextWrapper;

public class SettingActivity extends AppCompatActivity {

    SharedPreferences sharedPref;

    RadioGroup rgStartSetting;
    RadioButton rbStartSetting_01;
    RadioButton rbStartSetting_02;

    Button btBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        settingView(); // 화면구성
    }
    // 화면구성
    public void settingView(){
        Log.d("start",":::::settingView()...Start");

        btBack = (Button) findViewById(R.id.btBack);
        rgStartSetting = (RadioGroup) findViewById(R.id.rgStartSetting);
        rbStartSetting_01 = (RadioButton) findViewById(R.id.rbStartSetting_01);
        rbStartSetting_02 = (RadioButton) findViewById(R.id.rbStartSetting_02);

        rgStartSetting.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                SharedPreferences pref = getSharedPreferences(getString(R.string.preference_file_key), MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();

                switch (checkedId) {
                    case R.id.rbStartSetting_01:
                            editor.putInt(getString(R.string.setting_001), 1);
                        break;

                    case R.id.rbStartSetting_02:
                            editor.putInt(getString(R.string.setting_001), 2);
                        break;
                }

                editor.commit();
            }
        });

        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        Log.d("start",":::::settingView()...End");
    }

    public void getStartSetting(){
        Log.d("start",":::::getStartSetting()...Start");
        sharedPref = getSharedPreferences(getString(R.string.preference_file_key), MODE_PRIVATE);
        long settingRBValue = sharedPref.getInt(getString(R.string.setting_001), 1);

        if (settingRBValue == 1) {
            rbStartSetting_01.setChecked(true);
            rbStartSetting_02.setChecked(false);
        } else if (settingRBValue == 2) {
            rbStartSetting_01.setChecked(false);
            rbStartSetting_02.setChecked(true);
        }
        Log.d("start",":::::getStartSetting()...End");
    }


    /* 폰트적용 */
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(TypekitContextWrapper.wrap(newBase));
    }
}
