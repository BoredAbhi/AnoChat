package com.example.abhijeet.chatanonymus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText chat_room, name;
    private Button go;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chat_room = (EditText) findViewById(R.id.editText);
        name = (EditText) findViewById(R.id.editText2);
        go = (Button) findViewById(R.id.button);

        go.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v)
            {
                Intent i = new Intent(getApplicationContext(), Logic.class);

                i.putExtra("chat_room",chat_room.getText().toString());
                i.putExtra("name",name.getText().toString());
                startActivity(i);
            }
        });
    }
}
