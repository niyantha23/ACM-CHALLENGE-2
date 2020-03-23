package com.dev5151.acmchallenge2.Activities;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.dev5151.acmchallenge2.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class NiyanthaActivity extends AppCompatActivity {
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mDatabaseReference;
    private EditText mRegNo;
    private EditText mName;
    private EditText mAge;
    private EditText mCity;
    private FloatingActionButton sendButton;
    private EditText mPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_niyantha);



        initializeView();
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        mFirebaseDatabase =FirebaseDatabase.getInstance();
        mDatabaseReference = mFirebaseDatabase.getReference().child("STUDENT");


        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnHitSend();



            }
        });



    }
    public void initializeView(){

        mRegNo =findViewById(R.id.reg_no_edit_text);
        mName =findViewById(R.id.name_edit_text);
        mAge =findViewById(R.id.age_edit_text);
        mCity =findViewById(R.id.city_edit_text);
        sendButton=findViewById(R.id.send_button);
        mPhone=findViewById(R.id.phone_edit_text);
    }
    public void PushToFirebase(){

        Student student= new Student(mRegNo.getText().toString(),
                mName.getText().toString(),
                mAge.getText().toString(),
                mCity.getText().toString(),mPhone.getText().toString());
        mDatabaseReference.push().setValue(student);
        ClearEditText();
        }

    public void OnHitSend()
    {
        if (TextUtils.isEmpty(mRegNo.getText())) {
            mRegNo.setError("Reg n.o is required!");
        } else if (TextUtils.isEmpty(mName.getText())) {
            mName.setError("Name is required");
        } else if (TextUtils.isEmpty(mAge.getText())) {
            mAge.setError("Age is required!");
        } else if (TextUtils.isEmpty(mCity.getText())) {
            mCity.setError("City is required!");
        } else  if (TextUtils.isEmpty(mPhone.getText())) {
            mPhone.setError("Phone n.o is required!");}
        else {
            PushToFirebase();
            Intent viewIntent = new Intent(NiyanthaActivity.this, NiyanthaView.class);
            startActivity(viewIntent);
        }
    }
    public void ClearEditText(){
        mRegNo.getText().clear();
        mName.getText().clear();
        mAge.getText().clear();
        mPhone.getText().clear();
        mCity.getText().clear();}
}
