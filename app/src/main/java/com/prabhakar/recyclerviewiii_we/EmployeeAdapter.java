package com.prabhakar.recyclerviewiii_we;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeViewHolder> {
    private ArrayList<Employee> employeeList;
    private  ClickedListener clickedListener;

    public EmployeeAdapter(ArrayList<Employee> employeeList, ClickedListener clickedListener) {
        this.employeeList = employeeList;
        this.clickedListener = clickedListener;
    }

    @NonNull
    @Override
    public EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new EmployeeViewHolder(view,clickedListener);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeViewHolder holder, int position) {
        Employee employee = employeeList.get(position);
        holder.setData(employee);
    }

    @Override
    public int getItemCount() {
        return employeeList.size();
    }
}
