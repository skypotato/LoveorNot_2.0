package org.skypotato.love_or_not;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.tsengvn.typekit.TypekitContextWrapper;

import java.util.Objects;

public class SelectListActivity extends AppCompatActivity {

    Button btBack;
    Button btAdd;
    Button btImport;

    EditText addText;

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
        btImport = (Button) findViewById(R.id.btImport);
        listView = (ListView)findViewById(R.id.listView);
        listViewAdapter = new ListViewAdapter(this);

        final View footer = getLayoutInflater().inflate(R.layout.listview_footer, null, false) ;
        btAdd = (Button) footer.findViewById(R.id.btAdd);
        addText = (EditText) footer.findViewById(R.id.addText);

        listView.addFooterView(footer);
        listView.setAdapter(listViewAdapter);

        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        btBack.setOnClickListener(new OnSingleClickListener() {
            @Override
            public void onSingleClick(View v) {

            }
        });
        btAdd.setOnClickListener(new OnSingleClickListener() {
            @Override
            public void onSingleClick(View v) {
                ListData data = new ListData();
                String strText = addText.getText().toString();
                if(!Objects.equals(strText.trim(), "")) {
                    data.strItem = strText;
                }
                listViewAdapter.addItem(data);
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
