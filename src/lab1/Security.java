package lab1;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class Security {

    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        String s="";
        menu();
        int ch = in.nextInt();
        System.out.print("\n");
        while (ch != 0) {
            s=JOptionPane.showInputDialog(null, "Ente your message","");
            switch (ch) {
                case 1:
                    System.out.print("-------------------\n");
                    System.out.print("<< CEASER CIPHER >>\n");
                    System.out.print("-------------------\n\n");
                    System.out.print("Enter The Key : ");
                    int key = in.nextInt();
                    Ceaser c = new Ceaser(key);
                    c.ceaser(s);
                    System.out.print("Plaintext : " + s + "\nCiphertext : " + c.getS() + "\n\n");
                    c.deCode(c.getS());
                    System.out.print("Plaintext : " + c.getV() +"\n");
                    break;
                case 2:
                    System.out.print("-------------------\n");
                    System.out.print("<< ATBASH CIPHER >>\n");
                    System.out.print("-------------------\n\n");
                    Atbash a = new Atbash();
                    a.adbash(s);
                    System.out.print("Plaintext : " + s + "\nCiphertext : " + a.getS() + "\n\n");
                    break;
                case 3:
                    System.out.print("--------------------\n");
                    System.out.print("<< KEYWORD CIPHER >>\n");
                    System.out.print("--------------------\n\n");
                    System.out.print("Enter The Keyword : ");
                    String keyword = in.next();
                    Keyword k = new Keyword(keyword);
                    k.keyWord(s);
                    break;
                case 4:
                    System.out.print("---------------------\n");
                    System.out.print("<< POLYBIUS CIPHER >>\n");
                    System.out.print("---------------------\n\n");
                    Polybius p = new Polybius();
                    p.poly(s);
                    System.out.print("Plaintext : " + s + "\nCiphertext : " + p.getN() + "\n\n");
                    break;
                case 5:
                    System.out.print("---------------------\n");
                    System.out.print("<< VIGENERE CIPHER >>\n");
                    System.out.print("---------------------\n\n");
                    System.out.print("Enter The Keyword : ");
                    keyword = in.next();
                    Vigenere v = new Vigenere();
                    System.out.print("Enter 1 To Use Beaufort Vigenere Cipher .\n");
                    System.out.print("Enter 2 To Use Outokey Vigenere Cipher .\n");
                    System.out.print("Enter The ch for VIGENERE CIPHER method : ");
                    int z = in.nextInt();
                    switch (z) {
                        case 1:
                            System.out.print("-----------------------\n");
                            System.out.print("<< Beaufort Vigenere >>\n");
                            System.out.print("-----------------------\n\n");
                            v.beaufort(s, keyword);
                            break;
                        case 2:
                            System.out.print("----------------------\n");
                            System.out.print("<< Outokey Vigenere >>\n");
                            System.out.print("----------------------\n\n");
                            v.outokey(s, keyword);
                            break;
                    }
                    v.print(v.table);
                    v.print(v.ks);
                    System.out.print("Keyword : " + keyword + "\n");
                    System.out.print("Plaintext : " + s + "\nCiphertext : " + v.n + "\n\n");
                    break;
                case 6:
                    System.out.print("---------------------\n");
                    System.out.print("<< PLAYFAIR CIPHER >>\n");
                    System.out.print("---------------------\n\n");
                    System.out.print("Enter The Keyword : ");
                    keyword = in.next();
                    Playfair p1 = new Playfair(keyword);
                    System.out.print("Keyword : " + keyword + "\n");
                    p1.playfair(s);
                    break;
                case 7:
                    System.out.print("------------------\n");
                    System.out.print("<< BIFID CIPHER >>\n");
                    System.out.print("------------------\n\n");
                    Bifid b = new Bifid();
                    b.bifid(s);
                    break;
                case 8:
                    System.out.print("-------------------\n");
                    System.out.print("<< TRIFID CIPHER >>\n");
                    System.out.print("-------------------\n\n");
                    Trifid t = new Trifid();
                    t.trifid(s);
                    break;
                case 9:
                    System.out.print("---------------------\n");
                    System.out.print("<< FOUR_SEQUARE CIPHER >>\n");
                    System.out.print("---------------------\n\n");
                    String keyword1 = "example";
                    String keyword2 = "keyword";
                    FourSequare f = new FourSequare(keyword1, keyword2);
                    if (s.length() % 2 != 0) {
                        s += "x";
                    }
                    f.fourSequare(s);

                    System.out.print("\nkeyword1 : " + keyword1 + "\n");
                    System.out.print("keyword2 : " + keyword2 + "\n");
                    System.out.print("Plaintext : " + s + "\nCiphertext : " + f.cipher + "\n\n");
                    break;
                case 10:
                    System.out.print("----------------------\n");
                    System.out.print("<< RAIL_FENCE CIPHER >>\n");
                    System.out.print("----------------------\n\n");
                    RailFence r = new RailFence();
                    System.out.print("Enter Rail : ");
                    int rail = in.nextInt();
                    r.railFence(s, rail);
                    break;
                case 11:
                    System.out.print("-------------------------\n");
                    System.out.print("<< REGULAR_CASE CIPHER >>\n");
                    System.out.print("-------------------------\n\n");
                    RegularCase r1 = new RegularCase();
                    keyword = "zebras";
                    r1.regularCase(s, keyword);
                    break;
                case 12:
                    System.out.print("---------------------------\n");
                    System.out.print("<< IRREGULAR_CASE CIPHER >>\n");
                    System.out.print("---------------------------\n\n");
                    IrregularCase r2 = new IrregularCase();
                    keyword = "zebras";
                    r2.irregularCase(s, keyword);
                    break;
                case 13:
                    System.out.print("-------------------------\n");
                    System.out.print("<< ONE_TIME_PAD CIPHER >>\n");
                    System.out.print("-------------------------\n\n");
                    OneTimePad otp = new OneTimePad();
                    otp.oneTimePad(s);
                    break;
                case 14:
                    System.out.print("---------------------\n");
                    System.out.print("<< TAP_CODE CIPHER >>\n");
                    System.out.print("---------------------\n\n");
                    TapCode tt=new TapCode();
                    tt.tapCode(s);
                    break;
                default:
                    System.out.println("Enter Between (0 - 14) !!\n\n");
            }
            menu();
            ch = in.nextInt();
            System.out.print("\n");
        }
        System.out.print("Thank You :)\n");
    }

    public static void menu() {
        System.out.print("Enter 1 To Use Ceaser Cipher .\n");
        System.out.print("Enter 2 To Use Atbash Cipher .\n");
        System.out.print("Enter 3 To Use Keyword Cipher .\n");
        System.out.print("Enter 4 To Use Polybius Cipher .\n");
        System.out.print("Enter 5 To Use Vigenere Cipher .\n");
        System.out.print("Enter 6 To Use Playfair Cipher .\n");
        System.out.print("Enter 7 To Use Bifid Cipher .\n");
        System.out.print("Enter 8 To Use Trifid Cipher .\n");
        System.out.print("Enter 9 To Use Four_Sequare Cipher .\n");
        System.out.print("Enter 10 To Use Rail_Fence Cipher .\n");
        System.out.print("Enter 11 To Use Regular_Case Cipher .\n");
        System.out.print("Enter 12 To Use Iregular_Case Cipher .\n");
        System.out.print("Enter 13 To Use One_Time_Pad Cipher .\n");
        System.out.print("Enter 14 To Use Tap_Code Cipher .\n\n");
        System.out.print("Enter 0 To Exit .\n\n");
        System.out.print("Enter The ch : ");
    }
}
