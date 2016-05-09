package gravSim;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SimulatorWin extends JFrame {
	private SimulatorViewer v;
	public SimulatorWin() {
		super("graph");
		v = new SimulatorViewer();
		getContentPane().setBackground(Color.BLACK);
		Container c = getContentPane();
		c.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();
				new Body(x, y);
			}
		});
		c.add(v, BorderLayout.CENTER);
		setSize(1000,1000);

		addWindowListener(new WindowAdapter() {
			public void WindowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		c.setBackground(Color.BLACK );
		setVisible(true);
	}
	public void add(BodyList b) {
		b.addObserver(v);
	}
}
