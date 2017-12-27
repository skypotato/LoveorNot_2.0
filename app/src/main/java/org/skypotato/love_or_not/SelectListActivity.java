package org.skypotato.love_or_not;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class SelectListActivity extends AppCompatActivity {

    ListView listView;
    ListViewAdapter listViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_list);
    }

    public void settingView(){
        listView = (ListView)findViewById(R.id.listView);
        listViewAdapter = new ListViewAdapter(this);

        listView.setAdapter(listViewAdapter);

        for(int i = 0;i<10;i++){
            ListData data = new ListData();
            data.strItem = "리스트 "+i;
            listViewAdapter.addItem(data);
        }
    }
}
