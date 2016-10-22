package com.app.my.uniapplication.member;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.app.my.uniapplication.R;

public class MemberUpdateActivity extends AppCompatActivity implements View.OnClickListener{

    MemberService service;
    TextView et_id, et_name;
    EditText et_pw, et_hp, et_email, et_addr;
    Button bt_submit, bt_cancel;
    MemberDto member, paramDto, temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_update);

        service = new MemberServiceImpl(this.getApplicationContext());
        Intent intent = this.getIntent();
        String id = intent.getExtras().getString("id");
        paramDto = new MemberDto();
        paramDto.setId(id);
        member = service.selectOne(paramDto);

        et_id = (TextView)findViewById(R.id.et_id);
        et_name = (TextView)findViewById(R.id.et_name);

        et_pw = (EditText)findViewById(R.id.et_pw);
        et_hp = (EditText)findViewById(R.id.et_hp);
        et_email = (EditText)findViewById(R.id.et_email);
        et_addr = (EditText)findViewById(R.id.et_addr);

        et_id.setText(member.getId());
        et_name.setText(member.getName());

        et_pw.setHint(member.getPw());
        et_hp.setHint(member.getHp());
        et_email.setHint(member.getEmail());
        et_addr.setHint(member.getAddress());

        bt_submit = (Button)findViewById(R.id.bt_submit);
        bt_cancel = (Button)findViewById(R.id.bt_cancel);

        bt_submit.setOnClickListener(this);
        bt_cancel.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_submit :

                temp = new MemberDto();
                String pw, hp, email, addr;

                temp.setId(member.getId());
                temp.setName(member.getName());

                temp.setPw((et_pw.getText().toString().equals("")) ? member.getPw() : et_pw.getText().toString());
                temp.setHp((et_hp.getText().toString().equals("")) ? member.getHp() : et_hp.getText().toString());
                temp.setEmail((et_email.getText().toString().equals("")) ? member.getEmail() : et_email.getText().toString());
                temp.setAddress((et_addr.getText().toString().equals("")) ? member.getAddress() : et_addr.getText().toString());

                service.update(temp);
                Intent intent = new Intent(this, MemberDetailActivity.class);
                intent.putExtra("id", member.getId());
                startActivity(intent);

                break;
            case R.id.bt_cancel :
                Intent intent2 = new Intent(this, MemberDetailActivity.class);
                intent2.putExtra("id", member.getId());
                startActivity(intent2);
                break;
        }
    }
}
