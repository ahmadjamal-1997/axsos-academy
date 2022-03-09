package part_2;

public class Bat extends Mamal {
	public Bat() {
		super.energy = 300;
	}
	public void fly() {
		System.out.println("taking off");
		energy -= 50 ;
	}
	public void eatHumans() {
		System.out.println("so- well");
		energy += 25 ;
	}
	public void attackDown() {
		System.out.println("burning town on fire");
		energy -= 100 ;
	}
}
