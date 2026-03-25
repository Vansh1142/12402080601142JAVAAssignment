// Problem Statement:
// Cipher system using abstract class and method overriding

import java.util.Scanner;

// Abstract class defining the structure of a Cipher
abstract class Cipher {
    int key; // Encryption/Decryption key

    // Constructor to initialize the key
    Cipher(int key) {
        this.key = key;
    }

    // Abstract methods to be implemented by subclasses
    abstract String encrypt(String msg);
    abstract String decrypt(String msg);
}

// Caesar Cipher implementation (shifts letters by 'key')
class CaesarCipher extends Cipher {

    CaesarCipher(int key) {
        super(key); // Pass key to parent class
    }

    @Override
    String encrypt(String msg) {
        String res = "";
        for (int i = 0; i < msg.length(); i++) {
            char ch = msg.charAt(i);
            if (Character.isLetter(ch)) { // Only shift letters
                char base = Character.isUpperCase(ch) ? 'A' : 'a';
                res = res + (char) ((ch - base + key) % 26 + base);
            } else {
                res = res + ch; // Keep non-letters unchanged
            }
        }
        return res;
    }

    @Override
    String decrypt(String msg) {
        String res = "";
        for (int i = 0; i < msg.length(); i++) {
            char ch = msg.charAt(i);
            if (Character.isLetter(ch)) {
                char base = Character.isUpperCase(ch) ? 'A' : 'a';
                res = res + (char) ((ch - base - key + 26) % 26 + base);
            } else {
                res = res + ch;
            }
        }
        return res;
    }
}

// Reverse Cipher implementation (simply reverses the string)
class ReverseCipher extends Cipher {

    // Reverse cipher does not need a key, so pass 0
    ReverseCipher() {
        super(0);
    }

    @Override
    String encrypt(String msg) {
        String r = "";
        // Reverse the string
        for (int i = msg.length() - 1; i >= 0; i--) {
            r = r + msg.charAt(i);
        }
        return r;
    }

    @Override
    String decrypt(String msg) {
        // Decryption is same as encryption (reverse again)
        return encrypt(msg);
    }
}

// Main class to test the Cipher system
class CipherSystem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Caesar Cipher demo
        System.out.print("Enter message to encrypt: ");
        String msg = sc.nextLine();
        System.out.print("Enter Caesar cipher key: ");
        int ckey = sc.nextInt();

        CaesarCipher cc = new CaesarCipher(ckey);
        String enc = cc.encrypt(msg);
        System.out.println("Caesar Encrypted: " + enc);
        System.out.println("Caesar Decrypted: " + cc.decrypt(enc));

        // Reverse Cipher demo
        sc.nextLine(); // consume leftover newline
        System.out.print("Enter message for Reverse cipher: ");
        String msg2 = sc.nextLine();
        ReverseCipher rc = new ReverseCipher();
        String renc = rc.encrypt(msg2);
        System.out.println("Reverse Encrypted: " + renc);
        System.out.println("Reverse Decrypted: " + rc.decrypt(renc));

        sc.close();
    }
}
