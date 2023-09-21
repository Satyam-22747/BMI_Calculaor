package com.satdroid.bmifirstandroid;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView txtres,numbmi;
        EditText edtweight, edtheightcm;
        Button btnbmi;
        LinearLayout llmain;

        edtweight= findViewById(R.id.edtweight);
        edtheightcm= findViewById(R.id.edtheightcm);
        btnbmi= findViewById(R.id.btnbmi);
        txtres= findViewById(R.id.txtresult);
        numbmi=findViewById(R.id.numbmi);
        llmain=findViewById(R.id.llmain);
        btnbmi.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
               int weight= Integer.parseInt(edtweight.getText().toString());
               int cm= Integer.parseInt(edtheightcm.getText().toString());
                double totalM=cm*cm;
                float bmi= (float) ((weight/totalM)*10000);
                if(bmi>25)
                {
                    txtres.setText("You are overweight\nYour BMI-"+bmi);
                    llmain.setBackgroundColor(getResources().getColor(R.color.colorOW));
                }
                else if(bmi<18.5){
                    txtres.setText("You are underweight\nYour BMI-"+bmi);
                    llmain.setBackgroundColor(getResources().getColor(R.color.colorUW));
                }
                else
                {
                    txtres.setText("You are Healthy\nYour BMI-"+bmi);
                    llmain.setBackgroundColor(getResources().getColor(R.color.colorHealthy));
                }



            }
        });

    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder ExitBtn=new AlertDialog.Builder(this);
        ExitBtn.setMessage("Do you want to exit");
        ExitBtn.setIcon(R.drawable.baseline_exit_to_app_24);
        ExitBtn.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                MainActivity.super.onBackPressed();
            }
        });
        ExitBtn.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
     ExitBtn.show();
    }
}