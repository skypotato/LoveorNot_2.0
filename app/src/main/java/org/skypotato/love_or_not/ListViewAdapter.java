package org.skypotato.love_or_not;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hunso on 2017-12-27.
 */

public class ListViewAdapter extends BaseAdapter {
    private Context context = null;
    private ArrayList<ListData> listData = new ArrayList<ListData>();

    public ListViewAdapter(Context context){
        super();
        this.context = context;
    }

    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Log.d("start",":::::getView()...Start");
        ViewHolder viewHolder;
        if(convertView == null){
            viewHolder = new ViewHolder();

            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listview_item, null);

            viewHolder.itemText = (EditText)convertView.findViewById(R.id.itemText);
            viewHolder.btDelete = (Button)convertView.findViewById(R.id.btDelte);

            viewHolder.btDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    removeItem(position);
                }
            });

            convertView.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        ListData data = listData.get(position);

        viewHolder.itemText.setText(data.strItem);
        Log.d("start",":::::getView()...End");
        return convertView;
    }

    public  void addItem(ListData data){
        Log.d("start",":::::addItem()...Start");
        listData.add(data);
        dataChange();
        Log.d("start",":::::addItem()...End");
    }

    public void removeItem(int position){
        Log.d("start",":::::removeItem()...Start");
        listData.remove(position);
        dataChange();
        Log.d("start",":::::removeItem()...End");
    }
    public void dataChange(){
        Log.d("start",":::::dataChange()...Start");
        this.notifyDataSetChanged();
        Log.d("start",":::::dataChange()...End");
    }
}

class ViewHolder {
    public EditText itemText;
    public Button btDelete;
}
