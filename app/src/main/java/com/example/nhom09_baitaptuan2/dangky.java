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

public class dangky extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangky);
       /* EditText editText = findViewById(R.id.errorTxtUsername);
        editText.setText(editText.getText().toString() +"OnCreate");*/
        TextInputEditText errorTxtUsername = findViewById(R.id.errorTxtUsername);
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
        TextInputEditText errorTxtEmail = findViewById(R.id.errorTxtEmail);
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
        TextInputEditText errorTxtPassword = findViewById(R.id.errorTxtPassword);
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
        TextInputEditText errorTxtNhaplaiPassword = findViewById(R.id.errorTxtNhaplaiPassword);
        errorTxtNhaplaiPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence g, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence g, int start, int count, int after) {
                if(g.equals(errorTxtPassword) != g.equals(errorTxtNhaplaiPassword) ){
                    errorTxtNhaplaiPassword.setError("Không giống mật khẩu ở trên");
                }
                else {
                    errorTxtNhaplaiPassword.setError(null);
                }
            }


            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

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


}