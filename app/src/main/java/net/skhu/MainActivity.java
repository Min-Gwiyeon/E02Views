package net.skhu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    static final String TAG = "내태그";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG,"onCreate");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        Log.d(TAG,"onCreateOptionsMenu");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if( id == R.id.action_signUp){
            //Toast.makeText(MainActivity.this, "회원가입 메뉴 클릭", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, SignupActivity.class); //메타클래스(클래스나 객체 정보를 담은 클래스) 클래스일경우 클래스이름.class;, 객체일경우 객체이름.getClass();
            startActivity(intent);
            Log.d(TAG,"signUp");
            return true;
        } else if ( id == R.id.action_memo) {
            //Toast.makeText(this, "메모장 메뉴 클릭", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, MemoActivity.class);
            startActivity(intent);
            Log.d(TAG,"memo");
            return true;
        } else if (id == R.id.action_buttons){
            Intent intent = new Intent(this, ButtonsActivity.class);
            startActivity(intent);
            Log.d(TAG,"buttons");
            return true;
        }else if (id == R.id.action_checkboxes){
            Intent intent = new Intent(this, CheckboxesActivity.class);
            startActivity(intent);
            Log.d(TAG,"checkboxes");
            return true;
        }else if (id == R.id.action_spinners){
            Intent intent = new Intent(this, SpinnersActivity.class);
            startActivity(intent);
            Log.d(TAG,"spinners");
            return true;
        }
        Log.d(TAG,"selected close");
        return super.onOptionsItemSelected(item);

    }
}