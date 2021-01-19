package lab1;

public class Ceaser {

    int key;
    private String newS = "", v = "";

    public Ceaser(int k) {
        key = k;
    }

    public void ceaser(String s) {
        int a[] = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 65 && s.charAt(i) <= 90) {
                a[i] = (s.charAt(i) - 65 + key) % 26;
                newS = newS + (char) (a[i] + 65);
            } else if (s.charAt(i) >= 97 && s.charAt(i) <= 122) {
                a[i] = (s.charAt(i) - 97 + key) % 26;
                newS = newS + (char) (a[i] + 97);
            } else {
                newS = newS + s.charAt(i);
            }
        }
    }

    public void deCode(String s) {
        int a[] = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 65 && s.charAt(i) <= 90) {
                a[i] = (s.charAt(i) + 65 - key) % 26;
                v = v + (char) (a[i] + 65);
            } else if (s.charAt(i) >= 97 && s.charAt(i) <= 122) {
                a[i] = (s.charAt(i) + 97 - 6) % 26;
                v = v + (char) (a[i] + 97);
            } else {
                v = v + s.charAt(i);
            }
        }
    }

    public String getS() {
        return newS;
    }

    public String getV() {
        return v;
    }
}
