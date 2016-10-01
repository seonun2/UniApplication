package com.app.my.uniapplication.member;

/**
 * Created by 1027 on 2016-10-01.
 */

public class MemberDto {

    private String kor_name, eng_first_name, eng_last_name, id, pw, hp, birthday, address, phone, profileImg, email;


    public String getKor_name() {
        return kor_name;
    }

    public void setKor_name(String kor_name) {
        this.kor_name = kor_name;
    }

    public String getEng_first_name() {
        return eng_first_name;
    }

    public void setEng_first_name(String eng_first_name) {
        this.eng_first_name = eng_first_name;
    }

    public String getEng_last_name() {
        return eng_last_name;
    }

    public void setEng_last_name(String eng_last_name) {
        this.eng_last_name = eng_last_name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getHp() {
        return hp;
    }

    public void setHp(String hp) {
        this.hp = hp;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getProfileImg() {
        return profileImg;
    }

    public void setProfileImg(String profileImg) {
        this.profileImg = profileImg;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}