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

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       /* EditText editText = findViewById(R.id.errorTxtEmail);
       *//* editText.setText(editText.getText().toString() +"OnCreate");*/
        TextInputEditText errorTxtEmail = findViewById(R.id.errorTxtEmail);
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
        TextInputEditText errorTxtPassword = findViewById(R.id.errorTxtPassword);
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

   /* @Override
    protected void onStart(){
        super.onStart();
        EditText editText = findViewById(R.id.editTextText);
        editText.setText(editText.getText().toString()+"OnStart");
    }
    @Override
    protected void onResume(){
        super.onResume();
        EditText editText = findViewById(R.id.editTextText);
        editText.setText(editText.getText().toString()+"OnResume");
    }

    @Override
    protected void onPause(){
        super.onPause();
        EditText editText = findViewById(R.id.editTextText);
        editText.setText(editText.getText().toString()+"OnPause");
    }
    @Override
    protected void onStop(){
        super.onStop();
        EditText editText = findViewById(R.id.editTextText);
        editText.setText(editText.getText().toString()+"OnStop");
    }
    @Override
    protected void onRestart(){
        super.onRestart();
        EditText editText = findViewById(R.id.editTextText);
        editText.setText(editText.getText().toString()+"OnRestart");
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        EditText editText = findViewById(R.id.editTextText);
        editText.setText(editText.getText().toString()+"OnDestroy");
    }*/

    // chuc nang mo hop thoai
    public  void Thongbaodangnhap(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Thông báo");
        builder.setMessage("Đăng nhập thành công");
        AlertDialog dialog = builder.create();
        dialog.show();
    }
    public  void Giaodiendangky (View view){
        Intent intent = new Intent(this, dangky.class);
        startActivity(intent);
    }


}