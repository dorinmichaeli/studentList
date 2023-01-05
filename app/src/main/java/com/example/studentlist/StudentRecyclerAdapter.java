package com.example.studentlist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.studentlist.model.Student;

import java.util.List;

class  StudentViewHolder extends RecyclerView.ViewHolder{
    TextView name;
    TextView id;
    CheckBox cb;
    List<Student> data;

    public StudentViewHolder(@NonNull View itemView, StudentRecyclerAdapter.OnItemClickListener listener, List<Student> data) {
        super(itemView);
        this.data = data;
        name = itemView.findViewById(R.id.txtName);
        id = itemView.findViewById(R.id.txtId);
        cb = itemView.findViewById(R.id.cb);
        cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = (int)cb.getTag();
                Student s = data.get(pos);
                s.cb = cb.isChecked();
            }
        });
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = getAdapterPosition();
                listener.onItemClick(pos);
            }
        });
    }

    public void bind(Student s, int pos) {
        name.setText(s.getName());
        id.setText(s.getId());
        cb.setChecked(s.cb);
        cb.setTag(pos);
    }
}

public class StudentRecyclerAdapter  extends RecyclerView.Adapter<StudentViewHolder>{
    public static interface OnItemClickListener{
        void onItemClick(int pos);
    }

    OnItemClickListener listener;
    LayoutInflater inflater;
    List<Student> data;

    public StudentRecyclerAdapter(LayoutInflater inflater, List<Student> data){
        this.inflater = inflater;
        this.data = data;
    }


    void setListener(OnItemClickListener l){
        this.listener = l;
    }
    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.student_list_row, parent, false);
        return new StudentViewHolder(view, listener, data);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        Student s = data.get(position);
        holder.bind(s, position);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
