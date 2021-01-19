package lab1;

public class RailFence {

    char table[][];
    String cipher = "";

    public void railFence(String s, int rail) {
        int length;
        if (s.length() % rail == 0) {
            length = s.length() / rail;
        } else {
            length = s.length() / rail + 1;
        }
        table = new char[rail][length];
        int a = 0, c = 0;
        for (int i = 0; i < table[0].length; i++) {
            for (int j = 0; j < table.length; j++) {
                if (a < s.length()) {
                    table[j][i] = s.charAt(a);
                    a++;
                } else { //count the blank locations
                    c++;
                }
            }
        }
        //System.out.print(c+"\n");
        if (c != 0) {
            for (int i = rail - c; i < rail; i++) {
                table[i][table[0].length - 1] = (char) (65 + i);
            }
        }
        print(table);
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                cipher += table[i][j];
            }
        }
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
