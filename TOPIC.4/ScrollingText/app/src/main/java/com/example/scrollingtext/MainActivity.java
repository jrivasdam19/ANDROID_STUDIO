package com.example.scrollingtext;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void onClick(View v) {
        Button button=findViewById(R.id.comment_button);
        EditText article=findViewById(R.id.article);
        if (button.getText().equals("Add Comment")){
            button.setText("Save Comment");
            article.setEnabled(true);
            article.append("\n");
        } else {
            button.setText("Add Comment");
            article.setText(article.getText() + "\n");
            article.setEnabled(false);
        }
    }
}