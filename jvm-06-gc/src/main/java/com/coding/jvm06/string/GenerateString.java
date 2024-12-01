package com.coding.jvm06.string;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * 产生10万个长度不超过10的字符串，包含a-z,A-Z
 */
public class GenerateString {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("words.txt");
        try {
            Random random = new Random();
            for (int i = 0; i < 100000; i++) {
                int length = random.nextInt(10) + 1;
                fw.write(getString(length) + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            fw.close();
        }
    }

    public static String getString(int length) {
        String str = "";
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            // 65 - 90 26个大写字母编码, 97 - 122 大小写字母相差32
            int num = random.nextInt(26) + 65;
            num += random.nextInt(2) * 32;
            str += (char) num;
        }
        return str;
    }
}
