package lab1;

public class Keyword {

    char table[][] = new char[26][4];

    public Keyword(String key) {
        initTable(key);
    }

    public void initTable(String key) {

        char a = 'a';
        //char b = 'A';
        //String c = "";
        for (int i = 0; i < table.length; i++) {
            table[i][0] = a;
            table[i][2] = (char) (a - 32);
            a++;
            //b++;
            //c=table[i][1];
            //table[i][3]=(char)(c-32);
        }
        table[0][1] = key.charAt(0);
        table[0][3] = (char) (key.charAt(0) - 32);
        int k = 1;
        //int n = 1;
        for (int j = 1; j < key.length(); j++) {
            if (!check(k, key.charAt(j))) {
                continue;
            } else {
                table[k][1] = key.charAt(j);
                table[k][3] = (char) (key.charAt(j) - 32);
                //n++;
                k++;

            }
        }
        //System.out.print(table[b][0] + "\n");
        for (int i = 0; i < table.length; i++) {
            if (!check(k, table[i][0])) {
                continue;
            } else {
                table[k][1] = table[i][0];
                table[k][3] = (char) (table[i][0] - 32);
                //n++;
                k++;
            }
        }
        //c = c.toUpperCase();
        /*for (int i = 0; i < table.length; i++) {
         table[i][3] = c.charAt(i);
         }*/
        System.out.print("-------------------------------------------------------------------------------------------------------------------------------------------\n");
        System.out.print("          Small Letters          // ");
        // print small alphabet
        for (int i = 0; i < table.length; i++) {
            System.out.print(table[i][0] + " | ");
        }
        System.out.print("\n-------------------------------------------------------------------------------------------------------------------------------------------\n");
        System.out.print("Small Keyword And Other Letters  // ");
        // print small keyword and other alphabet
        for (int i = 0; i < table.length; i++) {
            System.out.print(table[i][1] + " | ");
        }
        System.out.print("\n-------------------------------------------------------------------------------------------------------------------------------------------\n");
        System.out.print("          Captel Letters         // ");
        // print captel alphabet
        for (int i = 0; i < table.length; i++) {
            System.out.print(table[i][2] + " | ");
        }
        System.out.print("\n-------------------------------------------------------------------------------------------------------------------------------------------\n");
        System.out.print("Captel Keyword And Other Letters // ");
        // print captel keyword and other alphabet
        for (int i = 0; i < table.length; i++) {
            System.out.print(table[i][3] + " | ");
        }
        System.out.print("\n-------------------------------------------------------------------------------------------------------------------------------------------\n\n");
        System.out.print("\nKeyword : " + key + " \n");
    }

    public void keyWord(String s) {
        System.out.print("Plaintext : " + s + "\n");
        char a[] = new char[s.length()];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < table.length; j++) {
                if ((s.charAt(i) == table[j][0])) {
                    a[i] = table[j][1];
                    break;
                } else if ((s.charAt(i) == table[j][2])) {
                    a[i] = table[j][3];
                    break;
                } else if ((!(s.charAt(i) >= 97 && s.charAt(i) <= 122)) && (!(s.charAt(i) >= 65 && s.charAt(i) <= 90))) {
                    a[i] = s.charAt(i);
                    break;
                }
            }
        }
        System.out.print("Ciphertext : ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
        }
        System.out.print("\n\n");
    }

    public boolean check(int k, char key) {
        boolean c = true;
        for (int i = 0; i < k; i++) {
            if (key == table[i][1]) {
                c = false;
                break;
            }
        }
        return c;
    }
}