package com.jrivas.keyboard_samples;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;

public class AlertDialogs extends AppCompatActivity {

    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialogs);
        mContext = this;
    }

    public void showAlert(View view){
        AlertDialog.Builder alert = new AlertDialog.Builder(mContext);
        alert.setMessage("Click OK to continue, or Cancel to stop:")
                .setCancelable(true)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
        AlertDialog alertDialog = alert.create();
        alertDialog.setTitle("Alert");
        alertDialog.show();
    }

    public void setDate(View view){

    }

    public void setTime(View view){

    }
}