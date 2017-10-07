package com.example.swetasamaddar.dietconsultant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LoginScreen extends AppCompatActivity {

    private Button save;
    private EditText name,weight,height,lbp,ubp,age;
    private RadioButton male,female;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        name=(EditText)findViewById(R.id.name);
        age=(EditText)findViewById(R.id.age);
        weight=(EditText)findViewById(R.id.weight);
        height=(EditText)findViewById(R.id.height);
        lbp=(EditText)findViewById(R.id.lbp);
        ubp=(EditText)findViewById(R.id.ubp);
        male=(RadioButton)findViewById(R.id.male);
        female=(RadioButton)findViewById(R.id.female);

        save=(Button)findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(name.getText()==null||age.getText()==null||height.getText()==null||weight.getText()==null||lbp.getText()==null||ubp.getText()==null||(male.isChecked()==false&&female.isChecked()==false))
                    Toast.makeText(getApplicationContext(),"Please fill all the feilds...",Toast.LENGTH_SHORT).show();
                else {
                    String uname = name.getText().toString();
                    int uage = Integer.parseInt(age.getText().toString());
                    int uweight = Integer.parseInt(weight.getText().toString());
                    int uheight = Integer.parseInt(height.getText().toString());

                    String sex = (male.isChecked()) ? "male" : "female";
                    int ulbp = Integer.parseInt(lbp.getText().toString());
                    int uubp = Integer.parseInt(ubp.getText().toString());
                    double bmi=(double)uweight/((uheight/100)*(uheight/100));
                    mDatabase.child("users").child("Userdetails").child("username").setValue(uname);
                    mDatabase.child("users").child("Userdetails").child("userage").setValue(uage);
                    mDatabase.child("users").child("Userdetails").child("usersex").setValue(sex);
                    mDatabase.child("users").child("Userdetails").child("userweight").setValue(uweight);
                    mDatabase.child("users").child("Userdetails").child("userheight").setValue(uheight);
                    mDatabase.child("users").child("Userdetails").child("userbmi").setValue(bmi);
                    mDatabase.child("users").child("Userdetails").child("userbp").child("lbp").setValue(ulbp);
                    mDatabase.child("users").child("Userdetails").child("userbp").child("ubp").setValue(uubp);

                    Toast.makeText(getApplicationContext(),"Details Recorded!\nThank You",Toast.LENGTH_SHORT).show();
                    Intent i=new Intent(getBaseContext(),MedicalDetails.class);
                    startActivity(i);
                    finish();
                }

            }
        });




    }
}
