package com.example.nhom09_baitaptuan2;



import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    public  void Thongbaodangnhap(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Thông báo");
        if (email == null || passWord ==null)
        {
            builder.setMessage("Đăng nhập không thành công");
            AlertDialog dialog = builder.create();
            dialog.show();
        }
        else {
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
        TextInputLayout txtEmail = findViewById(R.id.txtEmail);
        String email = String.valueOf(txtEmail.getEditText().getText());
        TextInputLayout txtPassword = findViewById(R.id.txtPassword);
        String passWord = String.valueOf(txtPassword.getEditText().getText());
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


}