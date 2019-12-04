package com.example.owner_manage_java;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class SubActivity_check extends AppCompatActivity{
    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_check);
        lv=(ListView)findViewById(R.id.check_view);
        Button returnButton = findViewById(R.id.return_button);
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        CsvReader parser = new CsvReader();
        parser.reader(getApplicationContext());
        final ListViewAdapter_check listViewAdapter = new ListViewAdapter_check(this,0,parser.objects);
        lv.setAdapter(listViewAdapter);
        //csv読み込みリストへ反映終わり

        findViewById(R.id.Searchviewbutton).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                final CsvReader_editsearch editsearch = new CsvReader_editsearch();
                ListViewAdapter listViewAdapter = new ListViewAdapter(getApplicationContext(), 0, editsearch.objects);
                ListView listview = (ListView) findViewById(R.id.check_view);
                listViewAdapter.clear();
                EditText edit1 = (EditText) findViewById(R.id.editText2);
                String edit = edit1.getText().toString();
                editsearch.reader(getApplicationContext(), edit);
                listview.setAdapter(listViewAdapter);
            }
        });
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,long id){
                String item =  listViewAdapter.getItem(position).toString();
                Toast.makeText(SubActivity_check.this,
                        String.format("選択項目：%s", item),
                        Toast.LENGTH_LONG).show();

            }
        });
    }
}
