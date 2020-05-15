package com.myapplicationdev.android.p04_revisionnotes;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;


import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

	ListView lv;
	ArrayAdapter aa;
	ArrayList<Note>al = new ArrayList<Note>();


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		//TODO implement the Custom ListView
		lv = findViewById(R.id.lv);


		//TODO implement the Custom ListView
		DBHelper db = new DBHelper(SecondActivity.this);
		al = db.getAllNotes();

		aa = new RevisionNotesArrayAdapter(this, R.layout.row, al);
		lv.setAdapter(aa);

	}


}
