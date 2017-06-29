package com.example.thiagop.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import android.os.Bundle;
import android.os.Environment;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends AppCompatActivity {

    Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText cnpj = (EditText)findViewById(R.id.cnpj);
        cnpj.addTextChangedListener(Mask.insert(Mask.CNPJ_MASK, cnpj));

        EditText cpf = (EditText)findViewById(R.id.cpf);
        cpf.addTextChangedListener(Mask.insert(Mask.CPF_MASK, cpf));

        EditText telefone = (EditText)findViewById(R.id.telefone);
        telefone.addTextChangedListener(Mask.insert(Mask.CELULAR_MASK, telefone));

        EditText cep = (EditText)findViewById(R.id.cep);
        cep.addTextChangedListener(Mask.insert(Mask.CEP_MASK, cep));

        EditText preco = (EditText)findViewById(R.id.preco);
        preco.addTextChangedListener(MonetaryMask.monetario(preco));



        send = (Button) findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub
                new Thread(new Runnable() {
                    @SuppressLint("SdCardPath") public void run() {
                        try {
                            GMailSender sender = new GMailSender("thisk8brd@gmail.com","3kmckdt4");
                            ///Toast.makeText(getApplicationContext(), "Connect", Toast.LENGTH_LONG).show();
                            //sender.addAttachment(filename);
                            sender.addAttachment(Environment.getExternalStorageDirectory().getPath()+"/sdcard/mysdfile.txt");
                            sender.sendMail("Test mail", "This mail has been sent from android app along with attachment","thisk8brd@gmail.com",
                                    "thiagodelimapacheco@gmail.com");

                            Log.i("Mail", "Sent");
                            //Toast.makeText(getApplicationContext(),"Your mail has been sent",Toast.LENGTH_LONG).show();


                        } catch (Exception e) {
                            runOnUiThread(new Runnable()
                            {
                                public void run()
                                {
                                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                                }
                            });

                            Log.i("Mail", "Failed"+e);
                            //Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG).show();

                        }
                    }
                }).start();

                send.setText("Ok");
            }
        });


    }

    public void sendEmail(String fromEmail, String fromPassword, String toEmails, String emailSubject, String adminSubject, String emailBody, String adminBody){

        //GMAIL TEST
        //String fromEmail = "sample@gmail.com";
        //String fromPassword = "xxxxxx";
        //String toEmails = "to_sample@gmail.com";
        //String adminEmail = "admin@gmail.com";
        //String emailSubject = "App Registration Mail";
        //String adminSubject = "App Registration Mail";
        //String emailBody = "Your message";
        //String adminBody = "Your message";
        //new SendMailTask(MainActivity.this).execute(fromEmail,
                //fromPassword, toEmails, emailSubject, emailBody);



    }



}
