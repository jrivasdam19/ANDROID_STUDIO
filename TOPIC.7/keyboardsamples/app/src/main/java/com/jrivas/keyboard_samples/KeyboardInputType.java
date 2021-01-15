package com.jrivas.keyboard_samples;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class KeyboardInputType extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
//hola
    Spinner mSpinner;
    EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keyboard_input_type);

        mSpinner=findViewById(R.id.different_input);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.options_spinner, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mEditText=findViewById(R.id.edit_text_1);
        mSpinner.setAdapter(adapter);
        mSpinner.setOnItemSelectedListener(this);
    }

    public void toastText(View view){
        String content = mEditText.getText().toString();
        Toast.makeText(this,content,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (position){
            case 0:
                mEditText.setInputType(InputType.TYPE_CLASS_TEXT);
                break;
            case 1:
                mEditText.setInputType(InputType.TYPE_CLASS_NUMBER);
                break;
            case 2:
                mEditText.setInputType(InputType.TYPE_CLASS_PHONE);
                /*String encodedPhoneNumber = String.format("tel:%s", Uri.encode("*1234#"));
                Uri number = Uri.parse(encodedPhoneNumber);
                Intent callIntent = new Intent(Intent.ACTION_DIAL, number);
                context.startActivity(callIntent);*/
                break;
            case 3:
                mEditText.setInputType(InputType.TYPE_DATETIME_VARIATION_DATE);
                break;
            case 4:
                mEditText.setInputType(InputType.TYPE_CLASS_DATETIME);
                break;
            case 5:
                mEditText.setInputType(InputType.TYPE_NUMBER_VARIATION_PASSWORD);
                break;
            case 6:
                mEditText.setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}