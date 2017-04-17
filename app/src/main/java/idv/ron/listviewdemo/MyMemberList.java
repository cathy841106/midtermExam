package idv.ron.listviewdemo;

import java.util.ArrayList;
import java.util.List;

public class MyMemberList {

    public static List<Member> memberlist;

    public static List<Member> getMemberList() {return memberlist; };

    public static void createOriginMemberlist() {
        memberlist = new ArrayList<>();

        if(memberlist.size()==0) {

            memberlist.add(new Member(1,"張三",20,"男","資管"));
            memberlist.add(new Member(2,"李四",22,"男","資工"));
            memberlist.add(new Member(3,"瑪麗",18,"女","企管"));


        }
    }
}
