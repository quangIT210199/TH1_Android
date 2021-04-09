package com.example.baith1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
    implements View.OnClickListener {

    private EditText e1, e2, e3;
    private Button btAdd;
    private TextView result;
    private RadioGroup rd;
    private RadioButton b1, b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
//        btAdd.setOnClickListener(this::onClick);

        btAdd.setOnClickListener(v->{
            double a, b, c;
            String choice = null;
            if(b1.isChecked()){
                choice = b1.getText().toString();
            }else {
                choice = b2.getText().toString();
            }
            try {
                a = Double.parseDouble(e1.getText().toString());
                b = Double.parseDouble(e2.getText().toString());
                c = Double.parseDouble(e3.getText().toString());
                //Tính toán
                result.setText(cal(a, b, c, choice));
            }catch (NumberFormatException e){
                System.out.println(e);
            }
        });
    }


    private void initView(){
        e1 = findViewById(R.id.e1);
        e2 = findViewById(R.id.e2);
        e3 = findViewById(R.id.e3);
        btAdd = findViewById(R.id.btAdd);
        rd = findViewById(R.id.rd);
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        result = findViewById(R.id.result);
    }

    private String cal(double a, double b, double c, String choice){
        String kq ="";
        switch (choice){
            case "Diện tích": kq += "Diện tích: " + (2 * (a*b + a*c + b *c));
                break;
            case "Thể tích":  kq += "Thể tích: " + (a*b*c);
                break;
        }

        return kq;
    }

    @Override
    public void onClick(View v) {
        if(v == btAdd){
            double a, b, c;

                if(rd.getCheckedRadioButtonId() == - 1){
                    result.setText("Chọn phép tính");
                }
                else{
                    int selectedId = rd.getCheckedRadioButtonId();
                    RadioButton rb = (RadioButton)findViewById(selectedId);
                    String choice = rb.getText().toString();
                    try {
                    a = Double.parseDouble(e1.getText().toString());
                    b = Double.parseDouble(e2.getText().toString());
                    c = Double.parseDouble(e3.getText().toString());
                    //Tính toán
                    result.setText(cal(a, b, c, choice));
                    }catch (NumberFormatException e){
                        System.out.println(e);
                    }
                }
        }
    }
}