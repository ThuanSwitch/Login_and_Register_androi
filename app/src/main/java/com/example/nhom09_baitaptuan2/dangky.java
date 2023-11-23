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

public class dangky extends AppCompatActivity {
    ////// SharedReferences
    private static final String PREF_USER = "User";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_PASSWORD = "password";


    /////
    public TextInputLayout txtUserName;
    public TextInputEditText errorTxtUsername;
    public String userName;

    public TextInputLayout txtEmail;
    public TextInputEditText errorTxtEmail;
    public String email;

    public TextInputLayout txtPassword;
    public TextInputEditText errorTxtPassword;
    public String password;

    public TextInputLayout txtReEnterPassword;
    public TextInputEditText errorTxtReEnterPassword;
    public String reEnterPassword;

    ////Login
    public String saveEmail;
    public String savePassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangky);
        InitView();
    }
    public  void Thongbaodangky(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Thông báo ");
        builder.setMessage("Đăng ký thành công");
        AlertDialog dialog = builder.create();
        dialog.show();
    }
    public void GiaodienDangnhap(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void InitView (){
        //////////////Tham chieu

        ///userName
        errorTxtUsername = findViewById(R.id.errorTxtUsername);
        txtUserName = findViewById(R.id.txtUser);
        userName = String.valueOf(txtUserName.getEditText().getText());

        ///Email
        errorTxtEmail = findViewById(R.id.errorTxtEmail);
        txtEmail = findViewById(R.id.txtEmail);
        email = String.valueOf(txtEmail.getEditText().getText());


        ///Password
        errorTxtPassword = findViewById(R.id.errorTxtPassword);
        txtPassword = findViewById(R.id.txtPassword);
        password = String.valueOf(txtPassword.getEditText().getText());

        ///ReEnterPassword
        errorTxtReEnterPassword = findViewById(R.id.errorTxtReEnterPassword);
        txtReEnterPassword = findViewById(R.id.txtReEnterPassword);
        reEnterPassword = String.valueOf(txtReEnterPassword.getEditText().getText());



        /// xu ly error
        errorTxtUsername.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int count, int after) {
                if(s.length()==0){
                    errorTxtUsername.setError("Không được để trống username");
                }
                else {
                    errorTxtUsername.setError(null);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        errorTxtEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence d, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence d, int start, int count, int after) {
                if(d.length()==0 ){
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
            public void beforeTextChanged(CharSequence f, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence f, int start, int count, int after) {
                if(f.length()==0 ){
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

        errorTxtReEnterPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence g, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence g, int start, int count, int after) {
                if(g.equals(errorTxtPassword) != g.equals(errorTxtReEnterPassword) ){
                    errorTxtReEnterPassword.setError("Không giống mật khẩu ở trên");
                }
                else {
                    errorTxtReEnterPassword.setError(null);
                }
            }
            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
    public  void saveData()
    {

        AlertDialog.Builder builder =  new AlertDialog.Builder(this);
        builder.setTitle("Notification");
        if(password == reEnterPassword)
        {
            SharedPreferences sharedPreferences = getSharedPreferences(PREF_USER,MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(KEY_USERNAME,userName);
            editor.putString(KEY_EMAIL,email);
            editor.putString(KEY_PASSWORD,password);
            editor.apply();
            builder.setMessage("Sigin Successfull");
            AlertDialog dialog = builder.create();
            dialog.show();
        }
        else{
            builder.setMessage("Sigin Failed");
            AlertDialog dialog = builder.create();
            dialog.show();
        }
    }
    public void loadData()
    {
        SharedPreferences sharedPreferences = getSharedPreferences(PREF_USER,MODE_PRIVATE);

    }


}