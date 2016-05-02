package gravSim;
import java.util.ArrayList;
import java.util.Observable;

public class BodyList extends Observable {
	public ArrayList<Body> bodies;
	BodyList() {
		bodies = new ArrayList<Body>();
	}
	
	public void add(Body b) {
		bodies.add(b);
		changed();
	}
	public void changed() {
//		System.out.println("CHANGED");
		setChanged();
		notifyObservers();
	}
}
