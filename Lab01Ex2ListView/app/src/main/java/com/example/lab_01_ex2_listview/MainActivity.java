package com.example.lab_01_ex2_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Spinner;

import com.example.lab_01_ex2_listview.model.Student;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
//DataSource(ArrayList,Cusor) <--> Apdapter <---> Adapter View(ListView, GridView,Spinner ..)
public class MainActivity extends AppCompatActivity {

    Button addBtn;
    Spinner spinner;
    EditText id, nameHS, dateNgay;
    RadioButton rd1, rd2;
    String rd;
    //Adapter View
    ListView listView;

    private ListViewAdapter adapter;

    private List<Student> listSt = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Khai bao
        listView = findViewById(R.id.list_view);
        addBtn = findViewById(R.id.addBtn);
        id = findViewById(R.id.id_hs);
        nameHS = findViewById(R.id.ten_hs);
//        gender = findViewById(R.id.gtinh);
        dateNgay = findViewById(R.id.ngay);

        rd1 = findViewById(R.id.man);
        rd2 = findViewById(R.id.woman);
        //
        adapter = new ListViewAdapter(this, listSt);
        listView.setAdapter(adapter);

        Calendar c = Calendar.getInstance();
        //Lam Datepicker
        int day = c.get(Calendar.DAY_OF_MONTH);
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);

        dateNgay.setOnClickListener( v-> {
            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int day) {
                    dateNgay.setText(day +"/"+ (month+1) +"/" +year);
                }
            }, year, month, day);
            datePickerDialog.show();
        });
        // Lam spinner
        spinner = findViewById(R.id.sp);
        List<Integer> listImg = new ArrayList<>();
        listImg.add(R.drawable.facebook_logo_png_9024);
        listImg.add(R.drawable.google_logo_png_29546);
        listImg.add(R.drawable.iphone_12_red);
        listImg.add(R.drawable.telegram_logo);

        ArrayAdapter arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, listImg);
        spinner.setAdapter(arrayAdapter);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Khi add san pham
        addBtn.setOnClickListener( v -> {
            int resImg = (int) spinner.getSelectedItem();
            String idST = String.valueOf(id.getText());
            String nameST = String.valueOf(nameHS.getText());
            String gioi = null;
            if(rd1.isChecked())
            {
                gioi = rd1.getText().toString();
            }
            else
            {
                gioi = rd2.getText().toString();
            }

            String dateHe = String.valueOf(dateNgay.getText());

            Student st = new Student(idST,nameST,gioi, dateHe, resImg );

            listSt.add(st);
            adapter.notifyDataSetChanged();
        });
    }

    public void onRadio(View v){
        boolean isCheck = ((RadioButton)v).isChecked();

        if(isCheck){
            rd =((RadioButton) v).getText().toString();
        }
    }
}