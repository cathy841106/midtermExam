package idv.ron.listviewdemo;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.os.Bundle;
import android.content.Intent;
import java.util.ArrayList;
import java.util.List;

//建構子
public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);     //設定layout
        ListView lvMember = (ListView) findViewById(R.id.lvMember);     //指定物件id給變數
        lvMember.setAdapter(new MemberAdapter(this));         //設定adapter給listview

        //註冊事件給listview
        lvMember.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                /*Member member = (Member) parent.getItemAtPosition(position);  //抓點選選項的物件
                               String text = "ID = " + member.getID() + ", name = " + member.getName();
                             Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();   //設定彈出toast顯示的文字  */

                int whichOne = position;

                Intent intent = new Intent(view.getContext(), ResultActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("whichOne",whichOne);

                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

    }

    //宣告listview使用的adapter
    private class MemberAdapter extends BaseAdapter {
        private LayoutInflater layoutInflater;
        private List<Member> memberList;   //宣告儲存member物件的list

        public MemberAdapter(Context context) {

            layoutInflater = LayoutInflater.from(context);

            MyMemberList.createOriginMemberlist();
            memberList=MyMemberList.getMemberList();
        }

        @Override
        public int getCount() {
            return memberList.size();
        }

        @Override
        public Object getItem(int position) {
            return memberList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return memberList.get(position).getId();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            if (convertView == null) {
                convertView = layoutInflater.inflate(R.layout.listview_item, parent, false);
                if (position % 2 == 1)
                    convertView.setBackgroundColor(Color.LTGRAY);
                if (position % 2 == 0)
                    convertView.setBackgroundColor(Color.GRAY);
            }

            Member member = memberList.get(position);
            TextView tvName = (TextView) convertView.findViewById(R.id.tvName);
            tvName.setText(member.getName());

            TextView tvAge = (TextView) convertView.findViewById(R.id.tvAge);
            tvAge.setText(String.valueOf(member.getAge()));

            TextView tvSex = (TextView) convertView.findViewById(R.id.tvSex);
            tvSex.setText(member.getSex());

            TextView tvMajor = (TextView) convertView.findViewById(R.id.tvMajor);
            tvMajor.setText(member.getMajor());

            return convertView;
        }
    }

    public void onAddClick(View view) {

        Intent intent = new Intent(view.getContext(), AddActivity.class);
        startActivity(intent);

    }
}
