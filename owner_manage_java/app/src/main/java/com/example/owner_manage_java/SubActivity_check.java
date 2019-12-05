package com.example.owner_manage_java;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.example.owner_manage_java.CsvReader.arraylist;

public class SubActivity_check extends AppCompatActivity{
    private ListView lv;
    final CsvReader csvReader_list = new CsvReader();
    private static String[][] itemlist = new String[10000][8];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_check);
        lv=(ListView)findViewById(R.id.check_view);
        Button returnButton = findViewById(R.id.return_button);
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SubActivity_check.this,
                        String.format("ファイルが出力されました"),
                        Toast.LENGTH_LONG).show();
                finish();
            }
        });
        final CsvReader parser = new CsvReader();
        parser.reader(getApplicationContext());
        final ListViewAdapter_check listViewAdapter = new ListViewAdapter_check(this,0,parser.objects);
        lv.setAdapter(listViewAdapter);
        //csv読み込みリストへ反映終わり

        findViewById(R.id.clean).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                final CsvReader_editsearch editsearch = new CsvReader_editsearch();
                ListViewAdapter_check listViewAdapter_edit = new ListViewAdapter_check(getApplicationContext(), 0, editsearch.objects);
                listViewAdapter.clear();
                ListView listview = (ListView) findViewById(R.id.check_view);
                parser.reader(getApplicationContext());
                listview.setAdapter(listViewAdapter);

            }
        });


        findViewById(R.id.Searchviewbutton).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                final CsvReader_editsearch editsearch = new CsvReader_editsearch();
                ListViewAdapter_check listViewAdapter = new ListViewAdapter_check(getApplicationContext(), 0, editsearch.objects);
                ListView listview = (ListView) findViewById(R.id.check_view);
                listViewAdapter.clear();
                EditText edit1 = (EditText) findViewById(R.id.editText2);
                String edit = edit1.getText().toString();
                editsearch.reader(getApplicationContext(), edit);
                listview.setAdapter(listViewAdapter);
            }
        });
        /*lv.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,long id) {
                long item = listViewAdapter.getItemId(position);
                Toast.makeText(SubActivity_check.this,
                        String.format("選択項目：%s", item),
                        Toast.LENGTH_LONG).show();
            }
        });*/
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(){
            public boolean onItemLongClick(AdapterView<?> av,View view,int position,long id){
                long things = listViewAdapter.getItemId(position);
                int thing = (int)things;
                arraylist.get(thing).set(5,getthisyear());
                arraylist.get(thing).set(6,getthismonth());
                arraylist.get(thing).set(7,gettoday());
                CsvWriter.writer(arraylist);
                Toast.makeText(SubActivity_check.this,
                        String.format("チェックされました"),
                        Toast.LENGTH_LONG).show();
                return false;
            }

        }
        );
    }
    public static String[][] get(){
        return itemlist;
    }
    public static String gettoday(){
        final DateFormat df = new SimpleDateFormat("dd");
        final Date date = new Date(System.currentTimeMillis());
        return df.format(date);
    }
    public static String getthismonth(){
        final DateFormat df = new SimpleDateFormat("MM");
        final Date date = new Date(System.currentTimeMillis());
        return df.format(date);
    }
    public static String getthisyear(){
        final DateFormat df = new SimpleDateFormat("yyyy");
        final Date date = new Date(System.currentTimeMillis());
        return df.format(date);
    }
}
