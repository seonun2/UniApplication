package com.app.my.uniapplication.member;

import android.content.Context;
import android.util.Log;

import com.app.my.uniapplication.util.Retval;

/**
 * Created by 1027 on 2016-10-01.
 */

public class MemberServiceImpl implements MemberService {

    MemberDao dao;

    public MemberServiceImpl(Context context) {
        this.dao = new MemberDao(context);
    }

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
    public Retval join(MemberDto paramDto){
        Log.i("###################" , paramDto.getId());
        Log.i("SERVICE 에서 받은 id : " , paramDto.getId());
        Log.i("SERVICE 에서 받은 pw : " , paramDto.getPw());
        Log.i("SERVICE 에서 받은 name : " , paramDto.getName());
        Log.i("SERVICE 에서 받은 addr : " , paramDto.getAddress());
        Log.i("SERVICE 에서 받은 email : " , paramDto.getEmail());
        Log.i("SERVICE 에서 받은 hp : " , paramDto.getHp());
        Log.i("###################" , paramDto.getPw());

        return dao.insert(paramDto);
    }
}
