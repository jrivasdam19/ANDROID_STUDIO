package com.jrivas.keyboard_samples;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.InputType;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class KeyboardInputType extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner mSpinner;
    EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keyboard_input_type);

        mSpinner = findViewById(R.id.different_input);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.options_spinner, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mEditText = findViewById(R.id.edit_text_1);
        mEditText.setOnEditorActionListener(new EditText.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (mEditText.getInputType() == InputType.TYPE_CLASS_PHONE) {
                    if (actionId == EditorInfo.IME_ACTION_DONE) {
                        makePhoneCall();
                    }
                }
                return false;
            }
        });
        mSpinner.setAdapter(adapter);
        mSpinner.setOnItemSelectedListener(this);
    }

    private void makePhoneCall() {
        String number = mEditText.getText().toString();
        if (number.trim().length() > 0) {
            if (ContextCompat.checkSelfPermission(KeyboardInputType.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(KeyboardInputType.this, new String[]{Manifest.permission.CALL_PHONE}, 1);
            } else {
                String dial = "tel:" + number;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            }
        } else {
            Toast.makeText(getApplicationContext(), "Enter a phone number!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode==1){
            if(grantResults.length>0&&grantResults[0]==PackageManager.PERMISSION_GRANTED){
                makePhoneCall();
            }else{
                Toast.makeText(this,"Permission DENIED",Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void toastText(View view) {
        String content = mEditText.getText().toString();
        Toast.makeText(this, content, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 0:
                mEditText.setInputType(InputType.TYPE_CLASS_TEXT);
                break;
            case 1:
                mEditText.setInputType(InputType.TYPE_CLASS_NUMBER);
                break;
            case 2:
                mEditText.setInputType(InputType.TYPE_CLASS_PHONE);
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