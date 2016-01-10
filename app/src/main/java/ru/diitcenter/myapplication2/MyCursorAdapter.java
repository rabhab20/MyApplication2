package ru.diitcenter.myapplication2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

/**
 * Created by marat on 19.12.15.
 */
public class MyCursorAdapter extends CursorAdapter {

    private LayoutInflater mInflater;

    public MyCursorAdapter(Context context, Cursor cursor){
        super(context, cursor, 1);

        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView txName = (TextView) view.findViewById(R.id.textView2);
        TextView txPhone = (TextView) view.findViewById(R.id.textView3);
        TextView txAge = (TextView) view.findViewById(R.id.textView4);

        String name = cursor.getString(cursor.getColumnIndex("name"));
        String phone = cursor.getString(cursor.getColumnIndex("phone"));
        String age = cursor.getString(cursor.getColumnIndex("age"));
        txName.setText(name);
        txPhone.setText(phone);
        txAge.setText(age);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return mInflater.inflate(R.layout.item, parent, false);
    }
}
