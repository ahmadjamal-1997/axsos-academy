class Ninja{
    constructor(name,health){
        this.name=name;
        this.health=health;
        this.speed=3;
        this.strength=3;
    }
    sayName(){
       console.log(this.name);
    }
    showStats(){
        console.log(this.name + " " + this.health +  " " + this.speed + " " + this.strength);
    }
    drinkSake(){
        this.health += 10;
    }
}
class sensei extends Ninja{
    constructor(name){
        super(name);
        this.wisdom = 10;
    }
    speakWisdom(){
        console.log("What one programmer can do in one month, two programmers can do in two months.")
    }

}
const superSensei = new sensei("Master Splinter");
superSensei.speakWisdom();
// -> "What one programmer can do in one month, two programmers can do in two months."
superSensei.showStats();