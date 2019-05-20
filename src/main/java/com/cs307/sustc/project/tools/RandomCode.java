package com.cs307.sustc.project.tools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class RandomCode{
    private ArrayList<String> list;
    public String generate(int len){
        HashMap<Character,Integer> m=new HashMap<>();
        Random random= new Random(System.currentTimeMillis());
        StringBuffer sb=new StringBuffer();
        for (int i=0;i<len;i++){
            int tmp=(int)(random.nextInt(26));
            char ch= (char) (tmp+'a');
            while(m.containsKey(ch)) {
                tmp=(int)(random.nextInt(26));
                ch= (char) (tmp+'a');
            }
            sb.append(ch);
        }
        String s=sb.toString();
        return s;
    }
}
