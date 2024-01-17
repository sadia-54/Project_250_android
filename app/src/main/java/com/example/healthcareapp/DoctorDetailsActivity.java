package com.example.healthcareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {
    private String[][] doctorDetails1 =
            {
                    {"Doctor Name : Sabbir Ahmed", "Hospital Address : Akhalia", "Exp : 2yrs", "Mobile No : 01735682978", "600"},
                    {"Doctor Name : Raihan Chowdhury", "Hospital Address : Bonani", "Exp : 2yrs", "Mobile No : 01735682990", "900"},
                    {"Doctor Name : Priyangka Purna", "Hospital Address : Taltola", "Exp : 5yrs", "Mobile No : 01735688976", "300"},
                    {"Doctor Name : Marjana Jannat", "Hospital Address : Subidbazar", "Exp : 10yrs", "Mobile No : 01735682908", "500"},
                    {"Doctor Name : Sadia Sakhawat", "Hospital Address : Uttara", "Exp : 9yrs", "Mobile No : 01735682880", "800"}
            };

    private String[][] doctorDetails2 =
            {
                    {"Doctor Name : Sabbir Ahmed", "Hospital Address : Akhalia", "Exp : 2yrs", "Mobile No : 01735682978", "600"},
                    {"Doctor Name : Raihan Chowdhury", "Hospital Address : Bonani", "Exp : 2yrs", "Mobile No : 01735682990", "900"},
                    {"Doctor Name : Priyangka Purna", "Hospital Address : Taltola", "Exp : 5yrs", "Mobile No : 01735688976", "300"},
                    {"Doctor Name : Marjana Jannat", "Hospital Address : Subidbazar", "Exp : 10yrs", "Mobile No : 01735682908", "500"},
                    {"Doctor Name : Sadia Sakhawat", "Hospital Address : Uttara", "Exp : 9yrs", "Mobile No : 01735682880", "800"}
            };

    private String[][] doctorDetails3 =
            {
                    {"Doctor Name : Sabbir Ahmed", "Hospital Address : Akhalia", "Exp : 2yrs", "Mobile No : 01735682978", "600"},
                    {"Doctor Name : Raihan Chowdhury", "Hospital Address : Bonani", "Exp : 2yrs", "Mobile No : 01735682990", "900"},
                    {"Doctor Name : Priyangka Purna", "Hospital Address : Taltola", "Exp : 5yrs", "Mobile No : 01735688976", "300"},
                    {"Doctor Name : Marjana Jannat", "Hospital Address : Subidbazar", "Exp : 10yrs", "Mobile No : 01735682908", "500"},
                    {"Doctor Name : Sadia Sakhawat", "Hospital Address : Uttara", "Exp : 9yrs", "Mobile No : 01735682880", "800"}
            };

    private String[][] doctorDetails4 =
            {
                    {"Doctor Name : Sabbir Ahmed", "Hospital Address : Akhalia", "Exp : 2yrs", "Mobile No : 01735682978", "600"},
                    {"Doctor Name : Raihan Chowdhury", "Hospital Address : Bonani", "Exp : 2yrs", "Mobile No : 01735682990", "900"},
                    {"Doctor Name : Priyangka Purna", "Hospital Address : Taltola", "Exp : 5yrs", "Mobile No : 01735688976", "300"},
                    {"Doctor Name : Marjana Jannat", "Hospital Address : Subidbazar", "Exp : 10yrs", "Mobile No : 01735682908", "500"},
                    {"Doctor Name : Sadia Sakhawat", "Hospital Address : Uttara", "Exp : 9yrs", "Mobile No : 01735682880", "800"}
            };

    private String[][] doctorDetails5 =
            {
                    {"Doctor Name : Sabbir Ahmed", "Hospital Address : Akhalia", "Exp : 2yrs", "Mobile No : 01735682978", "600"},
                    {"Doctor Name : Raihan Chowdhury", "Hospital Address : Bonani", "Exp : 2yrs", "Mobile No : 01735682990", "900"},
                    {"Doctor Name : Priyangka Purna", "Hospital Address : Taltola", "Exp : 5yrs", "Mobile No : 01735688976", "300"},
                    {"Doctor Name : Marjana Jannat", "Hospital Address : Subidbazar", "Exp : 10yrs", "Mobile No : 01735682908", "500"},
                    {"Doctor Name : Sadia Sakhawat", "Hospital Address : Uttara", "Exp : 9yrs", "Mobile No : 01735682880", "800"}
            };

    String[][] doctorDetails = {};
    ArrayList list;
    SimpleAdapter sa;
    HashMap<String, String> item;

    TextView tv;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);
        tv = findViewById(R.id.textViewDDTitle);
        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);
        if(title.compareTo("Family Physician")==0) doctorDetails = doctorDetails1;
        else if(title.compareTo("Dietician")==0) doctorDetails = doctorDetails2;
        else if(title.compareTo("Dentist")==0) doctorDetails = doctorDetails3;
        else if(title.compareTo("Surgeon")==0) doctorDetails = doctorDetails4;
        else doctorDetails = doctorDetails5;
        btn = findViewById(R.id.buttonDDBack);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorDetailsActivity.this, FindDoctorActivity.class));
            }
        });
        list = new ArrayList();
        for(int i=0; i<doctorDetails.length; i++){
            item = new HashMap<String, String>();
            item.put("line1", doctorDetails[i][0]);
            item.put("line2", doctorDetails[i][1]);
            item.put("line3", doctorDetails[i][2]);
            item.put("line4", doctorDetails[i][3]);
            item.put("line5", "Cons Fees:"+doctorDetails[i][4]+"/-");
            list.add(item);
        }
        sa = new SimpleAdapter(this, list, R.layout.multi_lines, new String[]{"line1", "line2", "line3", "line4", "line5"},
                new int[]{R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e});

        ListView lst = findViewById(R.id.listViewDD);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(DoctorDetailsActivity.this, BookAppointmentActivity.class);
                it.putExtra("text1", title);
                it.putExtra("text2", doctorDetails[i][0]);
                it.putExtra("text3", doctorDetails[i][1]);
                it.putExtra("text4", doctorDetails[i][3]);
                it.putExtra("text5", doctorDetails[i][4]);
                startActivity(it);
            }
        });
    }
}