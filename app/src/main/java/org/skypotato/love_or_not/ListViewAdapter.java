package org.skypotato.love_or_not;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hunso on 2017-12-27.
 * Custom ListViewAdapter
 */

public class ListViewAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<ListData> listData = new ArrayList<>();

    ListViewAdapter(Context context) {
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
        Log.d("start", ":::::getView()...Start");
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            assert inflater != null;
            convertView = inflater.inflate(R.layout.listview_item, parent);

            viewHolder.itemText = convertView.findViewById(R.id.itemText);
            viewHolder.btDelete = convertView.findViewById(R.id.btDelte);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.btDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removeItem(position);
            }
        });

        ListData data = listData.get(position);

        viewHolder.itemText.setText(data.strItem);
        Log.d("start", ":::::getView()...End");
        return convertView;
    }

    void addItem(ListData data) {
        Log.d("start", ":::::addItem()...Start");
        // 빈 값이 들어올 경우 메시지 처리
        if(data.strItem == null || "".equals(data.strItem.trim())) {
            Toast toast = Toast.makeText(context,"목록에 추가할 값을 입력해주세요.",Toast.LENGTH_SHORT);
            toast.show();
            return;
        }
        listData.add(data);
        dataChange();
        Log.d("start", ":::::addItem()...End");
    }

    private void removeItem(int position) {
        Log.d("start", ":::::removeItem()...Start");
        Log.i("remove", ":::::removeItem() position : " + position);
        listData.remove(position);
        dataChange();
        Log.d("start", ":::::removeItem()...End");
    }

    // ListView Data가 변경되었을 때 호출해야하는 Function
    private void dataChange() {
        Log.d("start", ":::::dataChange()...Start");
        this.notifyDataSetChanged();
        Log.d("start", ":::::dataChange()...End");
    }
}

class ViewHolder {
    EditText itemText;
    Button btDelete;
}
