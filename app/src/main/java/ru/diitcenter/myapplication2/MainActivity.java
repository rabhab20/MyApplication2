package ru.diitcenter.myapplication2;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText edName,edPhone, edAge;
    MyArrayAdapter adapter;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView) findViewById(R.id.listView);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                /*Intent intent = new Intent(MainActivity.this, TwoActivity.class);
                intent.putExtra("", "");
                startActivity(intent);*/
            }
        });



        edName = (EditText) findViewById(R.id.editText);
        edPhone = (EditText) findViewById(R.id.editText2);
        edAge = (EditText) findViewById(R.id.editText3);

        new MyTask(this).execute();
    }

    public void test(ArrayList<News> arrayList){
        adapter = new MyArrayAdapter(this, arrayList);
        lv.setAdapter(adapter);
    }


    public void onClickAdd(View v){
        /*People people = new People();
        people.name = edName.getText().toString();
        people.phone = edPhone.getText().toString();
        people.age = Integer.parseInt(edAge.getText().toString());

        dataBase.insert(people);

        edName.setText("");
        edPhone.setText("");
        edAge.setText("");

        cursor.requery();
        adapter.notifyDataSetChanged();*/

    }

}
