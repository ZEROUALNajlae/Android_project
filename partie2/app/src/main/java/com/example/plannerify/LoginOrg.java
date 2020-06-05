package com.example.plannerify;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public class LoginOrg extends AppCompatActivity {
    Button mLogin;
    TextView mRegister;
    EditText mEmail,mPassword;
    MediaPlayer PassIncorrect;
    FirebaseAuth auth= FirebaseAuth.getInstance();
    private DatabaseReference mUserDatabase;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_org);
        mLogin=findViewById(R.id.login);
        mEmail=findViewById(R.id.email);


        mPassword=findViewById(R.id.password);
        mRegister=findViewById(R.id.Register);
        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent=new Intent(LoginOrg.this,RegisterOrg.class);
                startActivity(registerIntent);
            }
        });
        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String text_mail=mEmail.getText().toString();
                String text_password=mPassword.getText().toString();
                if(TextUtils.isEmpty(text_password) || TextUtils.isEmpty(text_mail))
                    Toast.makeText(LoginOrg.this,"all fileds are required",Toast.LENGTH_SHORT).show();
                else{
                    auth.signInWithEmailAndPassword(text_mail,text_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                               /* Intent intentOrg=new Intent(LoginOrg.this,ProfilOrg.class);
                                startActivity(intentOrg);
                                finish();*/
                                setContentView(R.layout.activity_profil_org);
                            }
                            else{
                                PassIncorrect=MediaPlayer.create(LoginOrg.this,R.raw.password_incorrect);
                                PassIncorrect.start();
                                Toast.makeText(LoginOrg.this,"Authentification failed! try again",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                }
            }
        });



    }
}