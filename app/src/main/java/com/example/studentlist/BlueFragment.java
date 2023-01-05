package com.example.studentlist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.example.studentlist.model.Model;
import com.example.studentlist.model.Student;

public class BlueFragment extends AppCompatActivity {
    int pos;
    Student s;
    TextView name;
    TextView id;
    TextView phone;
    TextView address;
    CheckBox cb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_blue);

        pos = (int) getIntent().getSerializableExtra("key");
        s = Model.instance().getAllStudents().get(pos);
        name = findViewById(R.id.student_details_textView_name2);
        id = findViewById(R.id.student_details_textView_id2);
        phone = findViewById(R.id.student_details_textView_phone2);
        address = findViewById(R.id.student_details_textView_address2);
        cb = findViewById(R.id.student_details_checkBox);
        setStudentDetails();
        Button edit = findViewById(R.id.student_details_btnEdit);
//        edit.setOnClickListener(view -> {
//            Intent intent = new Intent(this, EditStudentActivity.class);
//            intent.putExtra("key",pos);
//            startActivity(intent);
//        });
    }

    public void setStudentDetails(){
        this.name.setText(this.s.getName());
        this.id.setText(this.s.getId());
//        this.phone.setText(this.s.getPhone());
//        this.address.setText(this.s.getAddress());
//        this.cb.setChecked(this.s.isCb());
    }
}