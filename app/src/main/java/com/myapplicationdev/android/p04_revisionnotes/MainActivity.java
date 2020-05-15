package com.myapplicationdev.android.p04_revisionnotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etTextNote;
    RadioGroup rg;
    Button btninsert;
    Button btnshowlist;
    RadioButton rb;
    ArrayAdapter aa;
    ArrayList<Note> al;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etTextNote = (EditText) findViewById(R.id.editTextNote);
        rg = (RadioGroup) findViewById(R.id.radioGroupStars);
        btninsert = (Button) findViewById(R.id.buttonInsertNote);
        btnshowlist = (Button) findViewById(R.id.buttonShowList);

        al = new ArrayList<Note>();

        btninsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DBHelper db = new DBHelper(MainActivity.this);
                String textInput = etTextNote.getText().toString();
                int selectedButtonId = rg.getCheckedRadioButtonId();
                // Get the radio button object from the Id we had gotten above
                RadioButton rb = (RadioButton) findViewById(selectedButtonId);
                int stars = Integer.parseInt(rb.getText().toString());
                db.insertNote(textInput, stars);
                Toast.makeText(MainActivity.this, "Insert!",
                        Toast.LENGTH_LONG).show();
                db.close();
            }
        });

        btnshowlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);


            }
        });


    }
}
