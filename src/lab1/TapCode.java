package lab1;

public class TapCode {

    char table[][] = new char[5][5];
    String cipher[];

    public TapCode() {
        initTable();
    }

    public void initTable() {
        int a = 'a';
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                if (a == 'j') {
                    a++;
                    j--;
                    continue;
                } else {
                    table[i][j] = (char) a;
                    a++;
                }
            }
        }
        print(table);
    }

    public void tapCode(String s) {
        int x[] = new int[s.length()], y[] = new int[s.length()];
        boolean cc = false;
        cipher = new String[s.length() * 2];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'j') {
                cc = true;
            }
        }
        System.out.print(s + "\n");
        if (cc) {
            s = s.replace('j', 'i');
            cc = false;
            System.out.print(s + "\n");
        }
        //System.out.print(cipher.length+"\n");
        for (int k = 0; k < s.length(); k++) {
            for (int i = 0; i < table.length; i++) {
                for (int j = 0; j < table[i].length; j++) {
                    if (s.charAt(k) == table[i][j]) {
                        x[k] = i + 1;
                        y[k] = j + 1;
                        cc = true;
                        break;
                    }
                }
                if (cc) {
                    cc = false;
                    break;
                }
            }
        }
        for (int i = 0; i < x.length; i++) {
            cipher[i] = "";
            for (int j = 0; j < x[i]; j++) {
                cipher[i] += ".";
            }
        }
        for (int i = 0; i < y.length; i++) {
            cipher[i + 3] = "";
            for (int j = 0; j < y[i]; j++) {
                cipher[i + 3] += ".";
            }
        }
        for (int i = 0, j = 3; i < cipher.length / 2; i++, j++) {
            System.out.print("[" + cipher[i] + " " + cipher[j] + "]   ");
        }
        System.out.print("\n");
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
