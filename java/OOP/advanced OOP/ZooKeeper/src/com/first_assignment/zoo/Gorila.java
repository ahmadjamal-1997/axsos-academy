package com.firstassimen.zoo;

public class Gorila extends Mamal{
	public void throwSomthing() {
		System.out.println("i throw some thing");
		super.energy -=10;
	}
	public void eateBannana() {
		System.out.println("i eate bann");
		super.energy +=10;
	}
	public void climing() {
		System.out.println("i climed");
		super.energy -=5;
	}
}
