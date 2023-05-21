package Algo2HW1_2;
//-----------------------------------------------------
//Title:  Tester class
//Author: Kaan GÜLER
//ID: 1973559069
//Section: 4
//Assignment: 1
//Description: This class tests codes
//-----------------------------------------------------

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		TourGuide.input();
		TourGraph tg=new TourGraph(TourGuide.cityNumber+1);
		TourGuide tgui=new TourGuide(tg);

		System.out.println(tgui.pathTo(tg,tgui.f));


		

	
		
		
	}

}
