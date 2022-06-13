package com.example.vottingapp.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.vottingapp.Model.login.Data;

import java.util.HashMap;

/**
 * Created by ${user} on 25/04/2018.
 */
public class SessionManager {
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private Context _context;

    public static final String IS_LOGGED_IN = "isLoggedIn";
    public static final String ID_USER = "userId";
    public static final String EMAIL = "email";
    public static final String PASSWORD = "password";
    public static final String NIK = "nik";
    public static final String NAMA_LENGKAP = "namaLengkap";
    public static final String NOMOR_HP = "noHP";
    public static final String STATUS_VOTTING = "statusVotting";
    public static final String TEMPAT_TINGGAL = "tempatTinggal";
    public static final String IMG_URL = "imageUrl";

    public Context get_context() {return _context;}

    //constructor
    public SessionManager(Context context){
        this._context = context;
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        editor = sharedPreferences.edit();
    }

    public void createLoginSession(Data user)
    {
        editor.putBoolean(IS_LOGGED_IN,true);
        editor.putString(ID_USER,user.getId());
        editor.putString(EMAIL,user.getEmail());
        editor.putString(PASSWORD,user.getPassword());
        editor.putString(NIK, user.getNik());
        editor.putString(NAMA_LENGKAP,user.getNamalengkap());
        editor.putString(NOMOR_HP,user.getNomorhp());
        editor.putString(STATUS_VOTTING,user.getStatusvoting());
        editor.putString(TEMPAT_TINGGAL,user.getTempattinggal());
        editor.putString(IMG_URL,user.getImgurl());
        editor.commit();
    }

    public HashMap<String,String> getUserDetail(){
        HashMap<String,String> user = new HashMap<>();
        user.put(ID_USER,sharedPreferences.getString(ID_USER,null));
        user.put(EMAIL,sharedPreferences.getString(EMAIL,null));
        user.put(PASSWORD,sharedPreferences.getString(PASSWORD,null));
        user.put(NIK,sharedPreferences.getString(NIK,null));
        user.put(NAMA_LENGKAP,sharedPreferences.getString(NAMA_LENGKAP,null));
        user.put(NOMOR_HP,sharedPreferences.getString(NOMOR_HP,null));
        user.put(STATUS_VOTTING,sharedPreferences.getString(STATUS_VOTTING,null));
        user.put(TEMPAT_TINGGAL,sharedPreferences.getString(TEMPAT_TINGGAL,null));
        user.put(IMG_URL,sharedPreferences.getString(IMG_URL,null));
        return  user;

    }

    public void logoutUser(){
        //clearing all data from shared Preferences
        editor.clear();
        editor.commit();
    }

    public boolean isLogginIN(){
        return sharedPreferences.getBoolean(IS_LOGGED_IN,false);
    }

}