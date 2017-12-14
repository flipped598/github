package com.example.zzz.clothing;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;



public class PositionActivity extends AppCompatActivity {
    private static final String EXTRA_POSITON = "com.example.zzz.clothing.position";
    private String position;
    private Button mWriteButton;
    private EditText mWriteEditText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_position);

        mWriteEditText = (EditText) findViewById(R.id.write_edit);
        mWriteEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                                position = charSequence.toString();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        mWriteButton = (Button) findViewById(R.id.write_button);
        mWriteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                retPosition();

                finish();
            }
        });
    }
    public static String getposition (Intent result){
        return result.getStringExtra(EXTRA_POSITON);

    }

    private void retPosition(){
        Intent data = new Intent();
        data.putExtra(EXTRA_POSITON, position);
        setResult(RESULT_OK, data);
    }
}
