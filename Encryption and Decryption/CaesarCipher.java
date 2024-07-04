import java.util.Scanner;

public class CaesarCipher {

   
    public static String encrypt(String text, int shift) {
        StringBuilder encryptedText = new StringBuilder();
        int shiftAmount = shift % 26;

        for (char ch : text.toCharArray()) {
            if (Character.isLetter(ch)) {
                char base = Character.isLowerCase(ch) ? 'a' : 'A';
                char newChar = (char) (((ch - base + shiftAmount) % 26) + base);
                encryptedText.append(newChar);
            } else {
                encryptedText.append(ch);
            }
        }
        return encryptedText.toString();
    }

  
    public static String decrypt(String text, int shift) {
        return encrypt(text, -shift); // Decrypt by shifting in reverse
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.print("Do you want to (E)ncrypt or (D)ecrypt a message? (E/D): ");
                String choice = scanner.nextLine().toUpperCase();

                if (choice.equals("E") || choice.equals("D")) {
                    System.out.print("Enter your message: ");
                    String message = scanner.nextLine();
                    System.out.print("Enter the shift value: ");
                    int shift = scanner.nextInt();
                    scanner.nextLine(); 

                    if (choice.equals("E")) {
                        System.out.println("Encrypted message: " + encrypt(message, shift));
                    } else {
                        System.out.println("Decrypted message: " + decrypt(message, shift));
                    }
                } else {
                    System.out.println("Invalid choice. Please enter 'E' to encrypt or 'D' to decrypt.");
                }

                System.out.print("Do you want to encrypt/decrypt another message? (Y/N): ");
                String another = scanner.nextLine().toUpperCase();
                if (!another.equals("Y")) {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}