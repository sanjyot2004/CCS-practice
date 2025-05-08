import java.util.Scanner;

public class DiffieHellman {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a prime number (p): ");
        int p = scanner.nextInt();
        
        System.out.print("Enter a primitive root (q): ");
        int q = scanner.nextInt();
        
        System.out.print("Enter private key of user A (Xa): ");
        int Xa = scanner.nextInt();
        
        System.out.print("Enter private key of user B (Xb): ");
        int Xb = scanner.nextInt();
        
        keyExchange(p, q, Xa, Xb);
        
        scanner.close();
    }
    
    public static void keyExchange(int p, int q, int Xa, int Xb) {
        int Ya = (int) (Math.pow(q, Xa) % p);
        int Yb = (int) (Math.pow(q, Xb) % p);
        
        int k1 = (int) (Math.pow(Yb, Xa) % p);
        int k2 = (int) (Math.pow(Ya, Xb) % p);
        
        System.out.println("Public key of A (Ya) = " + Ya);
        System.out.println("Public key of B (Yb) = " + Yb);
        System.out.println("Shared secret key = " + k1);
        
        if (k1 == k2) {
            System.out.println("Key exchange successful!");
        } else {
            System.out.println("Error: Shared secrets do not match!");
        }
    }
}