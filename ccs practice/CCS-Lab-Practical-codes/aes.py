from Crypto.Cipher import AES
from secrets import token_bytes

key=token_bytes(16)
print(f"key is :{key}")

cipher = AES.new(key, AES.MODE_EAX)
data = "WELCOME TO SANJIVANI COLLEGE".encode()

nonce = cipher.nonce

ciphertext = cipher.encrypt(data)
print("Cipher text:", ciphertext)
cipher = AES.new(key, AES.MODE_EAX, nonce=nonce)

plaintext = cipher.decrypt(ciphertext)
print("Plain text:", plaintext)