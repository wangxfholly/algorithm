package org.learn.str;

public class ContainsTest {
    public static void main(String[] args) {
        String str = "abc";
        String sub = null;
        System.out.println(str.equals(sub));
        System.out.println(str.hashCode() == sub.hashCode());
    }
}
