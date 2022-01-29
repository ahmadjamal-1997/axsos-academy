element1=document.querySelector("#never1")
var first=document.querySelector("#count1")
var second=document.querySelector("#count2")
var count1=314
var count2=160


function remove(){
    element1.remove()
}

function increment(i){
    if(i==0){
        count1++
        first.innerText=count1
    }
    else{
        count2++
        second.innerText=count2
    }
}

function win(){
    if(count1>count2){
        alert("ninjas have won the game")
    }
    else{
        alert("pirates have won the game")
    }
}

var y=setTimeout(win,13000)



