package com.app.my.uniapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CalcActivity extends AppCompatActivity implements View.OnClickListener {
    EditText et_num_1, et_num_2;
    Button bt_plus, bt_minus, bt_multi, bt_divi, bt_rest, bt_equal;
    TextView tv_result;
    int result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);
        et_num_1 = (EditText) findViewById(R.id.et_num_1);
        et_num_2 = (EditText) findViewById(R.id.et_num_2);

        bt_plus = (Button) findViewById(R.id.bt_plus);
        bt_minus = (Button) findViewById(R.id.bt_minus);
        bt_multi = (Button) findViewById(R.id.bt_multi);
        bt_divi = (Button) findViewById(R.id.bt_divi);
        bt_rest = (Button) findViewById(R.id.bt_rest);
        bt_equal = (Button) findViewById(R.id.bt_equal);

        tv_result = (TextView) findViewById(R.id.tv_result);

        bt_plus.setOnClickListener(this);
        bt_minus.setOnClickListener(this);
        bt_multi.setOnClickListener(this);
        bt_divi.setOnClickListener(this);
        bt_rest.setOnClickListener(this);
        bt_equal.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        int num1 = Integer.parseInt(et_num_1.getText().toString());
        int num2 = Integer.parseInt(et_num_2.getText().toString());

        switch (v.getId()){
            case R.id.bt_plus :
                result = num1 + num2;
                break;
            case R.id.bt_minus :
                result = num1 - num2;
                break;
            case R.id.bt_multi :
                result = num1 * num2;
                break;
            case R.id.bt_divi :
                result = num1 / num2;
                break;
            case R.id.bt_rest :
                result = num1 % num2;
                break;
            case R.id.bt_equal :
                tv_result.setText("계산 결과 : " + result);
                break;
        }
    }
}
