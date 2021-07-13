package com.prabhakar.recyclerviewiii_we;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class EmployeeViewHolder extends RecyclerView.ViewHolder {
    private ClickedListener clickedListener;
    private TextView name;
    private TextView age;
    private TextView address;
    private ImageView edit_img;

    public EmployeeViewHolder(@NonNull View itemView, ClickedListener clickedListener) {
        super(itemView);
        this.clickedListener = clickedListener;
        initData(itemView);
    }

    private void initData(View itemView) {
        name = itemView.findViewById(R.id.name);
        age = itemView.findViewById(R.id.salary);
        address = itemView.findViewById(R.id.age);
        edit_img = itemView.findViewById(R.id.edit_btn);

    }

    public void setData(Employee employee) {
        name.setText(employee.getName()+"");
        address.setText(employee.getAge());
        age.setText(employee.getSalary());
        edit_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickedListener.onItemClicked(employee, getAdapterPosition());
            }
        });
    }
}
