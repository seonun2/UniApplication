package com.app.my.uniapplication.member;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.app.my.uniapplication.MainActivity;
import com.app.my.uniapplication.R;

public class JoinActivity extends AppCompatActivity implements View.OnClickListener{
    EditText et_id, et_pw, et_name, et_hp, et_addr, et_email;
    Button bt_submit, bt_cancel;

    MemberService service;
    MemberDto paramDto = new MemberDto();
    MemberDto resultDto = new MemberDto();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        et_id = (EditText) findViewById(R.id.et_id);
        et_pw = (EditText) findViewById(R.id.et_pw);
        et_name = (EditText) findViewById(R.id.et_name);
        et_hp = (EditText) findViewById(R.id.et_hp);
        et_addr = (EditText) findViewById(R.id.et_addr);
        et_email = (EditText) findViewById(R.id.et_email);

        bt_submit = (Button) findViewById(R.id.bt_submit);
        bt_cancel = (Button) findViewById(R.id.bt_cancel);

        bt_submit.setOnClickListener(this);
        bt_cancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        paramDto.setId(et_id.getText().toString());
        paramDto.setPw(et_pw.getText().toString());
        paramDto.setHp(et_hp.getText().toString());
        paramDto.setEmail(et_email.getText().toString());
        paramDto.setAddress(et_addr.getText().toString());
        paramDto.setName(et_name.getText().toString());

        service = new MemberServiceImpl(this.getApplicationContext());

        switch (v.getId()){
            case (R.id.bt_submit) :
                service.regist(paramDto);
                startActivity(new Intent(JoinActivity.this, LoginActivity.class));
                break;

            case (R.id.bt_cancel) :
                Toast.makeText(JoinActivity.this, "회원가입을 취소하셨습니다.", Toast.LENGTH_LONG).show();
                startActivity(new Intent(JoinActivity.this, MainActivity.class));
                break;
        }
    }
}
