package lab1;

public class OneTimePad {

    String cipher = "";

    public char[] getRandomLetters(int length) {
        char a[] = new char[length];
        for (int i = 0; i < a.length; i++) {
            do {
                a[i] = (char) (Math.random() * 122);
            } while (!isLetter(a[i]));
        }
        return a;
    }

    public boolean isLetter(char a) {
        return (a >= 97 && a <= 122);
    }

    public void oneTimePad(String s) {
        char random[] = getRandomLetters(s.length());
        int a, c;
        System.out.print("Plaintext    : " + s + "\nOne-Time-Pad : ");
        for (int i = 0; i < random.length; i++) {
            if (s.charAt(i) != ' ') {
                System.out.print(random[i]);
            } else {
                System.out.print(" ");
            }
            a = s.charAt(i);
            if (s.charAt(i) >= 65 && s.charAt(i) <= 90) {
                a -= 65;
                random[i] -= 97;
                c = (a + random[i]) % 25;
                a = c + 65;
                cipher += (char) a;
            } else if (s.charAt(i) >= 97 && s.charAt(i) <= 122) {
                a -= 97;
                random[i] -= 97;
                c = (a + random[i]) % 25;
                a = c + 97;
                cipher += (char) a;
            } else {
                cipher += s.charAt(i);
            }
        }
        System.out.print("\nCiphertext   : " + cipher + "\n\n");
    }
}
