var element=document.querySelector("#display")
var arr=[]
var newarr1=[]
var newarr2=[]

var operation=""
function press(a){
    if(operation==""){
    newarr1.push(a)
    var c=newarr1.join('')
    element.innerText=c

}
else {
    newarr2.push(a)
    var o=newarr2.join('')
    element.innerText=o
}

}

function setOP(operations){
    var b=document.querySelector("#display")
    var d=parseInt(b.innerText)
    operation=operations

}

function calculate(){
    if(operation=="*"){
        total=newarr1.join('')*newarr2.join('')
        element.innerText=total
    }
    else if(operation=="/"){
        total=newarr1.join('')/newarr2.join('')
        element.innerText=total
    }
    else if(operation=="+"){
        total=newarr1.join('')+newarr2.join('')
        element.innerText=total
    }
    else if(operation=="-"){
        total=newarr1.join('')-newarr2.join('')
        element.innerText=total
    }
}
function clr(){
    newarr1=[]
    newarr2=[]
    operation=""
    element.innerText=0
}