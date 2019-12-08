package com.example.owner_manage_java;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;

public class MyDialogFragment extends DialogFragment {
    @NonNull
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        String[] itemlist;
        itemlist = getArguments().getStringArray("temporary");
        return builder.setTitle("詳細情報").setMessage("資産コード:"+itemlist[0]+"\n"+"資産名:"+itemlist[1]+"\n"+"管理者:"+itemlist[2]+"\n"+"管理場所:"+itemlist[3]+"\n"+"個数:"+itemlist[4]+"\n"+"最終確認日:"+itemlist[5]+"\n").create();
    }
}
