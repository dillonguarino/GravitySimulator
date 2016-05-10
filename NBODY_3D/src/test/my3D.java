package test;

// for the 3D drawing test

public class my3D {
	public static void main(String[] args){
		StdDraw3D.setCanvasSize(1024, 860);
		StdDraw3D.setScale(-9.50e+11,9.50e+11);
		
		StdDraw3D.setBackgroundSphere("universe.jpg");
		
		
		double radius = 0.2;
		
		double distance1_sun = 0;
		double distance2_mecury = 5.790e10;
		double distance3_venus = 1.082e11;
		double distance4_earth = 1.496e11;
		double distance5_mars = 2.279e11;
		double distance6_jupiter = 7.779e11;
		
		double R1_sun = 2.935e10;
		double R2_mecury = 0.440e10;
		double R3_venus = 1.210e10;
		double R4_earth = 1.140e10;
		double R5_mars = 0.612e10;
		double R6_jupiter = 2.087e10;
		
		
		double angle_sun = 0;
		double angle_mecury = 0;
		double angle_venus = 0;
		double angle_earth = 0;
		double angle_mars = 0;
		double angle_jupiter = 0;
		
		double Vangle_sun = 0;
		double Vangle_mecury = 0;
		double Vangle_venus = 0;
		double Vangle_earth = 0;
		double Vangle_mars = 0;
		double Vangle_jupiter = 0;
		
		int time = 50;
		
		while (true){
			
			
			//sun 
			double x0 = 0;
			double y0 = 0;
			
			
			//mecury
			double x1 = distance2_mecury * Math.cos( Vangle_mecury);
			double y1 = distance2_mecury* Math.sin( Vangle_mecury);
			
			//venus
			double x2 = distance3_venus * Math.cos(Vangle_venus);
			double y2 = distance3_venus * Math.sin(Vangle_venus);
			
			//earth
			double x3 = distance4_earth * Math.cos(Vangle_earth);
			double y3 = distance4_earth * Math.sin(Vangle_earth);
			
			//mars
			double x4 = distance5_mars * Math.cos(Vangle_mars);
			double y4 = distance5_mars * Math.sin(Vangle_mars);
			
			//jupiter
			double x5 = distance6_jupiter * Math.cos(Vangle_jupiter);
			double y5 = distance6_jupiter * Math.sin(Vangle_jupiter);
	
			
			
			
			double z = 0;
			
			
			angle_sun += 0.407;
			angle_mecury += 0.1698;
			angle_venus += 0.04098;
			angle_earth += 1;
			angle_mars += 98.03;
			angle_jupiter += 241.54;
			
			Vangle_sun += 0;
			Vangle_mecury += 0.00474;
			Vangle_venus += 0.0035;
			Vangle_earth += 0.00298;
			Vangle_mars += 0.00241;
			Vangle_jupiter += 0.0131;
			
			
			StdDraw3D.clear();
			

			StdDraw3D.sphere(x0,y0,0,R1_sun,0,0,angle_sun,"sun.jpg");
			StdDraw3D.sphere(x1,y1,0,R2_mecury,0,0,angle_mecury,"mercury.jpg");
			StdDraw3D.sphere(x2,y2,0,R3_venus,0,0,angle_venus,"venus.jpg");
			StdDraw3D.sphere(x3,y3,0,R4_earth,0,0,angle_earth,"earth.jpg");
			StdDraw3D.sphere(x4,y4,0,R5_mars,0,0,angle_mars,"mars.jpg");
			StdDraw3D.sphere(x5,y5,0,R6_jupiter,0,0,angle_jupiter,"jupiter.jpg");
			
			StdDraw3D.show(time);
			System.out.println(StdDraw3D.mouseX()+","+StdDraw3D.mouseY());
		}
		
		
	}
}
