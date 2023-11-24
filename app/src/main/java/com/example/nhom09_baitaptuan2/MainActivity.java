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

    public TextInputEditText txtEmail ;
    public String email ;
    public TextInputEditText txtPassword ;
    public String passWord ;



    ///SharedReferences
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

        email = String.valueOf(txtEmail.getText());
        passWord = String.valueOf(txtPassword.getText());
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Notification");
        if (email == null || passWord ==null)
        {
            builder.setMessage("Đăng nhập không thành công");
            AlertDialog dialog = builder.create();
            dialog.show();
        }
        if (email.equals(saveEmail) && passWord.equals(savePassword))
        {
            builder.setMessage("Đăng nhập thành công");
            AlertDialog dialog = builder.create();
            dialog.show();
        }
        else {
            builder.setMessage("user or password not correct");
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


        ///////
        txtEmail = findViewById(R.id.TxtEmail);

        txtPassword = findViewById(R.id.TxtPassword);

        ///////
        txtEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int count, int after) {
                if(s.length()==0 ){
                    txtEmail.setError("Không được để trống email");
                }
                else {
                    txtEmail.setError(null);
                }
            }


            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        txtPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence d, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence d, int start, int count, int after) {
                if(d.length()==0 ){
                    txtPassword.setError("Không được để trống password");
                }
                else {
                    txtPassword.setError(null);
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