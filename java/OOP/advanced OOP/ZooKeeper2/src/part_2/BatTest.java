package part_2;

public class BatTest {

	public static void main(String[] args) {
		Bat bat1 = new Bat();
		bat1.attackDown();
		bat1.attackDown();
		bat1.attackDown();
		bat1.eatHumans();
		bat1.eatHumans();
		bat1.fly();
		bat1.fly();
		System.out.println(bat1.energy);
	}

}
