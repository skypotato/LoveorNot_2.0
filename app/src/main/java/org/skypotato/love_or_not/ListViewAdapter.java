package org.skypotato.love_or_not;

import android.content.Context;
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
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null){
            viewHolder = new ViewHolder();

            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listview_item, null);

            viewHolder.itemText = (EditText)convertView.findViewById(R.id.itemText);
            viewHolder.btDelte = (Button)convertView.findViewById(R.id.btDelte);

            convertView.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        ListData data = listData.get(position);

        viewHolder.itemText.setText(data.strItem);
        return convertView;
    }

    public  void addItem(ListData data){
        listData.add(data);
        dataChange();
    }

    public void removeItem(int position){
        listData.remove(position);
        dataChange();
    }
    public void dataChange(){
        this.notifyDataSetChanged();
    }
}

class ViewHolder {
    public EditText itemText;
    public Button btDelte;
}
