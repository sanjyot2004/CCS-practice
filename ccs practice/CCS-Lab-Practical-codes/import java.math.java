import java.math.BigInteger;
import java.util.Scanner;

class RSA {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first prime number (p): ");
        int p = scanner.nextInt();
        System.out.print("Enter second prime number (q): ");
        int q = scanner.nextInt();
        System.out.print("Enter the message to encrypt (integer): ");
        int msg = scanner.nextInt();

        scanner.close();

       
        int n = p * q;
        int z = (p - 1) * (q - 1);
        System.out.println("The value of n = " + n);
        System.out.println("The value of z (Euler’s Totient) = " + z);

        
        int e = 0;
        for (e = 2; e < z; e++) {
            if (gcd(e, z) == 1) {
                break;
            }
        }
        System.out.println("The value of public key exponent (e) = " + e);

        
        int d = 0;
        for (int i = 0; i <= 9; i++) {
            int x = 1 + (i * z);
            if (x % e == 0) {
                d = x / e;
                break;
            }
        }
        System.out.println("The value of private key exponent (d) = " + d);

       
        BigInteger C = BigInteger.valueOf(msg).pow(e).mod(BigInteger.valueOf(n));
        System.out.println("Encrypted message (Ciphertext) is: " + C);

        
        BigInteger decryptedMessage = C.pow(d).mod(BigInteger.valueOf(n));
        System.out.println("Decrypted message is: " + decryptedMessage);
    }

   
    static int gcd(int a, int b) {
        if (a == 0) return b;
        return gcd(b % a, a);
    }
}
