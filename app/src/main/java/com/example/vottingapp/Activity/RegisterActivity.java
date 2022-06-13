package com.example.vottingapp.Activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.vottingapp.API.APIInterface;
import com.example.vottingapp.API.RetrofitServer;
import com.example.vottingapp.Model.register.ResponseRegister;
import com.example.vottingapp.R;
import com.example.vottingapp.utils.RealPathUtil;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {
    APIInterface apiInterface;

    EditText et_email, et_password, et_namalengkap, et_nik, et_tempattinggal, et_nomorhp;
    ImageButton btn_upload, btn_register;
    String path;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        apiInterface = RetrofitServer.connectRetrofit().create(APIInterface.class);

        et_email = findViewById(R.id.et_emailreg);
        et_password = findViewById(R.id.et_passwordreg);
        et_namalengkap = findViewById(R.id.et_namalengkapreg);
        et_nik = findViewById(R.id.et_nikreg);
        et_tempattinggal = findViewById(R.id.et_tempattinggalreg);
        et_nomorhp = findViewById(R.id.et_nomorhpreg);
        // Button
        btn_upload = findViewById(R.id.btn_upload);
        btn_register = findViewById(R.id.btn_register);

//        iv_upload = findViewById(R.id.iv_upload);



        btn_upload.setOnClickListener(v -> {
            if (ContextCompat.checkSelfPermission(getApplicationContext(),
                    Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED){
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent, 10);
            } else {
                ActivityCompat.requestPermissions(RegisterActivity.this,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
            }
        });

        btn_register.setOnClickListener(v -> {
            register();
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 10 && resultCode == Activity.RESULT_OK ){
            Uri uri = data.getData();
            Context context = RegisterActivity.this;
            path = RealPathUtil.getRealPath(context, uri);
            Bitmap bitmap = BitmapFactory.decodeFile(path);
            btn_upload.setImageBitmap(bitmap);
//            iv_upload.setImageBitmap(bitmap);
        }
    }
    // Register
    public void register(){
        String email, password, namalengkap, nik, tempattinggal, nomorhp;
        email = et_email.getText().toString();
        password = et_password.getText().toString();
        namalengkap = et_namalengkap.getText().toString();
        nik = et_nik.getText().toString();
        tempattinggal = et_tempattinggal.getText().toString();
        nomorhp = et_nomorhp.getText().toString();
        if (email.trim().equals("") &&
                password.trim().equals("") &&
                namalengkap.trim().equals("")  &&
                nik.trim().equals("") &&
                tempattinggal.trim().equals("") &&
                nomorhp.trim().equals("")
        ){

            Toast.makeText(this, "Data tidak boleh kosong", Toast.LENGTH_SHORT).show();
        }
        if (path == null){
            Toast.makeText(this, "Mohon upload image", Toast.LENGTH_SHORT).show();
            return;
        }
        File file = new File(path);
        RequestBody requestFile = RequestBody.create(MediaType.parse("mutipart/form-data"), file);
        MultipartBody.Part bodyimg = MultipartBody.Part.createFormData("image", file.getName(), requestFile);
        RequestBody requestEmail = RequestBody.create(MediaType.parse("multipart/form-data"), email);
        RequestBody requestPassword = RequestBody.create(MediaType.parse("multipart/form-data"), password);
        RequestBody requestNamaLengkap = RequestBody.create(MediaType.parse("multipart/form-data"), namalengkap);
        RequestBody requestNik = RequestBody.create(MediaType.parse("multipart/form-data"), nik);
        RequestBody requestNomorHp = RequestBody.create(MediaType.parse("multipart/form-data"), nomorhp);
        RequestBody requestTempattinggal = RequestBody.create(MediaType.parse("multipart/form-data"), tempattinggal);

        apiInterface.register(
                requestEmail,
                requestPassword,
                requestNamaLengkap,
                requestNik,
                requestTempattinggal,
                requestNomorHp,
                bodyimg
        ).enqueue(new Callback<ResponseRegister>() {
            @Override
            public void onResponse(Call<ResponseRegister> call, Response<ResponseRegister> response) {
                if (response.isSuccessful()){
                    if (response.body() != null){
                        String status =response.body().getStatus();
                        String message = response.body().getMessage();
                        if (status.equals("success")){
                            Toast.makeText(RegisterActivity.this, "Success, "+ message, Toast.LENGTH_SHORT).show();

                            // Mengirim user ke activity login
                            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                            startActivity(intent);
                            finish();
                        } else {
                            Toast.makeText(RegisterActivity.this, message , Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(RegisterActivity.this, "Data null", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseRegister> call, Throwable t) {
                Toast.makeText(RegisterActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}