package lab1;

public class Bifid {

    char table[][] = new char[5][5];
    String p = "";

    public Bifid() {
        initTable();
    }

    public void bifid(String s) {
        int a[] = getDim(s);
        for (int i = 0; i < a.length; i += 2) {
            p += table[a[i]][a[i + 1]];
        }
        System.out.print("Ciphertext : " + p + "\n\n");
    }

    public int[] getDim(String s) {
        int x[] = new int[s.length()];
        int y[] = new int[s.length()];
        int a[] = new int[s.length() * 2];
        for (int k = 0; k < s.length(); k++) {
            for (int i = 0; i < table.length; i++) {
                for (int j = 0; j < table[i].length; j++) {
                    if (s.charAt(k) == table[i][j]) {
                        x[k] = i;
                        y[k] = j;
                    }
                }
            }
        }
        int b = 0;
        System.out.print("Plaintext : " + s + "\n");
        for (int i = 0; i < x.length; i++) {
            System.out.print((x[i] + 1));
            a[i] = x[i];
            b = i;
        }
        System.out.print("\n");
        for (int i = 0; i < y.length; i++) {
            System.out.print((y[i] + 1));
            a[b + 1] = y[i];
            b++;
        }
        System.out.print("\n");
        /*for (int i = 0; i < a.length; i++) {
         System.out.print(a[i] + "  ");
         }*/
        //System.out.print("\n");
        return a;
    }

    public void initTable() {
        int a = 'a';
        for (char[] table1 : table) {
            for (int j = 0; j < table1.length; j++) {
                if (a == 'j') {
                    a++;
                }
                table1[j] = (char) a;
                a++;
            }
        }
        print(table);
    }

    public void print(char a[][]) {
        for (char[] a1 : a) {
            for (int j = 0; j < a1.length; j++) {
                System.out.print(a1[j] + "  ");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }
}
