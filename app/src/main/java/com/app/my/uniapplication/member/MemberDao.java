package com.app.my.uniapplication.member;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by 1027 on 2016-10-01.
 */

public class MemberDao extends SQLiteOpenHelper{

    public static final String DB_NAME = "hanbit.db";
    public static final int DB_VERSION = 1;
    public static final String TABLE_NAME = "member";
    public static final String NAME = "name";
    public static final String ID = "id";
    public static final String PW = "pw";
    public static final String HP = "hp";
    public static final String BIRTHDAY = "birthday";
    public static final String ADDRESS = "address";
    public static final String PHONE = "phone";
    public static final String PHOTO = "profileImg";
    public static final String EMAIL = "email";

    public MemberDao(Context context) {

        super(context, DB_NAME, null, DB_VERSION);
        // 위치값, 만들 db 이름, 팩토리, 버전
        this.getWritableDatabase(); // 입력 가능한 DB로 만들어라
        Log.d("DB가 만들어지면 이 글이 보임!!!!", "SUCCESS");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table if not exists member(" +
                "     id text primary key," +
                "     pw text," +
                "     name text, " +
                "     email text, " +
                "     address text," +
                "     phone text," +
                "     profileImg text," +
                "     eng_first_name text, " +
                "     eng_last_name text," +
                "     hp text, " +
                "     birthday text" +
                ")");
        db.execSQL("insert into member(id, pw, name, email, address, phone, profileImg, eng_first_name, eng_last_name, hp, birthday) values ('seonun1', '1111', '선운1', 'seonun2@naver.com', '서울1', '02-1111-1111', 'default', 'seonun', 'kim', '010-1111-1111', '19830101')");
        db.execSQL("insert into member(id, pw, name, email, address, phone, profileImg, eng_first_name, eng_last_name, hp, birthday) values ('seonun2', '1111', '선운2', 'seonun2@naver.com', '37.6071181,126.9110379', '02-2222-2222', 'default', 'seonun', 'kim', '010-8962-9724', '19830201')");
        db.execSQL("insert into member(id, pw, name, email, address, phone, profileImg, eng_first_name, eng_last_name, hp, birthday) values ('seonun3', '1111', '선운3', 'seonun2@naver.com', '서울3', '02-3333-3333', 'default', 'seonun', 'kim', '010-3333-3333', '19830301')");
        db.execSQL("insert into member(id, pw, name, email, address, phone, profileImg, eng_first_name, eng_last_name, hp, birthday) values ('seonun4', '1111', '선운4', 'seonun2@naver.com', '서울4', '02-4444-4444', 'default', 'seonun', 'kim', '010-4444-4444', '19830401')");
        db.execSQL("insert into member(id, pw, name, email, address, phone, profileImg, eng_first_name, eng_last_name, hp, birthday) values ('seonun5', '1111', '선운5', 'seonun2@naver.com', '서울5', '02-5555-5555', 'default', 'seonun', 'kim', '010-5555-5555', '19830501')");
        db.execSQL("insert into member(id, pw, name, email, address, phone, profileImg, eng_first_name, eng_last_name, hp, birthday) values ('seonun6', '1111', '선운6', 'seonun2@naver.com', '서울6', '02-6666-6666', 'default', 'seonun', 'kim', '010-6666-6666', '19830601')");
        db.execSQL("insert into member(id, pw, name, email, address, phone, profileImg, eng_first_name, eng_last_name, hp, birthday) values ('seonun7', '1111', '선운7', 'seonun2@naver.com', '서울7', '02-7777-7777', 'default', 'seonun', 'kim', '010-7777-7777', '19830701')");
        db.execSQL("insert into member(id, pw, name, email, address, phone, profileImg, eng_first_name, eng_last_name, hp, birthday) values ('seonun8', '1111', '선운8', 'seonun2@naver.com', '서울8', '02-8888-8888', 'default', 'seonun', 'kim', '010-8888-8888', '19830801')");
        db.execSQL("insert into member(id, pw, name, email, address, phone, profileImg, eng_first_name, eng_last_name, hp, birthday) values ('seonun9', '1111', '선운9', 'seonun2@naver.com', '서울9', '02-9999-9999', 'default', 'seonun', 'kim', '010-9999-9999', '19830901')");
        db.execSQL("insert into member(id, pw, name, email, address, phone, profileImg, eng_first_name, eng_last_name, hp, birthday) values ('seonun10', '1111', '선운10', 'seonun2@naver.com', '서울10', '02-1010-1010', 'default', 'seonun', 'kim', '010-1010-1010', '19831001')");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("insert into Android values(null, 'android_6.0.0',1);");
        db.execSQL("insert into Android values(null, 'android_6.0.1',2);");
        this.onCreate(db);
    }

    //DML ( CREATE )
    public void insert(MemberDto paramDto){
        Log.i("###################" , "###################");
        Log.i("DAO insert " , "insert()진입");

        String sql = "insert into " + TABLE_NAME
                   + String.format("(%s,%s,%s,%s,%s,%s,%s,%s,%s)", ID, PW, NAME, EMAIL, ADDRESS, PHONE, PHOTO, HP, BIRTHDAY)
                   + String.format("values('%s','%s','%s','%s','%s','%s','%s','%s','%s');", paramDto.getId(), paramDto.getPw(), paramDto.getName(), paramDto.getEmail(), paramDto.getAddress(), paramDto.getPhone(), paramDto.getProfileImg(), paramDto.getHp(), paramDto.getBirthday());

        SQLiteDatabase db = this.getWritableDatabase();

        db.execSQL(sql);
        db.close();
    }

    //DML ( READ )
    public ArrayList<MemberDto> selectList(){
        ArrayList<MemberDto> list = new ArrayList<MemberDto>();

        Log.i("###################" , "###################");
        Log.i("DAO 전체 조회 " , "selectList()진입");

        String sql = "select "+
                String.format("(%s,%s,%s,%s,%s,%s,%s,%s,%s)", ID, PW, NAME, EMAIL, ADDRESS, PHONE, PHOTO, HP, BIRTHDAY)
                +" from member";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        if(cursor != null){
            Log.i("###################" , "###################");
            Log.i("DAO LIST 조회 결과 " , "selectList()진입");
            cursor.moveToFirst();
        }

        do{

            MemberDto tmp = new MemberDto();
            tmp.setId(cursor.getString(0));
            tmp.setPw(cursor.getString(1));
            tmp.setName(cursor.getString(2));
            tmp.setEmail(cursor.getString(3));
            tmp.setAddress(cursor.getString(4));
            tmp.setPhone(cursor.getString(5));
            tmp.setProfileImg(cursor.getString(6));
            tmp.setHp(cursor.getString(7));
            tmp.setBirthday(cursor.getString(8));

            list.add(tmp);

        } while(cursor.moveToNext());

        return list;
    }

    public ArrayList<MemberDto> selectListByName(MemberDto paramDto){
        ArrayList<MemberDto> list = new ArrayList<MemberDto>();
        Log.i("###################" , "###################");
        Log.i("DAO NAME 조회 " , "selectListByName()진입");

        String sql = "select "+
                String.format("(%s,%s,%s,%s,%s,%s,%s,%s,%s)", ID, PW, NAME, EMAIL, ADDRESS, PHONE, PHOTO, HP, BIRTHDAY)
                +String.format(" from %s where %s = '%s';", TABLE_NAME, NAME, paramDto.getName());

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        if(cursor != null){
            Log.i("###################" , "###################");
            Log.i("DAO LIST BY NAME 조회 결과 " , "selectListByName()진입");
            cursor.moveToFirst();
        }

        do{

            MemberDto tmp = new MemberDto();
            tmp.setId(cursor.getString(0));
            tmp.setPw(cursor.getString(1));
            tmp.setName(cursor.getString(2));
            tmp.setEmail(cursor.getString(3));
            tmp.setAddress(cursor.getString(4));
            tmp.setPhone(cursor.getString(5));
            tmp.setProfileImg(cursor.getString(6));
            tmp.setHp(cursor.getString(7));
            tmp.setBirthday(cursor.getString(8));

            list.add(tmp);

        } while(cursor.moveToNext());

        return list;
    }

    public MemberDto selectOne(MemberDto paramDto){
        Log.i("###################" , "###################");
        Log.i("DAO ID 조회 " , "selectListByName()진입");
        MemberDto tmp = null;

        String sql = "select "+
                String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s", ID, PW, NAME, EMAIL, ADDRESS, PHONE, PHOTO, HP, BIRTHDAY)
                +String.format(" from %s where %s = '%s';", TABLE_NAME, ID, paramDto.getId());

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        if(cursor.moveToNext()){
            Log.i("###################" , "###################");
            Log.i("DAO LIST BY ID 조회 결과 " , "ID 존재!!");

           tmp = new MemberDto();

            tmp.setId(cursor.getString(0));
            tmp.setPw(cursor.getString(1));
            tmp.setName(cursor.getString(2));
            tmp.setEmail(cursor.getString(3));
            tmp.setAddress(cursor.getString(4));
            tmp.setPhone(cursor.getString(5));
            tmp.setProfileImg(cursor.getString(6));
            tmp.setHp(cursor.getString(7));
            tmp.setBirthday(cursor.getString(8));
        }

        return tmp;
    }

    public int selectAllCount(){
        Log.i("###################" , "###################");
        Log.i("DAO 전체 조회 " , "selectList()진입");

        int cnt = 0;

        String sql = "select count(*) as count from member";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        if(cursor.moveToNext()){
            Log.i("###################" , "###################");
            Log.i("DAO COUNT 조회 결과 " , "COUNT!!");
            cnt = cursor.getInt(cursor.getColumnIndex("count"));

        }

        return cnt;
    }

    //DML ( UPDATE )
    public void update(MemberDto paramDto){
        Log.i("###################" , "###################");
        Log.i("DAO update " , "update()진입");

        String sql = String.format("update %s set", TABLE_NAME)
                + String.format("%s = '%s',", PW, paramDto.getPw())
                + String.format("%s = '%s',", EMAIL, paramDto.getEmail())
                + String.format("%s = '%s',", ADDRESS, paramDto.getAddress())
                + String.format("%s = '%s',", PHONE, paramDto.getPhone())
                + String.format("%s = '%s',", PHOTO, paramDto.getProfileImg())
                + String.format("where %s = '%s'", ID, paramDto.getId());

        SQLiteDatabase db = this.getWritableDatabase();

        db.execSQL(sql);
        db.close();
    }

    //DML ( DELETE )
    public void delete(MemberDto paramDto){
        Log.i("###################" , "###################");
        Log.i("DAO delete " , "delete()진입");

        String sql = String.format("delete from ", TABLE_NAME)
                + String.format("where %s = '%s'", ID, paramDto.getId());

        SQLiteDatabase db = this.getWritableDatabase();

        db.execSQL(sql);
        db.close();
    }


}
