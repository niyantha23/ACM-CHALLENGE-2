package com.dev5151.acmchallenge2.Activities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.dev5151.acmchallenge2.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class NiyanthaView extends AppCompatActivity {

     FirebaseDatabase mFirebaseDatabase=FirebaseDatabase.getInstance();
     DatabaseReference mDatabaseReference=mFirebaseDatabase.getReference().child("STUDENT");
     ChildEventListener mChildEventListener;


    ArrayList <Student> studentDetails=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_niyantha_view);
        RecyclerView recyclerView=findViewById(R.id.recyclerview_niyantha);
        NiyanthaViewAdapter adapter=new NiyanthaViewAdapter(this, studentDetails);
        recyclerView.setAdapter(adapter);

        mChildEventListener=new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                Student student=dataSnapshot.getValue(Student.class);
                studentDetails.add(student);
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };
        mDatabaseReference.addChildEventListener(mChildEventListener);


    }


}
