package com.app.my.uniapplication.member;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.app.my.uniapplication.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    Button bt_login, bt_join;
    EditText et_id, et_pw;
    MemberDto paramDto = new MemberDto();
    MemberDto resultDto = new MemberDto();

    MemberService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        service = new MemberServiceImpl(this.getApplicationContext());

        bt_join = (Button)findViewById(R.id.bt_join);
        bt_login = (Button)findViewById(R.id.bt_login);
        et_id = (EditText)findViewById(R.id.et_id);
        et_pw = (EditText)findViewById(R.id.et_pw);

        bt_join.setOnClickListener(this);
        bt_login.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String sId, sPw;

        sId = et_id.getText().toString();
        sPw = et_pw.getText().toString();

        switch (v.getId()){
            case(R.id.bt_login) :

                paramDto.setId(sId);
                paramDto.setPw(sPw);
                resultDto = service.selectOne(paramDto);

                if(resultDto != null){
                    if(!resultDto.getPw().equals(sPw)){
                        Toast.makeText(LoginActivity.this, "비밀번호가 일치하지 않습니다.", Toast.LENGTH_LONG).show();
                    }else if(!resultDto.getId().equals(sId)){
                        Toast.makeText(LoginActivity.this, "아이디가 일치하지 않습니다.", Toast.LENGTH_LONG).show();
                    }else{
                        startActivity(new Intent(LoginActivity.this, ListActivity.class));
                    }
                }else{
                    Toast.makeText(LoginActivity.this, "해당정보는 존재하지 않습니다.", Toast.LENGTH_LONG).show();
                }

                break;

            case(R.id.bt_join) :
                Toast.makeText(LoginActivity.this, "회원가입 하실건가요??", Toast.LENGTH_LONG).show();
                startActivity(new Intent(LoginActivity.this, JoinActivity.class));
                break;
        }

    }
}
