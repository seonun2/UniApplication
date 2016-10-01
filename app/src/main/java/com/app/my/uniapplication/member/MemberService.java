package com.app.my.uniapplication.member;

/**
 * Created by 1027 on 2016-10-01.
 */

public interface MemberService {
    public MemberDto login(MemberDto memberDto);
    public MemberDto join(MemberDto memberDto);
}
