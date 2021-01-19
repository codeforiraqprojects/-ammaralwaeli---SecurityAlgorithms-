package lab1;

public class Polybius {

    char a[][] = new char[6][5];
    char A[][] = new char[6][5];
    private String n = "";

    public Polybius() {
        initMatrix(a, 'a');
        initMatrix(A, 'A');
    }

    public void initMatrix(char a[][], char a1) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if ((a1 >= 65 && a1 <= 90) || (a1 >= 97 && a1 <= 122)) {
                    a[i][j] = a1;
                    a1++;
                }
            }
        }
        print(a);
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

    public void poly(String s) {
        //int x=0,y=0;
        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) >= 65 && s.charAt(i) <= 90) || (s.charAt(i) >= 97 && s.charAt(i) <= 122)) {
                n += check(s.charAt(i));
            } else {
                n += s.charAt(i);
            }
        }
    }

    public String check(char c) {
        int x = 0, y = 0;
        String S = "";
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (c == a[i][j]) {
                    x = i;
                    y = j;
                    break;
                } else if (c == A[i][j]) {
                    x = i;
                    y = j;
                    break;
                }
            }
            if (c == a[x][y]) {
                break;
            } else if (c == A[x][y]) {
                break;
            }
        }
        S += String.valueOf(x);
        S += String.valueOf(y);
        return S;
    }

    public String getN() {
        return n;
    }
}
