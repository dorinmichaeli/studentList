package com.example.studentlist;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.MenuProvider;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class AddStudentFragment extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FragmentActivity parentActivity = getActivity();
        parentActivity.addMenuProvider(new MenuProvider() {
            @Override
            public void onCreateMenu(@NonNull Menu menu, @NonNull MenuInflater menuInflater) {
                menu.removeItem(R.id.addStudentFragment);
            }

            @Override
            public boolean onMenuItemSelected(@NonNull MenuItem menuItem) {
                return false;
            }
        }, this, Lifecycle.State.RESUMED);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_student, container, false);

        ImageView img = view.findViewById(R.id.add_student_img);
        EditText nameET = view.findViewById(R.id.add_student_editText_name);
        EditText idET = view.findViewById(R.id.add_student_editText_id);
        EditText phoneET = view.findViewById(R.id.add_student_editText_phone);
        EditText addressET = view.findViewById(R.id.add_student_editText_address);
        CheckBox checkCB = view.findViewById(R.id.add_student_checkBox);
        Button save = view.findViewById(R.id.add_student_btnSave);
        Button cancel = view.findViewById(R.id.add_student_btnCancel);
        TextView messageTV = view.findViewById(R.id.addstudent_textView_message);

        save.setOnClickListener(view1 -> {
            String name = nameET.getText().toString();
            messageTV.setText(name + " saved!");
        });

        cancel.setOnClickListener(view1 -> Navigation.findNavController(view1).popBackStack(R.id.studentsListFragment, false));
        return view;
    }


}