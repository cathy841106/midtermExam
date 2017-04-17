package idv.ron.listviewdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import java.util.List;

public class AddActivity extends AppCompatActivity{

    private TextView tvAdName;
    private TextView tvAdAge;
    private TextView tvAdSex;
    private TextView tvAdMajor;
    private EditText etAdName;
    private EditText etAdAge;
    private EditText etAdSex;
    private EditText etAdMajor;
    private Button btAdd;
    private Button btBack;
    private List<Member> memberList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_activity);
        tvAdName = (TextView) findViewById(R.id.tvAdName);
        tvAdAge = (TextView) findViewById(R.id.tvAdAge);
        tvAdSex = (TextView) findViewById(R.id.tvAdSex);
        tvAdMajor = (TextView) findViewById(R.id.tvAdMajor);
        etAdName = (EditText) findViewById(R.id.etAdName);
        etAdAge = (EditText) findViewById(R.id.etAdAge);
        etAdSex = (EditText) findViewById(R.id.etAdSex);
        etAdMajor = (EditText) findViewById(R.id.etAdMajor);
        btBack = (Button) findViewById(R.id.btBack);
        btAdd = (Button) findViewById(R.id.btAdd);

        memberList = MyMemberList.getMemberList();
    }

    private boolean isNameValid(EditText editText) {

        String pattern1 = "[\\u4e00-\\u9fa5]{1,4}";
        String text = editText.getText().toString();

        if (!text.matches(pattern1)) {
            editText.setError("請輸入最多四個中文字");   //顯示錯誤提示
            return false;
        } else {
            return true;
        }
    }

    private boolean isAgeValid(EditText editText) {

        String pattern2 = "[0-9]{1,3}";
        String text = editText.getText().toString();

        if (!text.matches(pattern2)) {
            editText.setError("最多三位正整數");   //顯示錯誤提示
            return false;
        } else {
            return true;
        }
    }

    private boolean isSexValid(EditText editText) {

        //String pattern3 = "1[0]{2}|[0-9]{1,2}";
        String text = editText.getText().toString();

        if (text.matches("男") || text.matches("女")) {
            return true;
        } else {
            editText.setError("只能輸入男或女");   //顯示錯誤提示
            return true;
        }
    }

    private boolean isMajorValid(EditText editText) {

        String pattern4 = "[\\u4e00-\\u9fa5]{1,6}";
        String text = editText.getText().toString();

        if (!text.matches(pattern4)) {
            editText.setError("請輸入最多六個中文字");   //顯示錯誤提示
            return false;
        } else {
            return true;
        }
    }



    public void onAddClick(View view) {

        boolean isValid = isNameValid(etAdName) & isAgeValid(etAdAge) & isSexValid(etAdSex) & isMajorValid(etAdMajor);
        if (!isValid) {
            return;
        }

        String name = etAdName.getText().toString();
        int age = Integer.parseInt(etAdAge.getText().toString());
        String sex = etAdSex.getText().toString();
        String major = etAdMajor.getText().toString();

        memberList.add(new Member((memberList.size()+1),name,age,sex,major));



    }
    public void onBackClick(View view) {
        finish();
    }
}

