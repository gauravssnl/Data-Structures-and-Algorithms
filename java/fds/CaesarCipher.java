package fds;

/** Class for doing encryption and decrytion using the Caesar Cipher. */
public class CaesarCipher {
    protected char[] encoder = new char[26]; // Encrytion array
    protected char[] decoder = new char[26]; // Decryption array

    /**
     * Constructor that initailizes the encrytion and decrytion arrays.
     * 
     * @param rotation number of times each character is rotated/shifted from its
     *                 position
     */
    public CaesarCipher(int rotation) {
        for (int k = 0; k < 26; k++) {
            encoder[k] = (char) ('A' + (k + rotation) % 26); // we add 'A' to get the new char at index k
            decoder[k] = (char) ('A' + (k - rotation + 26) % 26);
        }
    }

    /** Returns String representation of the encrypted message. */
    public String encrypt(String message) {
        return transform(message, encoder);
    }

    /** Returns decrypted message given encvrypted secret. */
    public String decrypt(String secret) {
        return transform(secret, decoder);
    }

    /** Returns transformation of original String using the given code. */
    public String transform(String original, char[] code) {
        char[] msg = original.toCharArray();
        for (int k = 0; k < msg.length; k++) {
            if (Character.isUpperCase(msg[k])) { // we have a letter to change
                int j = msg[k] - 'A'; // will be value from 0 to 25
                msg[k] = code[j]; // replace the character
            }
        }
        return new String(msg);
    }

    /** Simple main method for testing the Caesar Cipher. */
    public static void main(String[] args) {
        CaesarCipher cipher = new CaesarCipher(3);
        System.out.println("Encryption code = " + new String(cipher.encoder));
        System.out.println("Decryption code = " + new String(cipher.decoder));
        String message = "THE EAGLE IS IN PLAY; MEET AT JOE'S";
        String coded = cipher.encrypt(message);
        System.out.println("Secret: " + coded);
        String decoded = cipher.decrypt(coded);
        System.out.println("Message: " + decoded);

        cipher = new CaesarCipher(1);
        System.out.println("Encryption code = " + new String(cipher.encoder));
        System.out.println("Decryption code = " + new String(cipher.decoder));
        message = "THE EAGLE IS IN PLAY; MEET AT JOE'S";
        coded = cipher.encrypt(message);
        System.out.println("Secret: " + coded);
        decoded = cipher.decrypt(coded);
        System.out.println("Message: " + decoded);

    }
}