package lab1;

public class FourSequare {

    char table[][] = new char[10][10];
    char key1[][] = new char[5][5];
    char key2[][] = new char[5][5];
    char alpha[][] = new char[5][5];
    char[] testTable = new char[key1.length * key2.length];
    String r = "abcdefghiklmnopqrstuvwxyz";
    String cipher = "";

    public FourSequare(String key11, String key22) {
        initTable(key11, key22);
    }

    public void fourSequare(String s) {
        String s1[] = devid2(s);
        char c1, c2;
        int ij1[] = new int[2], ij2[] = new int[2];
        for (int k = 0; k < s1.length; k++) {
            c1 = s1[k].charAt(0);
            c2 = s1[k].charAt(1);
            //System.out.print("\nc1 = " + c1 + "\nc2 = " + c2 + "\n");
            for (int i = 0; i < alpha.length; i++) {
                for (int j = 0; j < alpha[i].length; j++) {
                    if (c1 == table[i][j]) {
                        ij1[0] = i;
                        ij1[1] = j;
                    }
                    if (c2 == table[i + alpha.length][j + alpha.length]) {
                        ij2[0] = i + alpha.length;
                        ij2[1] = j + alpha.length;
                    }
                }
            }
            //System.out.print("the index of " + table[ij1[0]][ij1[1]] + " = [" + ij1[0] + "][" + ij1[1] + "]\n");
            //System.out.print("the index of " + table[ij2[0]][ij2[1]] + " = [" + ij2[0] + "][" + ij2[1] + "]\n");
            int t = ij1[1];
            ij1[1] = ij2[1];
            ij2[1] = t;
            //System.out.print("the complement index of " + table[ij1[0]][ij1[1]] + " = [" + ij1[0] + "][" + ij1[1] + "]\n");
            //System.out.print("the complement index of " + table[ij2[0]][ij2[1]] + " = [" + ij2[0] + "][" + ij2[1] + "]\n");
            cipher += table[ij1[0]][ij1[1]] + "" + table[ij2[0]][ij2[1]];
        }
    }

    public String[] devid2(String s) {
        String x[] = new String[s.length() / 2];
        int c = 0;
        s = s.replace('j', 'i');
        for (int i = 0; i < x.length; i++) {
            x[i] = s.substring(c, c + 2);
            System.out.print(x[i] + " ");
            c = c + 2;
        }
        return x;
    }

    public void initTable(String key11, String key22) {
        initAlpha();
        initKey(key11, key1);
        initKey(key22, key2);
        for (int i = 0; i < key1.length; i++) {
            for (int j = 0; j < key1.length; j++) {
                table[i][j] = alpha[i][j];
                table[i][j + key1.length] = key1[i][j];
                table[i + key2.length][j] = key2[i][j];
                table[i + alpha.length][j + alpha.length] = alpha[i][j];
            }
        }
        print(table);
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

    public void initKey(String key, char keyy[][]) {
        //System.out.print("your key is ( " + key + " )\n\n");
        testTable[0] = key.charAt(0);
        int k = 1;
        for (int j = 1; j < key.length(); j++) {
            if ((!check(k, key.charAt(j)))) {
                continue;
            } else {
                if (key.charAt(j) == 'j') {
                    continue;
                } else {
                    testTable[k] = key.charAt(j);
                    k++;
                }
            }
        }
        for (int i = 0; i < r.length(); i++) {
            if (!check(k, r.charAt(i))) {
                continue;
            } else {
                testTable[k] = r.charAt(i);
                k++;
            }
        }
        int a = 0;
        for (int i = 0; i < keyy.length; i++) {
            for (int j = 0; j < keyy.length; j++) {
                keyy[i][j] = testTable[a];
                a++;
            }
        }
        //print(table);
    }

    public void initAlpha() {
        int a = 'a';
        for (int i = 0; i < alpha.length; i++) {
            for (int j = 0; j < alpha[i].length; j++) {
                if (a == 'j') {
                    a++;
                }
                alpha[i][j] = (char) a;
                a++;
            }
        }
        //print(table);
    }
    
    public void print(char a[][]) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (j == key1.length - 1) {
                    System.out.print(a[i][j] + "   |   ");
                } else {
                    System.out.print(a[i][j] + "    ");
                }
            }
            System.out.print("\n");
            if (i == key1.length - 1) {
                for (int j = 0; j < a.length; j++) {
                    System.out.print("-----");
                }
                System.out.print("\b");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }
}
