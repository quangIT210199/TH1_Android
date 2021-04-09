package com.example.lab_01_ex2_listview;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.lab_01_ex2_listview.model.Student;

import java.util.List;

public class ListViewAdapter extends ArrayAdapter<Student> {

    private List<Student> list;

    private Activity activity;

    public ListViewAdapter(@NonNull Context context,List<Student> list) {
        super(context, R.layout.list_item, list);
        this.activity = (Activity) context;
        this.list = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //Lấy các field cần
        LayoutInflater layoutInflater = activity.getLayoutInflater();

        View v = layoutInflater.inflate(R.layout.list_item,  parent, false);

        ImageView img = v.findViewById(R.id.img);
        TextView id = v.findViewById(R.id.id_st);
        TextView name = v.findViewById(R.id.name);
        TextView gender = v.findViewById(R.id.gender);
        TextView date = v.findViewById(R.id.date);

        Button btn = v.findViewById(R.id.delete);

        Student student = list.get(position);

        btn.setOnClickListener(
                v1 -> {
                    list.remove(position);
                    notifyDataSetChanged();
                }
        );

        img.setImageResource(student.getImg());
        id.setText(student.getId());
        name.setText(student.getName());
        gender.setText(student.getGender());
        date.setText(student.getDate());
        return v;
    }
}
