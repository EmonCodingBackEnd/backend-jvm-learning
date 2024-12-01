package com.coding.jvm06.string;

public class StringIntern1 {

    public static void main(String[] args) {
        String s3 = new String("1") + new String("1");
        String s4 = "11";
        String s5 = s3.intern();
        System.out.println(s3 == s4); // jdk1.6及jdk1.7+:false
        System.out.println(s5 == s4); // jdk1.6及jdk1.7+:true
        System.out.println(s5 == s3); // jdk1.6及jdk1.7+:false
    }
}
