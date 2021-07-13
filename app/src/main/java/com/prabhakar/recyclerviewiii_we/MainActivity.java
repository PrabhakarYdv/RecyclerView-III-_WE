package com.prabhakar.recyclerviewiii_we;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ClickedListener {
    private ArrayList<Employee> employeeList ;
    private RecyclerView recyclerView;
    private CardView cardView;
    private ClickedListener clickedListener;
    private TextView name;
    private TextView age;
    private TextView address;
    private Button done_btn;
    EmployeeAdapter employeeAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        buildList();
        setRecyclerView();
    }

    private void initView() {
        recyclerView = findViewById(R.id.recyclerView);
        cardView = findViewById(R.id.editCardView);
        name = findViewById(R.id.edit_name);
        age = findViewById(R.id.edit_salary);
        address = findViewById(R.id.edit_age);
        done_btn = findViewById(R.id.btnDone);

    }

    private void setRecyclerView() {
        employeeAdapter = new EmployeeAdapter(employeeList, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(employeeAdapter);
    }

    private void buildList() {
        employeeList=new ArrayList<>();
        for (int i = 1; i <=5; i++) {
            employeeList.add(new Employee("Lloyd ","1000000","28"));
        }
    }

    @Override
    public void onItemClicked(Employee employee, int position) {
        cardView.setVisibility(View.VISIBLE);
        name.setText(employee.getName());
        age.setText(employee.getSalary());
        address.setText(employee.getAge());

        done_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Employee newEmployee = new Employee(name.getText().toString(), age.getText().toString(), address.getText().toString());
                cardView.setVisibility(View.GONE);
                employeeList.set(position, newEmployee);
                employeeAdapter.notifyItemChanged(position);
            }
        });
    }
}