package lab1;

public class Playfair {

    char table[][] = new char[5][5];
    char testTable[] = new char[table.length * table.length];
    private String p = "";

    public Playfair(String key) {
        initTable(key);
    }

    public void initTable(String key) {
        testTable[0] = key.charAt(0);
        int k = 1;
        for (int j = 1; j < key.length(); j++) {
            if ((!check(k, key.charAt(j)))) {
                continue;
            } else {
                if (key.charAt(j) == 'q') {
                    continue;
                } else {
                    testTable[k] = key.charAt(j);
                    k++;
                }
            }
        }
        String r = "abcdefghijklmnoprstuvwxyz";
        for (int i = 0; i < r.length(); i++) {
            if (!check(k, r.charAt(i))) {
                continue;
            } else {
                testTable[k] = r.charAt(i);
                k++;
            }
        }
        int a = 0;
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                table[i][j] = testTable[a];
                a++;
            }
        }
        print(table);
    }

    public void playfair(String s) {
        String g = insertX(s);
        String s1[] = devid2(g);
        int ij1[] = new int[2];
        int ij2[] = new int[2];
        //System.out.print("\n");
        for (int k = 0; k < s1.length; k++) {
            for (int i = 0; i < table.length; i++) {
                for (int j = 0; j < table[i].length; j++) {
                    if (s1[k].charAt(0) == table[i][j]) {
                        ij1[0] = i;
                        ij1[1] = j;
                    }
                    if (s1[k].charAt(1) == table[i][j]) {
                        ij2[0] = i;
                        ij2[1] = j;
                    }
                }
            }
            if (ij1[0] == ij2[0]) {
                if (ij1[1] == table.length - 1) {
                    ij1[1] = 0;
                } else {
                    ij1[1]++;
                }
                if (ij2[1] == table.length - 1) {
                    ij2[1] = 0;
                } else {
                    ij2[1]++;
                }
            } else if (ij1[1] == ij2[1]) {
                if (ij1[0] == table.length - 1) {
                    ij1[0] = 0;
                } else {
                    ij1[0]++;
                }
                if (ij2[0] == table.length - 1) {
                    ij2[0] = 0;
                } else {
                    ij2[0]++;
                }
            } else {
                int t = ij1[1];
                ij1[1] = ij2[1];
                ij2[1] = t;
            }
            p += table[ij1[0]][ij1[1]] + "" + table[ij2[0]][ij2[1]];
        }
        System.out.print("Plaintext : " + g + "\nCiphertext : " + p + "\n\n");
    }

    public String insertX(String s) {
        String text = s.replace('j', 'i');
        if (text.length() % 2 != 0) {
            text += "x";
        }
        //int len = text.length();
        for (int i = 0; i < s.length(); i += 2) {
            if (text.charAt(i + 1) == text.charAt(i)) {
                text = text.substring(0, i + 1) + "x" + text.substring(i + 1);
            }
        }
        return text;
    }

    public String[] devid2(String s) {
        String x[] = new String[s.length() / 2];
        int c = 0;
        for (int i = 0; i < x.length; i++) {
            x[i] = s.substring(c, c + 2);
            //System.out.print(x[i] + " ");
            c = c + 2;
        }
        return x;
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

    public boolean check(int k, char key) {
        boolean c = true;
        for (int i = 0; i < k; i++) {
            if (key == testTable[i]) {
                c = false;
                break;
            }
        }
        return c;
    }
}
