package com.app.my.uniapplication.member;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.app.my.uniapplication.R;
import com.app.my.uniapplication.util.Phone;

public class MemberDetailActivity extends AppCompatActivity implements View.OnClickListener{

    MemberService service;
    TextView et_id, et_pw, et_name, et_hp, et_email, et_addr;
    Button bt_submit, bt_cancel, bt_call, bt_map;
    MemberDto member, paramDto;
    Phone phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_detail);

        service = new MemberServiceImpl(this.getApplicationContext());
        phone = new Phone(this, this);

        Intent intent = this.getIntent();
        String id = intent.getExtras().getString("id");

        paramDto = new MemberDto();
        paramDto.setId(id);
        member = service.selectOne(paramDto);

        et_id = (TextView)findViewById(R.id.et_id);
        et_pw = (TextView)findViewById(R.id.et_pw);
        et_name = (TextView)findViewById(R.id.et_name);
        et_hp = (TextView)findViewById(R.id.et_hp);
        et_email = (TextView)findViewById(R.id.et_email);
        et_addr = (TextView)findViewById(R.id.et_addr);

        et_id.setText(member.getId());
        et_pw.setText(member.getPw());
        et_name.setText(member.getName());
        et_hp.setText(member.getHp());
        et_email.setText(member.getEmail());
        et_addr.setText(member.getAddress());

        bt_submit = (Button)findViewById(R.id.bt_submit);
        bt_cancel = (Button)findViewById(R.id.bt_cancel);
        bt_call = (Button)findViewById(R.id.bt_call);
        bt_map = (Button)findViewById(R.id.bt_map);

        bt_submit.setOnClickListener(this);
        bt_cancel.setOnClickListener(this);
        bt_call.setOnClickListener(this);
        bt_map.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_submit :
                Intent intent = new Intent(MemberDetailActivity.this, MemberUpdateActivity.class);
                intent.putExtra("id", member.getId());
                startActivity(intent);
                break;
            case R.id.bt_cancel :
                startActivity(new Intent(this, ListActivity.class));
                break;
            case R.id.bt_call :
                phone.dial(member.getHp());
                //phone.directCall(member.getHp());
                break;
            case R.id.bt_map :
                break;
        }
    }
}
