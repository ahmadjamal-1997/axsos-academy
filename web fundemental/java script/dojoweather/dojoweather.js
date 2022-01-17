function al(){
    alert("loading weather report")
}


var elements=document.querySelector("footer")
function remove()
{
elements.remove()
}

celi=[24,18,17,19,21,16,26,21]

function change(sd){
    if(sd.value=="fah"){
        for(var i=0;i<celi.length;i++){
        document.getElementById(`num${i}`).innerText=
        Math.floor(celi[i]*(9/5)+32)+"°"
    }
    }else { (sd.value=="cel")
        for(var i=0;i<celi.length;i++){
        document.getElementById(`num${i}`).innerText=celi[i]+"°"
    }
}


}




// var element1=document.querySelector("#num1")
// var element2=document.querySelector("#num2")
// var element3=document.querySelector("#num3")
// var element4=document.querySelector("#num4")
// var element5=document.querySelector("#num5")
// var element6=document.querySelector("#num6")
// var element7=document.querySelector("#num7")
// var element8=document.querySelector("#num8")

// function change(){
// element1.innerText="75"
// element2.innerText="65"
// element3.innerText="80"
// element4.innerText="66"
// element5.innerText="69"
// element6.innerText="61"
// element7.innerText="78"
// element8.innerText="70"
