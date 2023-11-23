package com.example.nhom09_baitaptuan2;



import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    public TextInputLayout txtEmail ;
    public String email ;
    public TextInputLayout txtPassword ;
    public String passWord ;



    /////SharedReferences
    private static final String PREF_USER = "User";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_PASSWORD = "password";



    ////Login
    public String saveEmail;
    public String savePassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        loadData();

    }

    public  void Thongbaodangnhap(View view){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Notification");
        if (email == null || passWord ==null)
        {
            builder.setMessage("Đăng nhập không thành công");
            AlertDialog dialog = builder.create();
            dialog.show();
        }
        System.out.println(saveEmail);
        System.out.println(savePassword);
        if (email == saveEmail && passWord == savePassword)
        {
            builder.setMessage("Đăng nhập thành công");
            AlertDialog dialog = builder.create();
            dialog.show();
        }
    }
    public  void Giaodiendangky (View view){
        Intent intent = new Intent(this, dangky.class);
        startActivity(intent);
    }
    void initView(){
        //////
        TextInputEditText errorTxtEmail = findViewById(R.id.errorTxtEmail);
        TextInputEditText errorTxtPassword = findViewById(R.id.errorTxtPassword);

        ///////
        txtEmail = findViewById(R.id.txtEmail);
        email = String.valueOf(txtEmail.getEditText().getText());
        txtPassword = findViewById(R.id.txtPassword);
        passWord = String.valueOf(txtPassword.getEditText().getText());
        ///////
        errorTxtEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int count, int after) {
                if(s.length()==0 ){
                    errorTxtEmail.setError("Không được để trống email");
                }
                else {
                    errorTxtEmail.setError(null);
                }
            }


            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        errorTxtPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence d, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence d, int start, int count, int after) {
                if(d.length()==0 ){
                    errorTxtPassword.setError("Không được để trống password");
                }
                else {
                    errorTxtPassword.setError(null);
                }
            }


            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
    public void loadData()
    {
        SharedPreferences sharedPreferences = getSharedPreferences(PREF_USER,MODE_PRIVATE);
        saveEmail = sharedPreferences.getString(KEY_EMAIL,null);
        savePassword = sharedPreferences.getString(KEY_PASSWORD,null);
    }


}