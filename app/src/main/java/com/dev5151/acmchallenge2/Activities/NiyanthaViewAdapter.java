package com.dev5151.acmchallenge2.Activities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dev5151.acmchallenge2.R;

import java.util.ArrayList;

public class NiyanthaViewAdapter extends RecyclerView.Adapter <NiyanthaViewAdapter.viewHolder> {
    private ArrayList<Student> students;

    private Context context;
    public NiyanthaViewAdapter(Context context, ArrayList<Student> List) {
        this.context = context;
        this.students= List;
    }
    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_details,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        holder.regNo.setText(students.get(position).getRegNo());
        holder.name.setText(students.get(position).getName());
        holder.age.setText(students.get(position).getAge());
        holder.city.setText(students.get(position).getCity());
        holder.phone.setText(students.get(position).getPhone());

    }



    @Override
    public int getItemCount() {
        return students.size();
    }
    public class viewHolder extends RecyclerView.ViewHolder {
        private TextView regNo,name,age,city,phone;
        public viewHolder(@NonNull View itemView) {
            super(itemView);


            regNo=itemView.findViewById(R.id.reg_no_text);
            name=itemView.findViewById(R.id.name_text);
            age=itemView.findViewById(R.id.age_text);
            city=itemView.findViewById(R.id.city_text);
            phone=itemView.findViewById(R.id.phone_no_text);


        }
    }

}
