package com.bca.mobile_programming.unit_4;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bca.mobile_programming.R;

public class Contact extends AppCompatActivity {
    @Override
    public void onCreate(Bundle b){
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);

        super.onCreate(b);
        setContentView(R.layout.unit_2_hello);
        this.setFinishOnTouchOutside(false);

        TextView heading =findViewById(R.id.helloHeadingText);
        Button cancelButton = findViewById(R.id.unit2helloCancelBtn);
        Button submitButton = findViewById(R.id.unit2helloSubmitBtn);
        EditText fullNameInput = findViewById(R.id.helloFullNameInput);

        submitButton.setOnClickListener(v->{
            String fullnameValue =fullNameInput.getText().toString();
        if(fullnameValue.isEmpty()) fullnameValue="no Value";
        heading.setText(fullnameValue);
        });
        cancelButton.setOnClickListener(v->{
            Toast.makeText(getApplicationContext(),"close",Toast.LENGTH_SHORT).show();
            finish();
        });



    }
}
