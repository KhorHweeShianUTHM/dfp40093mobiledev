package com.example.labact15firebase2;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ListAdapter extends ArrayAdapter {
    private Activity mContext;
    List<Students> studentsList;

    public ListAdapter(Activity mContext, List<Students> studentsList){
        super(mContext,R.layout.activity_list_adapter,studentsList);
        this.mContext = mContext;
        this.studentsList = studentsList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = mContext.getLayoutInflater();
        View listItemView = inflater.inflate(R.layout.activity_list_adapter,null,true);
        TextView tvName = listItemView.findViewById(R.id.tvName);
        TextView tvRollno = listItemView.findViewById(R.id.tvRollno);
        TextView tvCourse = listItemView.findViewById(R.id.tvCourse);
        Students students = studentsList.get(position);

        tvName.setText(students.getName());
        tvRollno.setText(students.getRollno());
        tvCourse.setText(students.getCourse());
        return listItemView;
    }
}