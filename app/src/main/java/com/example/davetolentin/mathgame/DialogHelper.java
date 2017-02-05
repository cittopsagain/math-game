package com.example.davetolentin.mathgame;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

/**
 * Created by Dave Tolentin on 2/5/2017.
 */

public class DialogHelper {

    private static Context context;

    public DialogHelper(Context context) {
        this.context = context;
    }

    public interface AlertDialogListener<T> {
        void onSuccess(int t);
    }

    public static void showDialog(String title, String posBtnTxt, String negBtnTxt, String msg,
                                  boolean isCancelable,
                                  final AlertDialogListener<Integer> listener) {
        new AlertDialog.Builder(context).setTitle(title).setMessage(msg).
                setCancelable(isCancelable)
                .setPositiveButton(posBtnTxt, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        listener.onSuccess(1);
                    }
                }).setNegativeButton(negBtnTxt, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                listener.onSuccess(-1);
            }
        }).show();
    }
}