package com.app.my.uniapplication.member;

import java.util.ArrayList;

/**
 * Created by 1027 on 2016-10-01.
 */

public interface MemberService {
    // CREATE
    public void regist(MemberDto memberDto);

    // READ
    public ArrayList<MemberDto> selectList();
    public ArrayList<MemberDto> selectListByName(MemberDto memberDto);
    public MemberDto selectOne(MemberDto memberDto);
    public int selectAllCount();

    // UPDATE
    public void update(MemberDto memberDto);

    // DELETE
    public void unregist(String id);

}
