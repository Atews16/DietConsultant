package com.example.swetasamaddar.dietconsultant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MedicalDetails extends AppCompatActivity {
Button proceed;
    CheckBox addiction,smoke,drink,drug;
    private DatabaseReference mDatabase;
    RadioButton sedentry,active,moderate;
    EditText sugar,cholestrol;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical_details);
      //  mDatabase = FirebaseDatabase.getInstance().getReference().child("Users");

        addiction=(CheckBox)findViewById(R.id.addiction);
        smoke=(CheckBox)findViewById(R.id.smoke);
        drink=(CheckBox)findViewById(R.id.drink);
        drug=(CheckBox)findViewById(R.id.drug);
        sedentry=(RadioButton)findViewById(R.id.sedentry);
        moderate=(RadioButton) findViewById(R.id.mod_act);
        active=(RadioButton)findViewById(R.id.high_act);
        smoke.setVisibility(View.GONE);
        drink.setVisibility(View.GONE);
        drug.setVisibility(View.GONE);
        if (addiction.isChecked())
        {
            smoke.setVisibility(View.VISIBLE);
            drink.setVisibility(View.VISIBLE);
            drug.setVisibility(View.VISIBLE);
        }

        proceed=(Button)findViewById(R.id.proceed);
        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(getApplicationContext(),dietPlan.class);
                startActivity(i);
            }
        });
    }
}
