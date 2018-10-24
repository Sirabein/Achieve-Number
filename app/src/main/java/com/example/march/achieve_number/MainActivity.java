package com.example.march.achieve_number;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView number;
    TextView turns;
    TextView history;
    EditText editText;
    Button add;
    Button multi;
    int num = 1, need = 0, t = 0;
    String h = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        number = (TextView) findViewById(R.id.number);
        turns = (TextView) findViewById(R.id.turns);
        history = (TextView) findViewById(R.id.history);
        setAllTexts();
        add = (Button) findViewById(R.id.add);
        multi = (Button) findViewById(R.id.multi);
        editText = (EditText) findViewById(R.id.target);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable s) {
                String a = editText.getText().toString();
                if (a.equals("")){
                } else {
                    need = Integer.parseInt(a);
                    check();
                    add.setEnabled(true);
                    multi.setEnabled(true);
                }
            }
        });
    }

    public void check() {
        if (num == need) {
            number.setTextColor(Color.parseColor("#50c878"));
            add.setEnabled(false);
            multi.setEnabled(false);
        } else if (num > need) {
            number.setTextColor(Color.parseColor("#cc0029"));
            add.setEnabled(false);
            multi.setEnabled(false);
        } else number.setTextColor(Color.parseColor("#000000"));
    }

    public void add(View v) {
        num++;
        t++;
        h = h + " +1";
        check();
        setAllTexts();
    }

    public void multi(View v) {
        num *= 2;
        t++;
        h = h + " *2";
        check();
        setAllTexts();
    }

    public void clear(View v) {
        num = 1;
        number.setTextColor(Color.parseColor("#000000"));
        add.setEnabled(true);
        multi.setEnabled(true);
        t = 0;
        h = "";
        setAllTexts();
    }

    public void setAllTexts() {
        number.setText(String.valueOf(num));
        turns.setText("Turns: " + String.valueOf(t));
        history.setText(h);
    }

}
