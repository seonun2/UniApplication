package com.app.my.uniapplication.member;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.app.my.uniapplication.R;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    ListView lv_memberlist;
    MemberService service;
    final String[] arr = new String[1];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        lv_memberlist = (ListView)findViewById(R.id.lv_memberlist);
        service = new MemberServiceImpl(this.getApplicationContext());
        ArrayList<MemberDto> list = service.selectList();
        Log.d("서비스에서 불러온 데이터 갯수 : ", String.valueOf(list.size()));
        lv_memberlist.setAdapter(new MemberAdapter(this, list));

        lv_memberlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int i, long l) {
                MemberDto member = (MemberDto)lv_memberlist.getItemAtPosition(i);
                //Toast.makeText(ListActivity.this, "선택한 이름 : " + member.getAddress(), Toast.LENGTH_LONG).show();
                Intent intent = new Intent(ListActivity.this, MemberDetailActivity.class);
                intent.putExtra("id", member.getId());
                startActivity(intent);
            }
        });
        lv_memberlist.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View v, int i, long l) {
                MemberDto member = (MemberDto)lv_memberlist.getItemAtPosition(i);
                arr[0] = member.getId();
                new AlertDialog.Builder(ListActivity.this).setTitle("삭제 OK ?").setMessage("정말로 삭제 하시겠습니까?")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                service.unregist(arr[0]);
                                Intent refresh = new Intent(ListActivity.this, ListActivity.class);
                                startActivity(refresh);
                            }
                        })
                        .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        }).show();

                return true;
            }
        });
    }
}
