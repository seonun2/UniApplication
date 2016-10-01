package com.app.my.uniapplication.member;

import android.util.Log;

/**
 * Created by 1027 on 2016-10-01.
 */

public class MemberServiceImpl implements MemberService {

    MemberDao dao = new MemberDao();

    @Override
    public MemberDto login(MemberDto paramDto){
        Log.i("###################" , paramDto.getId());
        Log.i("SERVICE 에서 받은 id : " , paramDto.getId());
        Log.i("SERVICE 에서 받은 pw : " , paramDto.getPw());
        Log.i("###################" , paramDto.getPw());
        MemberDto memberDto = new MemberDto();
        memberDto = dao.select(paramDto);

        if (memberDto == null){
            memberDto.setId("NONE");
        }else if(!memberDto.getPw().equals(paramDto.getPw())){
            memberDto.setId("NO_MATCH_PW");
        }else if(!memberDto.getId().equals(paramDto.getId())){
            memberDto.setId("NO_MATCH_ID");
        }
        return memberDto;
    }
    public MemberDto join(MemberDto paramDto){
        return null;
    }
}
