package com.app.my.uniapplication.member;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.app.my.uniapplication.util.Retval;

/**
 * Created by 1027 on 2016-10-01.
 */

public class MemberDao extends SQLiteOpenHelper{


    public MemberDao(Context context) {
        super(context, "hanbitdb", null, 1);
        // 위치값, 만들 db 이름, 팩토리, 버전
        this.getWritableDatabase(); // 입력 가능한 DB로 만들어라
        Log.d("DB가 만들어지면 이 글이 보임!!!!", "SUCCESS");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public MemberDto select(MemberDto paramDto){
        Log.i("###################" , paramDto.getId());
        Log.i("DAO 에서 받은 id : " , paramDto.getId());
        Log.i("DAO 에서 받은 pw : " , paramDto.getPw());
        Log.i("###################" , paramDto.getPw());
        MemberDto memberDto = new MemberDto();
        memberDto.setId("seonun2");
        memberDto.setPw("1111");
        memberDto.setName("선운이");
        return memberDto;
    }

    public Retval insert(MemberDto paramDto){
        Retval val = new Retval();
        if(true){
            val.setMessage("SUCCESS");
        }else{
            val.setMessage("FAIL");
        }
        return val;
    }
    public MemberDto update(MemberDto paramDto){
        MemberDto memberDto = new MemberDto();
        return memberDto;
    }

    public MemberDto delete(MemberDto paramDto){
        MemberDto memberDto = new MemberDto();
        return memberDto;
    }


}
