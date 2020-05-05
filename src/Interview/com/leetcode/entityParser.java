package com.leetcode;


/**
 * 「1410、HTML 实体解析器」 是一种特殊的解析器，它将 HTML 代码作为输入，并用字符本身替换掉所有这些特殊的字符实体。
 *
 * HTML 里这些特殊字符和它们对应的字符实体包括：
 *
 */
public class entityParser {
    public static void main(String[] args) {
        long l = System.nanoTime();
        String text = "&amp; is an HTML entity but &ambassador; is not.";

        System.out.println(text.replace("&quot", "”").replace("&apos", "‘").replace("&amp;", "&").replace("&gt", ">").replace("&lt", "<").replace("&frasl", "/"));
        System.out.println((System.nanoTime() - l)/1000_0000);


    }
}

