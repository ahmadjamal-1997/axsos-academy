1
def biggie_size(arr):
    for x in range (0,len(arr),1):
        if arr[x]>0:
            arr[x]="big"
    return arr

print(biggie_size([2,-5,6,-1]))

2
def count_positives(arr):
    count=0
    for x in range (0,len(arr),1):
        if arr[x]>0 :
            count=count+1
    arr[len(arr)-1]=count
    return arr

print(count_positives([2,5,-1,3,5]))

3
def sum_total(arr):
    sum=0
    for x in range(0,len(arr),1):
        sum=sum+arr[x]
    return sum

print(sum_total([3,4,5,6,7,8]))

4
def avarage(arr):
    sum=0
    for x in range(0,len(arr),1):
        sum=sum+arr[x]
    return (sum/len(arr))

print(avarage([3,5,7]))

5
def length(arr):
    return len(arr)
print (length([2,3,4]))

6
def minimum(arr):
    min=arr[0]
    if len(arr)==0:
        return "False"
    
    for x in range(1,len(arr),1):
        if arr[x]<min:
            min=arr[x]
    return min
print(minimum([2,5,1,3,4]))

7
def maximum(arr):
    max=arr[0]
    if len(arr)==0:
        return "False"
    
    for x in range(1,len(arr),1):
        if arr[x]>max:
            max=arr[x]
    return max
print(maximum([2,5,1,3,4]))

#8
def ultimate_analysis(arr):
    sum=0
    min=arr[0]
    max=arr[len(arr)-1]
    for x in range (0,len(arr),1):
        sum=sum+arr[x]
        if arr[x]>max :
            max=arr[x]
        elif arr[x]<min:
            min=arr[x]
            
    avg=(sum/len(arr))
    return ([sum,avg,min,max,len(arr)])

print(ultimate_analysis([2,3,4,5,6,7]))

#9
def reverse(arr):
    y=len(arr)/2
    for x in range (0,int(y),1):
        temp=arr[x]
        arr[x]=arr[len(arr)-1-x]
        arr[len(arr)-1-x]=temp
    return arr

print(reverse([2,5,6,4,2,4,5,7]))

