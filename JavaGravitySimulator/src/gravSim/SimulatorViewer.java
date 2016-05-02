package gravSim;

import java.awt.*;
import java.awt.event.*;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

public class SimulatorViewer extends JPanel implements Observer {
	private BodyList bodyList;
	private int current;
//	private double min, max;
	private static int currentSize = 0;
	
	SimulatorViewer() {
//		resize();
		setBackground(Color.BLACK);
//		min  = 0;
//		max = 200;
//		addComponentListener(new ComponentAdapter() {
//			@Override
//			public void componentResized(ComponentEvent e) {
//				resize();
//			}
//		});
	}
//	public void resize() {
//		//int currentSize = bodies.length;
//		//bodies = new Body[++currentSize];
//		currentSize = bodyList.bodies.size();
//	}
	public void update(Observable o, Object arg) {
		bodyList = (BodyList)o;
		if(current >= bodyList.bodies.size())
			current = 0;
		repaint();
	}
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.WHITE);
		for(int i = 0; i < bodyList.bodies.size(); i++) {
			bodyList.bodies.get(i).draw(g);
		}
	}
}
