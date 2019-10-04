package com.example.ch13_practice_13_32_4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText name,phone,email;
    TextView txv;
    Button btn;
    String key;
    String key2;
    String key3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=findViewById(R.id.editText);
        phone=findViewById(R.id.editText2);
        email = findViewById(R.id.editText3);
        txv=findViewById(R.id.show);
        btn=findViewById(R.id.btn);

    }

    public  void confirm(View v){
        key=name.getText().toString();
        key2=phone.getText().toString();
        key3=email.getText().toString();
        if(key.length()==0 || key2.length()==0|| key3.length()==0) {
            Toast toast = Toast.makeText(MainActivity.this, "欄位不能是空白!!", Toast.LENGTH_SHORT);
            toast.show();
        }
        else {
            txv.setText(key + "\n" + key2 + "\n" + key3);
        }
    }

    @Override
    public void onPause(){
        super.onPause();
        SharedPreferences.Editor editor=getPreferences(MODE_PRIVATE).edit();

        editor.putString("AAA",key);
        editor.putString("紀錄2",key2);
        editor.putString("紀錄3",key3);
        editor.commit();
    }

    @Override
    public void onResume(){
        super.onResume();
        SharedPreferences showme=getPreferences(MODE_PRIVATE);
        key=showme.getString("AAA","還敢");
        key2=showme.getString("紀錄2","下來啊");
        key3=showme.getString("紀錄3","冰鳥");

        txv.setText(key + "\n" + key2 +"\n"+key3 );
    }
}
