import hashlib
str="WELCOME TO SANJIVANI COLLEGE"
result=hashlib.md5(str.encode())
print("The equivalent hexadecimal value:")
print(result.hexdigest())

