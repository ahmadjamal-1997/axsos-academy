//first challeng
function alwaysHungry(arr) {
    var count=0;
    var food=""
    for(var i=0;i<=arr.length-1;i++){
        if(arr[i]=="food"){
            console.log("yummy")
        }
        else if (arr[i]!="food"){
            count++;
            if(count==arr.length){
            console.log("I'm hungry")
            }
        }
    }
}
   
alwaysHungry([3.14, "food", "pie", true, "food"]);
//second challenge
function highPass(arr, cutoff) {
    var filteredArr = [];
    for(var i=0;i<arr.length;i++){
        if(arr[i]>cutoff)
        filteredArr.push(arr[i])
    }
    return filteredArr;
}
var result = highPass([6, 8, 3, 10, -2, 5, 9], 5);
console.log(result); // we expect back [6, 8, 10, 9]
//third challenge
function betterThanAverage(arr) {
    var sum = 0;
    for(var i=0;i<arr.length;i++){
        sum=sum+arr[i]
    }
    var avg=sum/(arr.length)
    var count = 0
    for(var i=0;i<arr.length;i++){
    if(arr[i]>avg){
    count++
}
}
return count;
}
var result = betterThanAverage([6, 8, 3, 10, -2, 5, 9]);
console.log(result); // we expect back 4
//fourth challenge

function reverse(arr) {
    var newarr=[]
    for(var i=0;i<arr.length;i++){
        newarr.push(arr[arr.length-1-i])
    
}
return newarr;
}
   
var result = reverse(["a", "b", "c", "d", "e"]);
console.log(result); // we expect back ["e", "d", "c", "b", "a"]
//fifth challenge
function fibonacciArray(n) {
    var fibArr = [0, 1];
    for(var i=0;i<n-2;i++){
    fibArr[i+2]=fibArr[i+1]+fibArr[i]
    }
    return fibArr;
}
   
var result = fibonacciArray(10);
console.log(result); // we expect back [0, 1, 1, 2, 3, 5, 8, 13, 21, 34]