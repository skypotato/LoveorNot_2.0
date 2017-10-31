package org.skypotato.love_or_not;

import android.content.Context;
import android.content.SharedPreferences;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;

import com.tsengvn.typekit.TypekitContextWrapper;

public class SettingActivity extends AppCompatActivity {

    SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        RadioButton rbStartSetting_01 = (RadioButton) findViewById(R.id.rbStartSetting_01);
        RadioButton rbStartSetting_02 = (RadioButton) findViewById(R.id.rbStartSetting_02);

        sharedPref = getSharedPreferences(getString(R.string.preference_file_key), MODE_PRIVATE);
        int defaultValue = 1; // default 값은 시작
        long settingRBValue = sharedPref.getInt(getString(R.string.setting_001), defaultValue);

        if(settingRBValue == 1){
            rbStartSetting_01.isChecked();
        }else if(settingRBValue == 2){
            rbStartSetting_02.isChecked();
        }

    }

    /* 폰트적용 */
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(TypekitContextWrapper.wrap(newBase));
    }
}
