package com.example.chatapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity {

    private Button signOutBtn;
    private FirebaseAuth mAuth;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        signOutBtn=findViewById(R.id.signout_btn);
        mAuth=FirebaseAuth.getInstance();
        button= findViewById(R.id.startbtn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openExpenseManager();

            }
        });

        signOutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
                startActivity(new Intent(HomeActivity.this,SignInActivity.class ));
                finish();

            }
        });


    }
    public void openExpenseManager(){
        Intent intent= new Intent(this,ExpenseManager.class);
        startActivity(intent);



    }
}