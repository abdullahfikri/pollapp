package com.example.vottingapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.vottingapp.API.APIInterface;
import com.example.vottingapp.API.RetrofitServer;
import com.example.vottingapp.Model.login.ResponseLogin;
import com.example.vottingapp.Model.login.Data;
import com.example.vottingapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginActivity extends AppCompatActivity {
    @BindView(R.id.btn_login)
    Button login;

    @BindView(R.id.et_email)
    EditText et_email;

    @BindView(R.id.et_password)
    EditText et_password;

    APIInterface apiInterface;

    private static final String TAG = "LoginActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        apiInterface = RetrofitServer.connectRetrofit().create(APIInterface.class);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
            }
        });
    }

    private void loginUser(){
        String email = et_email.getText().toString();
        String password = et_password.getText().toString();

        apiInterface.login(email, password).enqueue(new Callback<ResponseLogin>() {
            @Override
            public void onResponse(Call<ResponseLogin> call, Response<ResponseLogin> response) {
                String message = response.body().getMessage();
                String status = response.body().getStatus();

                if (status.equals("success")){
                    Data userData = response.body().getData();

                    Intent intent = new Intent(LoginActivity.this, ProfilUser.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NO_HISTORY);
                    intent.putExtra("email",userData.getEmail());
                    intent.putExtra("nik",userData.getNik());
                    intent.putExtra("namalengkap",userData.getNamalengkap());
                    intent.putExtra("statusvoting",userData.getStatusvoting());
                    intent.putExtra("imgurl",userData.getImgurl());
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(LoginActivity.this, "Log In : " +  status+ ", "+message  , Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseLogin> call, Throwable t) {
                Log.e(TAG, "onFailure: "+ t.getLocalizedMessage());
                Toast.makeText(LoginActivity.this, "Gagal Terhubung ke server", Toast.LENGTH_LONG).show();
            }
        });
    }
}