package week3.day1;

public class MyVehicle {

	public static void main(String[] args) {
		//Car
		Car c=new Car();
		c.petrol();
		c.soundHorn();
		c.applyBrakes();
		
		//BMW
		BMW b=new BMW();
		b.antiLockBrakingSystem();
		b.applyBrakes();
		b.soundHorn();
		//Audi
		Audi a=new Audi();
		a.applyBrakes();
		a.soundHorn();
		a.petrol();
		a.airBag();
		//Auto
		Auto au=new Auto();
		au.applyBrakes();
		au.soundHorn();
		au.threeWheeler();
		//Bajaj
		Bajaj bj=new Bajaj();
		bj.applyBrakes();
		bj.soundHorn();
		bj.threeWheeler();
		bj.brand();
		
		

	}

}
