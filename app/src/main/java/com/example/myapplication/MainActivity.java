package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    ToggleButton toggleButton;
    CheckBox ch1, ch2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toggleButton = findViewById(R.id.toggle1);
        ch1 = findViewById(R.id.check1);
        ch2 = findViewById(R.id.check2);

        ch1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Anda memilih English", Toast.LENGTH_SHORT).show();
            }
        });

        ch2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Anda memilih Bahasa", Toast.LENGTH_SHORT).show();
            }
        });

        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(toggleButton.isChecked()){
                    Toast.makeText(MainActivity.this, "tombol turn on", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "tombol turn off", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void openAlert(View view) {
        AlertDialog.Builder myAlert = new AlertDialog.Builder(this);
        myAlert.setTitle("Exit");
        myAlert.setMessage("Serius nih??");
        myAlert.setPositiveButton("Iek", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        myAlert.setNegativeButton("Ndaji", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                dialog.dismiss();
            }
        });

        myAlert.setCancelable(false);
        myAlert.show();
    }

    public void openProgress(View view) {
        ProgressDialog pd = new ProgressDialog(this);
        pd.setTitle("Downloading");
        pd.setMessage("Mohon tunggu");
        pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        pd.setButton(ProgressDialog.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        pd.show();
    }
}
