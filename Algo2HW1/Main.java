package Algo2HW1;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		FOM.input();
		
		FomGraph fg=new FomGraph(FOM.cityNumber+FOM.biDirect);
		FOM fom=new FOM(fg);
		System.out.println(fom.showDistance(FOM.f)+1);
		
		System.out.println(fom.findPath(FOM.f));
		System.out.println(fom.calculateTime(FOM.s, FOM.f));
		
	}

}
