package com.app.my.uniapplication.member;

import com.app.my.uniapplication.util.Retval;

/**
 * Created by 1027 on 2016-10-01.
 */

public interface MemberService {
    public MemberDto login(MemberDto memberDto);
    public Retval join(MemberDto memberDto);
}
