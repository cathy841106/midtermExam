package idv.ron.listviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

public class ResultActivity extends AppCompatActivity{

    private TextView tvItName;
    private TextView tvItAge;
    private TextView tvItSex;
    private TextView tvItMajor;
    private Button btBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_activity);
        tvItName = (TextView) findViewById(R.id.tvItName);
        tvItAge = (TextView) findViewById(R.id.tvItAge);
        tvItSex = (TextView) findViewById(R.id.tvItSex);
        tvItMajor = (TextView) findViewById(R.id.tvItMajor);
        btBack = (Button) findViewById(R.id.btBack);
        showResults();
    }

    private void showResults() {

        Bundle bundle = getIntent().getExtras();
        int whichOne = bundle.getInt("whichOne");

        Member theMember = MyMemberList.getMemberList().get(whichOne);

        tvItName.setText("姓名:"+" "+theMember.getName()) ;
        tvItAge.setText("年齡:"+" "+Integer.toString(theMember.getAge())) ;
        tvItSex.setText("性別:"+" "+theMember.getSex()) ;
        tvItMajor.setText("科系:"+" "+theMember.getMajor()) ;


    }

    public void onBackClick(View view) {
        finish();
    }

}
