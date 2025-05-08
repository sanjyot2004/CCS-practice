p = int(input("Enter a prime number (p): "))
q = int(input("Enter a primitive root (q): "))
Xa = int(input("Enter private key of user A (Xa): "))
Xb = int(input("Enter private key of user B (Xb): "))

def rsa_key_exchange(p, q, Xa, Xb):
    Ya = (q ** Xa) % p  
    Yb = (q ** Xb) % p  
    
    k1 = (Yb ** Xa) % p  
    k2 = (Ya ** Xb) % p  
    
    print(f"Public key of A (Ya) = {Ya}")
    print(f"Public key of B (Yb) = {Yb}")
    print(f"Shared secret key = {k1}")
    
    if k1 == k2:
        print("Key exchange successful!")
    else:
        print("Error: Shared secrets do not match!")

rsa_key_exchange(p, q, Xa, Xb)