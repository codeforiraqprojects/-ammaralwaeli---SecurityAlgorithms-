package lab1;

import java.util.Arrays;

public class IrregularCase {

    char table[][];
    String cipher = "";

    public void irregularCase(String s, String key) {
        int cc[] = new int[key.length()];
        int cs[] = new int[key.length()];
        for (int i = 0; i < cc.length; i++) {
            cc[i] = (int) (key.charAt(i));
            cs[i] = (int) (key.charAt(i));
        }
        Arrays.sort(cs);
        for (int i = 0; i < cs.length; i++) {
            for (int j = 0; j < cs.length; j++) {
                if (cs[i] == cc[j]) {
                    cc[j] = i;
                }
            }
        }
        int length = (int) (Math.ceil(s.length() / (double) key.length()));
        table = new char[length][key.length()];
        int a = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < key.length(); j++) {
                if (a < s.length()) {
                    table[i][j] = s.charAt(a);
                    a++;
                }
            }
        }
        for (int i = 0; i < cc.length; i++) {
            System.out.print(cc[i] + "  ");
        }
        System.out.print("\n\n");
        print(table);
        int col = 0;
        for (int i = 0; i < table[0].length; i++) {
            for (int k = 0; k < cc.length; k++) {
                if (cc[k] == i) {
                    col = k;
                    break;
                }
            }
            for (int j = 0; j < table.length; j++) {
                if (table[j][col] >= 97 && table[j][col] <= 122) {
                    cipher += table[j][col];
                }
            }
            cipher += " ";
        }
        System.out.print("Keyword : "+key+"\n");
        System.out.print("Plaintext : "+s + "\nCiphertext : " + cipher + "\n\n");
    }

    public void print(char a[][]) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + "  ");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }
}
