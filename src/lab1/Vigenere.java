package lab1;

public class Vigenere {

    char table[][] = new char[26][26];
    char ks[][];
    String n = "";

    public void initTablesBeaufort(String s, String key) {
        Ceaser c;
        String a = "abcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < table.length; i++) {
            c = new Ceaser(i);
            c.ceaser(a);
            for (int j = 0; j < table[i].length; j++) {
                table[i][j] = c.getS().charAt(j);
            }
        }
        ks = new char[2][s.length()];
        int x = 0;
        for (int i = 0; i < s.length(); i++) {
            //if ((s.charAt(i) >= 65 && s.charAt(i) <= 90) || (s.charAt(i) >= 97 && s.charAt(i) <= 122)) {
            ks[0][i] = s.charAt(i);
            if ((s.charAt(i) >= 65 && s.charAt(i) <= 90) || (s.charAt(i) >= 97 && s.charAt(i) <= 122)) {
                ks[1][i] = key.charAt(x % key.length());
                x++;
            }
        }
    }

    public void initTablesOutoKey(String s, String key) {
        Ceaser c;
        String a = "abcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < table.length; i++) {
            c = new Ceaser(i);
            c.ceaser(a);
            for (int j = 0; j < table[i].length; j++) {
                table[i][j] = c.getS().charAt(j);
            }
        }
        ks = new char[2][s.length()];
        int x = 0, y = 0;
        for (int i = 0; i < s.length(); i++) {
            //if ((s.charAt(i) >= 65 && s.charAt(i) <= 90) || (s.charAt(i) >= 97 && s.charAt(i) <= 122)) {
            ks[0][i] = s.charAt(i);
            if ((x < key.length())) {
                ks[1][i] = key.charAt(x);
                x++;
            } else {
                ks[1][i] = s.charAt(y);
                y++;
            }
        }
        
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

    public void beaufort(String s, String key) {
        initTablesBeaufort(s, key);
        int x = 0, y = 0;
        for (int i = 0; i < ks[0].length; i++) {
            if ((ks[0][i] >= 65 && ks[0][i] <= 90)) {
                x = (int) (ks[0][i] - 65);
                y = (int) (ks[1][i] - 97);
                n += table[x][y];
            } else if ((ks[0][i] >= 97 && ks[0][i] <= 122)) {
                x = (int) (ks[0][i] - 97);
                y = (int) (ks[1][i] - 97);
                n += table[x][y];
            } else {
                n += ks[0][i];
            }
        }
    }

    public void outokey(String s, String key) {
        initTablesOutoKey(s, key);
        int x = 0, y = 0;
        for (int i = 0; i < ks[0].length; i++) {
            if ((ks[0][i] >= 65 && ks[0][i] <= 90)) {
                x = (int) (ks[0][i] - 65);
                y = (int) (ks[1][i] - 65);
                n += table[x][y];
            } else if ((ks[0][i] >= 97 && ks[0][i] <= 122)) {
                x = (int) (ks[0][i] - 97);
                y = (int) (ks[1][i] - 97);
                n += table[x][y];
            } else {
                n += ks[0][i];
            }
        }
    }
}
