package gravSim;

public class Vector2D {
	public double x, y;
	final double G = 6.674e-11;
	final double dT = 100000;
	
	public Vector2D() {
		this.x = 0;
		this.y = 0;
	}
	public Vector2D(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public double getDistance(Vector2D other) {
		return Math.sqrt(Math.pow(this.x-other.x,2)+Math.pow(this.y-other.y,2));
	}
	
	public void add(Vector2D other) {
		this.x += other.x;
		this.y += other.y;
	}
	
	public void calculateVelocity(double dist, double mass1, double mass2, Vector2D direction) {
		double accelMag = dT*((G*((mass1*mass2)/(dist*dist)))/mass1);
		this.x += accelMag*direction.x;
		this.y += accelMag*direction.y;
	}
	
	public void setDirection(Vector2D v1, Vector2D v2) {
		double magnitude = v1.getDistance(v2);
		this.x = -(v1.x - v2.x)/magnitude;
		this.y = -(v1.y - v2.y)/magnitude;
	}
}
