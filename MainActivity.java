package com.example.sounak.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et_name;
    Button but_submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form);

        et_name = (EditText) findViewById(R.id.editText);
        but_submit = (Button) findViewById(R.id.button);

        but_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=et_name.getText().toString();
                if (name=="" || name.trim().length()==0||name==null)
                {
                    Toast.makeText(getApplicationContext(), "Kindly enter your name", Toast.LENGTH_LONG).show();
                }
                else
                {
                    try
                    {
                        Bundle b=new Bundle();
                        b.putString("name", name);
                        String pack=getPackageName() + ".Main2Activity";
                        Class cls=Class.forName(pack);
                        Intent intent=new Intent(MainActivity.this, cls);
                        intent.putExtras(b);
                        startActivity(intent);
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    }
                }
            });
        }
    }
