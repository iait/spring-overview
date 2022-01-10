package com.example;

public class Test {

	static abstract class Animal {
		public String sound() {
			return "What!";
		}

		abstract public Integer lifeExpectancy();
	}

	static class Dog extends Animal {
		@Override
		public String sound() {
			return "Guau!";
		}

		@Override
		public Integer lifeExpectancy() {
			return 10;
		}
	}

	static class Cat extends Animal {
		@Override
		public String sound() {
			return "Miau!";
		}

		@Override
		public Integer lifeExpectancy() {
			return 15;
		}
	}

	interface Interface1 {
		default String method() {
			return "From Interface1";
		}
	}

	interface Interface2 {
		default String method() {
			return "From Interface2";
		}
	}

	static class Implementation implements Interface1, Interface2 {

		@Override
		public String method() {
			// TODO Auto-generated method stub
			return Interface1.super.method();
		}

	}

	public static void main(String[] args) {

		Animal a1 = new Dog();
		Animal a2 = new Cat();
//		Animal a3 = new Animal();

		System.out.println(String.format("Dog: %s, Cat: %s, Animal: %s", a1.sound(), a2.sound(), "can't be instantiated"));
		System.out.println(String.format("Dog as an Animal: %s", a1.sound()));

	}

}
