import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JFrame;

public class GravityWin extends JFrame{
        private GravityView v;
        public GravityWin(){
        v = new GravityView();
        Container c = getContentPane();
        c.add(v,  BorderLayout.CENTER);
        setSize(800,600);
        setVisible(true);
        }

        public void add(Stars s){
                s.addObserver(v);
        }

}
