package ru.diitcenter.myapplication2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyArrayAdapter extends ArrayAdapter<News> {

    public MyArrayAdapter(Context context, ArrayList<News> arrayList){
        super(context, R.layout.item ,arrayList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        View rovView = layoutInflater.inflate(R.layout.item, null);

        TextView txName = (TextView) rovView.findViewById(R.id.textView2);
        TextView txPhone = (TextView) rovView.findViewById(R.id.textView3);
        TextView txAge = (TextView) rovView.findViewById(R.id.textView4);

        News item = getItem(position);
        txName.setText(item.region);
        //txPhone.setText(item.phone);

        return rovView;
    }
}
