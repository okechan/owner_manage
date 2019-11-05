package com.example.owner_manage_java;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ListViewAdapter extends ArrayAdapter<ListData> {
    private LayoutInflater layoutInflater;

    public ListViewAdapter(Context context, int resource, List<ListData> objects) {
        super(context, resource, objects);
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ListData data = (ListData)getItem(position);
        if (null == convertView) {
            convertView = layoutInflater.inflate(R.layout.list_item, null);
        }

        TextView idText;
        TextView nameText;
        TextView adminText;
        TextView placeText;
        TextView numberText;
        TextView yearText;
        TextView monthText;
        TextView dayText;

        idText = (TextView)convertView.findViewById(R.id.id);
        nameText = (TextView)convertView.findViewById(R.id.name);
        adminText = (TextView)convertView.findViewById(R.id.admin);
        placeText = (TextView)convertView.findViewById(R.id.place);
        numberText = (TextView)convertView.findViewById(R.id.number);
        yearText = (TextView)convertView.findViewById(R.id.year);
        monthText = (TextView)convertView.findViewById(R.id.month);
        dayText = (TextView)convertView.findViewById(R.id.day);

        idText.setText("資産コード"+data.getId());
        nameText.setText(data.getName());
        adminText.setText(data.getadmin());
        placeText.setText(data.getplace());
        numberText.setText(data.getnumber());
        yearText.setText(data.getyear()+data.getmonth()+data.getday());

        return convertView;
    }
}