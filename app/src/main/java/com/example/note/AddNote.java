package com.example.note;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import io.realm.annotations.PrimaryKey;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import io.realm.Realm;

import io.realm.annotations.PrimaryKey;
public class AddNote extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        EditText titleinput= findViewById(R.id.titleinput);
        EditText descriptioninput = findViewById(R.id.descriptioninput);
        MaterialButton savebtn=findViewById(R.id.savebtn);

        Realm.init(getApplicationContext());
        Realm realm=Realm.getDefaultInstance();
        savebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title=titleinput.getText().toString();
                String description=descriptioninput.getText().toString();
                Long createdTime=System.currentTimeMillis();

                // *----------to save in the database-------*

                realm.beginTransaction();
               Note note = realm.createObject(Note.class);
               note.setTitle(title);
               note.setDescription(description);
               note.setCreatedTIme(createdTime);
               realm.commitTransaction();
                Toast.makeText(getApplication(), "Note Saved", Toast.LENGTH_SHORT).show();


            }
        });
    }
}