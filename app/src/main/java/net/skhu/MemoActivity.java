package net.skhu;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.autofill.AutofillValue;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MemoActivity extends AppCompatActivity {
/*
1) 연습 문제 #1
    수정 화면의 경우에는, 메모장 화면이 열릴 때 수정할 제목과 본문이 채워져 있어야 한다.
    메모장이 처음 열릴 때 다음과 같은 내용이 채워져 있도록 수정하자.
    activity_memo.xml 파일을 수정하지 말고, MemoActivity.java를 수정해서 구현해야 한다.
2) 연습 문제 #2
    회원 가입 화면에서 저장 버튼을 클릭하면, 메모장 화면으로 바로 넘어가도록 구현하자.
*/

    static String title, content;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo);

        EditText editText_title = (EditText)findViewById(R.id.editText_title);
        editText_title.setText(title);
        EditText editText_content = (EditText)findViewById(R.id.editText_content);
        editText_content.setText(content);

        Button button = (Button)findViewById(R.id.btnSave);
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                title = editText_title.getText().toString();
                if (isEmptyOrWhiteSpace(title))
                    editText_title.setError("제목을 입력하세요.");

                content = editText_content.getText().toString();
                if (isEmptyOrWhiteSpace(content))
                    editText_content.setError("내용을 입력하세요.");

                // 메모 데이터를 서버에 전송하는 코드를 구현해야 함.

                String msg = "저장 성공: " + title;
                Toast.makeText(MemoActivity.this, msg, Toast.LENGTH_LONG).show();
            }
        };

        button.setOnClickListener(listener);

    }

    static boolean isEmptyOrWhiteSpace(String s) {
        if (s == null) return true;
        return s.toString().trim().length() == 0;
    }
}