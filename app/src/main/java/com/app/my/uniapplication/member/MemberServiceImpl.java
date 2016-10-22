package com.app.my.uniapplication.member;

import android.content.Context;

import java.util.ArrayList;

/**
 * Created by 1027 on 2016-10-01.
 */

public class MemberServiceImpl implements MemberService {

    MemberDao dao;

    public MemberServiceImpl(Context context) {
        this.dao = new MemberDao(context);
    }

    @Override
    public void regist(MemberDto memberDto) {
        dao.insert(memberDto);
    }

    @Override
    public ArrayList<MemberDto> selectList() {
        return dao.selectList();
    }

    @Override
    public ArrayList<MemberDto> selectListByName(MemberDto memberDto) {
        return dao.selectListByName(memberDto);
    }

    @Override
    public MemberDto selectOne(MemberDto memberDto) {
        return dao.selectOne(memberDto);
    }

    @Override
    public int selectAllCount() {
        return dao.selectAllCount();
    }

    @Override
    public void update(MemberDto memberDto) {
        dao.update(memberDto);
    }

    @Override
    public void unregist(String id) {
        dao.delete(id);
    }
}
