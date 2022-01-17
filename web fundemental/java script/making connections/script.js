
var element=document.querySelector("#user")
var element1=document.querySelector("#user1")
arr=[element,element1]
function remove(i){
    if (i==0){
        element.remove(i)
    }
    else{
        element1.remove(i)
    }
}

var element2=document.querySelector("#name")

function change(){
    
    element2.innerText="abdelhadi"
}