package com.example.plannerify;

import android.app.Notification;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Chat_OrgClt extends AppCompatActivity {

    Notification.MessagingStyle.Message obMessage;
  EditText mRecipientEt,mSubjectEt,mMessageEt;
  Button mSendEmailBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat__org_clt);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();

        // me
        mRecipientEt=findViewById(R.id.emailR);
        mSubjectEt=findViewById(R.id.objet);
        mMessageEt=findViewById(R.id.messageEmail);
        mSendEmailBtn=findViewById(R.id.sendMail);
       mSendEmailBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String recipent=mRecipientEt.getText().toString();
               String subject=mSubjectEt.getText().toString();
               String message=mMessageEt.getText().toString();
               sendMail(recipent,subject,message);
           }
       });


    }

    private void sendMail(String recipent,String subject,String message){
        Intent mEmailIntent=new Intent(Intent.ACTION_VIEW,Uri.parse("mailto:"+recipent));
        mEmailIntent.setData(Uri.parse("mailto:"+recipent));
       // mEmailIntent.setType("text/plain");
        mEmailIntent.putExtra(Intent.EXTRA_SUBJECT,subject);
        mEmailIntent.putExtra(Intent.EXTRA_TEXT,message);
        startActivity(mEmailIntent);
        try{

        }
        catch (Exception e){
            Toast.makeText(this,e.getMessage(),Toast.LENGTH_LONG).show();
        }

    }
}