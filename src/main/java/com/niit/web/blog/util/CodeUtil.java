package com.niit.web.blog.util;

import java.util.Random;

public class CodeUtil {
    public static String getRandomCode(){
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i=0;i<4;i++){
            int temp = random.nextInt(26) + 97;
            String s = String.valueOf((char) temp);
            sb.append(s);
        }
        return String.valueOf(sb);
    }

    public static void main(String[] args) {
        System.out.println(getRandomCode());
    }
}
