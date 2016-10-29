package com.example.abhijeet.chatanonymus;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class Logic extends AppCompatActivity {

    private Firebase mRef;
    private TextView textview;
    private EditText editText4;
    private Button button3;
    private String name, chat_room;
    public String net_chat_text="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logic);

        textview = (TextView) findViewById(R.id.textView);
        editText4 = (EditText) findViewById(R.id.editText4);
        button3 = (Button) findViewById(R.id.button3);

        textview.setMovementMethod(new ScrollingMovementMethod());

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            chat_room = extras.getString("chat_room").toString().trim();
            name = extras.getString("name").toString().trim();
            //The key argument here must match that used in the other activity
        }

        mRef = new Firebase("https://chatanonymus.firebaseio.com/"+chat_room);
        //textview.setText("result:\n\n"+chat_room+"\n\n"+name);

        button3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                net_chat_text = textview.getText().toString();
                String chat_text = editText4.getText().toString();
                editText4.setText("");
                Firebase chat = mRef.child("Chat");
                chat.setValue(name+" : "+chat_text);
            }
        });

        mRef.child("Chat").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                String value = dataSnapshot.getValue(String.class);
                textview.setText(net_chat_text+"\n"+value+"\n");
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }

}
