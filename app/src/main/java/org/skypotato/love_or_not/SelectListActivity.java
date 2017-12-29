package org.skypotato.love_or_not;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.tsengvn.typekit.TypekitContextWrapper;

public class SelectListActivity extends AppCompatActivity {

    Button btBack;

    ListView listView;
    ListViewAdapter listViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_list);

        settingView();
    }

    public void settingView(){
        Log.d("start",":::::settingView()...Start");

        btBack = (Button) findViewById(R.id.btBack);
        listView = (ListView)findViewById(R.id.listView);
        listViewAdapter = new ListViewAdapter(this);

        listView.setAdapter(listViewAdapter);

        for(int i = 0;i<10;i++){
            ListData data = new ListData();
            data.strItem = "리스트 "+i;
            listViewAdapter.addItem(data);
        }

        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        Log.d("start",":::::settingView()...End");
    }

    /* 폰트적용 */
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(TypekitContextWrapper.wrap(newBase));
    }
}
