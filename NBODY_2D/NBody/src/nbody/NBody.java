package nbody;



//2D version 




import java.text.DecimalFormat;
import java.text.NumberFormat;

public class NBody {
	public static int numPlanets;
	public static Planet[] planets;
    public static void main(String[] args) {
    	double T = Double.parseDouble(args[0]);
    	double dt = Double.parseDouble(args[1]);
    	String filename = args[2];

    	In in = new In(filename);
        numPlanets = in.readInt();
        double universeRadius = in.readDouble();

        planets = new Planet[numPlanets];
        
        for(int i = 0; i < numPlanets; i++){
        	Planet p = NBody.getPlanet(in);
        	planets[i] = p;
        	//System.out.println(p.x + " " + p.y + " " + p.xVelocity + " " + p.yVelocity + " " + p.mass + " " + p.img);
        }
        
        //create canvas, set scale
        StdDraw.setCanvasSize();
        StdDraw.setScale(-universeRadius, universeRadius);
        
        
        for(int i = 0; i < T; i += dt){
            StdDraw.picture(0, 0, "images/universe.jpg");
        	
            
            //update planets
        	for(Planet p : planets){
            	p.setNetForce(planets);
            	p.update(dt);  
            	p.draw();
            	//System.out.println(p.img.charAt(7) + " | " + p.xAccel + " | " + p.yAccel);
            }
        	
        	StdDraw.show(10);
        }
        /*
        NumberFormat formatter = new DecimalFormat("0.####E0");
        
        System.out.println(numPlanets);
        System.out.println(universeRadius);
        for(Planet p : planets){
        	System.out.println(formatter.format(p.x) + " " 
        				     + formatter.format(p.y) + " " 
        				     + formatter.format(p.xVelocity) + " " 
        				     + formatter.format(p.yVelocity) + " " 
        				     + formatter.format(p.mass) + " " 
        				     + p.img.substring(7));

        }
        */
         //0.000e00;-4.500e10;-3.000e04;0.000e00;1.989e30
    }
	
	public static Planet getPlanet(In in){

		Planet p = new Planet(0, 0, 0, 0, 0, "");
		p.x = in.readDouble();
		p.y = in.readDouble();
		p.xVelocity = in.readDouble();
		p.yVelocity = in.readDouble();
		p.mass = in.readDouble();
		p.img ="images/"+ in.readString();
	
//		System.out.println("x: " + p.x);
//		System.out.println("y: " + p.y);
//		System.out.println("xV: " + p.xVelocity);
//		System.out.println("xV: " + p.yVelocity);
//		System.out.println("m: " + p.mass);
//		System.out.println("img: " + p.img);
		
		return p;
	}
	public static Planet getPlanet(double a, double b, double c, double d, double e){

		Planet p = new Planet(0, 0, 0, 0, 0, "");
		p.x = a;
		p.y = b;
		p.xVelocity = c;
		p.yVelocity = d;
		p.mass = e;
		p.img = "images"+"/"+"sun"+"."+"gif";
		
		/*System.out.println("x: " + p.x);
		System.out.println("y: " + p.y);
		System.out.println("xV: " + p.xVelocity);
		System.out.println("xV: " + p.yVelocity);
		System.out.println("m: " + p.mass);
		System.out.println("img: " + p.img);*/
		
		return p;
	}
}
