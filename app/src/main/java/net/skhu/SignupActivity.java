package net.skhu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        Button button = (Button)findViewById(R.id.button);
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
                boolean isError = false;
                
                EditText editText_loginId = (EditText)findViewById(R.id.editText_loginId);
                String loginId = editText_loginId.getText().toString(); //getText 에서 꺼내온 것은 Editable(CharSequence의 자식) 이기 때문에 toString
                if (isEmptyOrWhiteSpace(loginId)) {
                    editText_loginId.setError("로그인 아이디를 입력하세요.");
                    isError = true;
                }
                EditText editText_password = (EditText)findViewById(R.id.editText_password);
                String password = editText_password.getText().toString();
                if (isEmptyOrWhiteSpace(password)){
                    editText_password.setError("비밀번호를 입력하세요.");
                    isError = true;
                }

                EditText editText_password2 = (EditText)findViewById(R.id.editText_password2);
                String password2 = editText_password2.getText().toString();
                if (password.equals(password2)== false){
                    editText_password2.setError("비밀번호가 일치하지 않습니다.");
                    isError = true;
                }

                EditText editText_email = (EditText)findViewById(R.id.editText_email);
                String email = editText_email.getText().toString();
                if (isError == false) {
                    //회원가입 데이터를 서버에 전송하는 코드

                    String msg = "회원가입 성공: " + loginId + " " + email;
                    Toast.makeText(SignupActivity.this, msg, Toast.LENGTH_LONG).show();
                    //이 때 그냥 this를 사용하게 된다면 에러. 이때 this는 new로 새로 만들어진 listener 객체를 가르킨다.
                    //outer class를 지칭하고자 하면 (outer class 객체이름).this 로 사용가능
                    Intent intent = new Intent(SignupActivity.this, MemoActivity.class);
                    startActivity(intent);
                }
            }
        };
        button.setOnClickListener(listener);
    }

    static boolean isEmptyOrWhiteSpace(String s) {
        if (s == null) return true;
        return s.trim().length() == 0;
    }
}