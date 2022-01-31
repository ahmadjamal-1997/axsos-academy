
#1
def a(num):
    arr=[]
    for x in range(num,0,-1):
        arr.append(x)
    return arr
print(a(5))

#2
def b(num1,num2):
    print(num1)
    return num2
print(b(2,3))

#3
def c(arr):
    return len(arr)+arr[0]
print(c([1,2,3,4,5,6]))

#4
def greater(arr):
    newarr=[]
    count=0
    for x in range (0,len(arr),1):
        if len(arr)<2:
            return "false"

        elif arr[x]>arr[1]:
            newarr.append(arr[x])
            count=count+1
    print(count) 
    return newarr

print(greater([6,4,2,1,5]))

#5
def length_and_value(num1,num2):
    newarr=[]
    for x in range (0,num1,1):
        newarr.append(num2)
    return newarr
print(length_and_value(6,2))

