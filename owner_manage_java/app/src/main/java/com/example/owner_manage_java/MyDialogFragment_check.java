package com.example.owner_manage_java;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.widget.Toast;

import es.dmoral.toasty.Toasty;

import static com.example.owner_manage_java.CsvReader.arraylist_all;
import static com.example.owner_manage_java.CsvReader_editsearch.arraylist_edit;

import static com.example.owner_manage_java.SubActivity_check.gettime;

public class MyDialogFragment_check extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        final String[] itemlist = getArguments().getStringArray("temporary");
        final int place = getArguments().getInt("place");
        final int num=getArguments().getInt("num");
        System.out.println(place);
        switch (num) {
            case 0:
            return builder.setTitle("詳細情報")
                    .setMessage("資産コード:" + itemlist[0] + "\n" + "資産名:" + itemlist[1] + "\n" + "管理者:" + itemlist[2] + "\n" + "管理場所:" + itemlist[3] + "\n" + "個数:" + itemlist[4] + "\n" + "最終確認日:" + itemlist[5] + "\n")
                    .setPositiveButton("確認", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            Toasty.success(getActivity(), "チェックされました", Toast.LENGTH_SHORT).show();
                            arraylist_all.get(place).set(5, gettime());
                            CsvWriter.writer(arraylist_all);
                            arraylist_all.clear();
                        }
                    }).setNegativeButton("中断", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toasty.info(getActivity(), "中断しました", Toast.LENGTH_SHORT).show();
                        }
                    }).create();

            case 1:
                return builder.setTitle("詳細情報")
                        .setMessage("資産コード:" + itemlist[0] + "\n" + "資産名:" + itemlist[1] + "\n" + "管理者:" + itemlist[2] + "\n" + "管理場所:" + itemlist[3] + "\n" + "個数:" + itemlist[4] + "\n" + "最終確認日:" + itemlist[5] + "\n")
                        .setPositiveButton("確認", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Toasty.success(getActivity(), "チェックされました", Toast.LENGTH_SHORT).show();
                                arraylist_edit.get(place).set(5, gettime());
                                itemlist[5]=arraylist_edit.get(place).get(5);
                                CsvWriter.part_write(itemlist,arraylist_all);
                                arraylist_edit.clear();
                            }
                        }).setNegativeButton("中断", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toasty.info(getActivity(), "中断しました", Toast.LENGTH_SHORT).show();
                            }
                        }).create();

        }
        return builder.setTitle("詳細情報")
                .setMessage("資産コード:" + itemlist[0] + "\n" + "資産名:" + itemlist[1] + "\n" + "管理者:" + itemlist[2] + "\n" + "管理場所:" + itemlist[3] + "\n" + "個数:" + itemlist[4] + "\n" + "最終確認日:" + itemlist[5] + "\n")
                .setPositiveButton("確認", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toasty.success(getActivity(), "チェックされました", Toast.LENGTH_SHORT).show();
                        arraylist_edit.get(place).set(5, gettime());
                        CsvWriter.writer(arraylist_all);
                        arraylist_edit.clear();
                    }
                }).setNegativeButton("中断", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toasty.info(getActivity(), "中断しました", Toast.LENGTH_SHORT).show();
                    }
                }).create();
    }
}
