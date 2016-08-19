package com.lei.phonenumber;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.List;

/**
 * Created by CCC on 2016/8/19.
 */
public class MyAdapter extends BaseAdapter {

    private List<PhoneInfo> list;
    private Context context;

    public MyAdapter(List<PhoneInfo> list,Context context){
        this.list = list;
        this.context = context;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view;
        ViewHolder viewHolder;
        if (convertView==null){
            view= LayoutInflater.from(context).inflate(R.layout.item_common,null);
            viewHolder=new ViewHolder();
            viewHolder.tvName=(TextView)view.findViewById(R.id.tvName);
            viewHolder.tvContent=(TextView)view.findViewById(R.id.tvContent);
            view.setTag(viewHolder);//store up viewHolder
        }else {
            view=convertView;
            viewHolder=(ViewHolder)view.getTag();
        }
        viewHolder.tvName.setText(list.get(position).getName());
        viewHolder.tvContent.setText("电话: "+list.get(position).getNumber());
        return view;
    }

    private class ViewHolder{
        TextView tvName,tvContent;
    }

}
