package com.app.my.uniapplication.member;

import android.util.Log;

/**
 * Created by 1027 on 2016-10-01.
 */

public class MemberDao {
    public MemberDto select(MemberDto paramDto){
        Log.i("###################" , paramDto.getId());
        Log.i("DAO 에서 받은 id : " , paramDto.getId());
        Log.i("DAO 에서 받은 pw : " , paramDto.getPw());
        Log.i("###################" , paramDto.getPw());
        MemberDto memberDto = new MemberDto();
        memberDto.setId("seonun2");
        memberDto.setPw("1111");
        memberDto.setKor_name("선운이");
        return memberDto;
    }

    public MemberDto insert(MemberDto paramDto){
        MemberDto memberDto = new MemberDto();
        return memberDto;
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
