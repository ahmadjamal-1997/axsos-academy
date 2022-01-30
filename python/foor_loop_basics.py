for x in range (0,151,1):
    print(x)

for x in range (5,1005,1):
    if x%5==0 : print(x)

for x in range(1,101,1):
    if x%10==0 :print("Coding Dojo")

    elif x%5==0 :print("Coding")

    else :print(x)
count = 0
for x in range (0,500000,1):
    if x%2 != 0: 
        count=count+x

print (count)

for x in range(2018,0,-4):
    print(x)


low_num=6
high_num=30
mult=4

for x in range(0,high_num,1):
    if x%mult==0:print(x)