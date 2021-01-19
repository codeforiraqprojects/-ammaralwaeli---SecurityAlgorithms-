package lab1;

public class Atbash {

    private String newS = "";

    public void adbash(String s) {
        int a[] = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 65 && s.charAt(i) <= 90) {
                a[i] = Math.abs(s.charAt(i) - 65 - 25);
                newS = newS + (char) (a[i] + 65);
            } else if (s.charAt(i) >= 97 && s.charAt(i) <= 122) {
                a[i] = Math.abs(s.charAt(i) - 97 - 25);
                newS = newS + (char) (a[i] + 97);
            } else {
                newS = newS + s.charAt(i);
            }
        }
    }

    public String getS() {
        return newS;
    }
}
