package com.example.owner_manage_java;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;

import es.dmoral.toasty.Toasty;
public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };
    final MyDialogFragment_filecheck dialogFragment = new MyDialogFragment_filecheck();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int permission = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (permission != PackageManager.PERMISSION_GRANTED) {
            // We don't have permission so prompt the user
            ActivityCompat.requestPermissions(
                    this,
                    PERMISSIONS_STORAGE,
                    REQUEST_EXTERNAL_STORAGE
            );
        }
        Button CheckButton = findViewById(R.id.checkbutton);
        Button ViewButton = findViewById(R.id.viewbutton);
        String filepath = Environment.getExternalStorageDirectory().getPath()+"/data1.csv";
        final File file = new File(filepath);
        if(!file.exists()){
            dialogFragment.show(getSupportFragmentManager(),"dialog_basic");
        }
        //画面遷移
        CheckButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getApplication(), SubActivity_check.class);
                startActivity(intent);
            }
        });

        ViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getApplication(),SubActivity_view.class);
                startActivity(intent2);
            }
        });

        //画面遷移終了
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.option_menu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        String filepath = Environment.getExternalStorageDirectory().getPath()+"/data1.csv";
        final File file = new File(filepath);
        switch (item.getItemId()) {
            case R.id.filecheck:
                if (file.exists()) {
                    Toasty.success(MainActivity.this,
                            String.format("ファイルの存在を確認しました"),
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toasty.error(MainActivity.this,
                            String.format("ファイルが存在しません"),
                            Toast.LENGTH_SHORT).show();
                }
                break;
        }
        return true;
    }
}
