package lab1;

public class Trifid {

    char Layer0[][] = new char[3][3];
    char Layer1[][] = new char[3][3];
    char Layer2[][] = new char[3][3];
    String p = "";

    public Trifid() {
        initLayers();
    }

    public void initLayers() {
        char a = 'a';
        char b = (char) (a + 9);
        char c = (char) (b + 9);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Layer0[i][j] = a;
                a++;
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Layer1[i][j] = b;
                b++;
            }
        }
        int x=0,y=0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (c <= 122) {
                    Layer2[i][j] = c;
                    x=i;
                    y=j;
                    c++;
                }
            }
        }
        Layer2[x][y+1]='#';
        System.out.print("Layer0           Layer1           Layer2\n");
        print(Layer0, Layer1, Layer2);
    }

    public void trifid(String s) {
        int a[] = getDim(s);
        for (int i = 0; i < a.length; i += 3) {
            if (a[i] == 0) {
                p += Layer0[a[i + 2]][a[i + 1]];
            } else if (a[i] == 1) {
                p += Layer1[a[i + 2]][a[i + 1]];
            } else {
                p += Layer2[a[i + 2]][a[i + 1]];
            }
        }
        System.out.print("Ciphertext : "+p + "\n\n");
    }

    public int[] getDim(String s) {
        int a[] = new int[s.length()];
        int b[] = new int[s.length()];
        int c[] = new int[s.length()];
        int x[] = new int[s.length() * 3];
        for (int k = 0; k < s.length(); k++) {
            if (s.charAt(k) >= 'a' && s.charAt(k) <= 'i') {
                a[k] = 0;
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (s.charAt(k) == Layer0[i][j]) {
                            b[k] = j;
                            c[k] = i;
                            break;
                        }
                    }
                }
            } else if (s.charAt(k) >= 'j' && s.charAt(k) <= 'r') {
                a[k] = 1;
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (s.charAt(k) == Layer1[i][j]) {
                            b[k] = j;
                            c[k] = i;
                            break;
                        }
                    }
                }
            } else if (s.charAt(k) >= 's' && s.charAt(k) <= 'z') {
                a[k] = 2;
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (s.charAt(k) == Layer2[i][j]) {
                            b[k] = j;
                            c[k] = i;
                            break;
                        }
                    }
                }
            }
        }
        int counter = 0;
        System.out.print("Plaintext : "+s+"\n");
        for (int i = 0; i < s.length(); i++) {
            System.out.print(s.charAt(i) + " ");
        }
        System.out.print("\n");
        for (int i = 0; i < a.length; i++) {
            System.out.print((a[i]) + " ");
            x[i] = a[i];
            counter++;
        }
        System.out.print("\n");
        for (int i = 0; i < b.length; i++) {
            System.out.print((b[i]) + " ");
            x[counter] = b[i];
            counter++;
        }
        System.out.print("\n");
        for (int i = 0; i < c.length; i++) {
            System.out.print((c[i]) + " ");
            x[counter] = c[i];
            counter++;
        }
        System.out.print("\n\n");
        return x;
    }

    public void print(char a[][],char b[][], char c[][]) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + "  ");
            }
            System.out.print("   |    ");
            for (int j = 0; j < b[i].length; j++) {
                System.out.print(b[i][j] + "  ");
            }
            System.out.print("   |    ");
            for (int j = 0; j < c[i].length; j++) {
                System.out.print(c[i][j] + "  ");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }
}
