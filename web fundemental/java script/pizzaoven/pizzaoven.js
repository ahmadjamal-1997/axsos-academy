function pizzaoven(crusttype,saucetype,cheeses,toppings){
    var pizza={};
    pizza.crusttype=crusttype;
    pizza.saucetype=saucetype;
    pizza.cheeses=cheeses;
    pizza.toppings=toppings;
    return pizza;
}

y=pizzaoven("deep dish", "traditional","mozarilla",["sausage","pepperoni"])
console.log(y);

x=pizzaoven("hand tossed","marinara",["mozarilla","feta"],["mushrooms","olives","onions"])
console.log(x);

z=pizzaoven("deep dish","marinara",["chedar"],["olives","onions"])
console.log(z);

s=pizzaoven("hand tossed","bbq",["greatest"],["pepperoni","onions"])
console.log(s);

var crustType =[
    "deep dish",
    "hand tossed",
    "thin",
    "gluten free"
];
var sauceType =[
    "traditional",
    "marinara",
    "bbq",
    "meyo"
];
var cheese =[
    "mozzarella",
    "cheddar",
    "feta",
    "swiss cheese",
    "parmesan"
];
var toppings =[
    "pepperoni",
    "sausage",
    "corn",
    "bell peppers",
    "mushrooms"
];

function randomRange(max,min) {
    return Math.floor(Math.random() * max - min) + min;
}

function randomPick(arr) {
    var i = Math.floor(arr.length * Math.random());
    return arr[i];
}

function randomPizza() {
    var pizza = {};
    pizza.crustType = randomPick(crustType);
    pizza.sauceType = randomPick(sauceType);
    pizza.cheeses = [];
    pizza.toppings = [];
    for(var i=0; i<randomRange(4, 1); i++) {
        pizza.cheeses.push(randomPick(cheese));
    }
    for(var i=0; i<randomRange(4, 0); i++) {
        pizza.toppings.push(randomPick(toppings));
    }
    return pizza;
}

console.log(randomPizza());