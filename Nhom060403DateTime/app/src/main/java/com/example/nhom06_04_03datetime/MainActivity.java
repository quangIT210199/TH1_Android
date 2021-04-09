package com.example.nhom06_04_03datetime;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener {
    //Bat tu 2 skien tro len implenment

    private EditText eDate, eTime;
    private Button btDate, btTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        //lang nghe
        btDate.setOnClickListener(this);
        btTime.setOnClickListener(this);
    }

    private void initView() {
        eDate = findViewById(R.id.eDate);
        eTime = findViewById(R.id.eTime);
        btDate = findViewById(R.id.btDate);
        btTime = findViewById(R.id.btTime);

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btDate){
            //Lay date hien thoi
            Calendar cal = Calendar.getInstance();
            int y = cal.get(Calendar.YEAR);
            int m = cal.get(Calendar.MONTH);
            int day = cal.get(Calendar.DAY_OF_MONTH);

            //hien ra lich de pick
            DatePickerDialog dialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int day) {
                    //dien vao
                    eDate.setText(day +"/"+ (month+1) +"/" +year);

                }
            }, y, m,day);
            dialog.show();
        }
        if(v.getId() == R.id.btTime){
            Calendar c = Calendar.getInstance();

            int h = c.get(Calendar.HOUR);
            int m = c.get(Calendar.MINUTE);

            TimePickerDialog dialog = new TimePickerDialog(this,
                    new TimePickerDialog.OnTimeSetListener() {
                        @Override
                        public void onTimeSet(TimePicker view, int hour, int minute) {
                            eTime.setText(hour +":"+minute);
                        }
                    }, h, m, true);
            dialog.show();
        }
    }
}