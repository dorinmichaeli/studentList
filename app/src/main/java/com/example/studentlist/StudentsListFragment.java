package com.example.studentlist;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.studentlist.model.Model;
import com.example.studentlist.model.Student;

import java.util.List;

public class StudentsListFragment extends Fragment {

    List<Student> data;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_students_list_, container, false);
        data = Model.instance().getAllStudents();
        RecyclerView rl = view.findViewById(R.id.studentsListFrag_list);
        rl.setHasFixedSize(true);

        rl.setLayoutManager(new LinearLayoutManager(getContext()));
        StudentRecyclerAdapter adapter = new StudentRecyclerAdapter(getLayoutInflater(), data);
        rl.setAdapter(adapter);

        adapter.setListener(new StudentRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int pos) {
                Log.d("TAG", "row click " + pos);
                Student s = data.get(pos);
                StudentsListFragmentDirections.ActionStudentsListFragmentToBlueFragment action = StudentsListFragmentDirections.actionStudentsListFragmentToBlueFragment(s.getName());
                Navigation.findNavController(view).navigate(action);
            }
        });
        View addButton = view.findViewById(R.id.sudentlist_add_btn);
        NavDirections action = StudentsListFragmentDirections.actionGlobalAddStudentFragment();
        addButton.setOnClickListener(Navigation.createNavigateOnClickListener(action));
        return  view;
    }
}