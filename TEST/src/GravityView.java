import java.awt.Color;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

public class GravityView extends JPanel implements Observer{
        private static int ix=0, iy=0;
        private static int ix2=0, iy2=0;

        GravityView(){

        }
        public void update(Observable o, Object arg){
                Stars s = (Stars)o;
                ix = (int)s.getX();
                iy = (int)s.getY();

                repaint();
                ix2 = ix;
                iy2 = iy;
        //repaint();
                //System.out.println(ix);
                //System.out.println(i2x);
                //System.out.println(iy);
//              for(int i=0; i<100; i++){
//              ix=i;
//              iy=i+50;
//              try {
//                      repaint();
//                              Thread.sleep(500);
//                      } catch (InterruptedException e) {
//                              // TODO Auto-generated catch block
//                              e.printStackTrace();
//                      }
//          }

        }
        public void paint(Graphics g){
                //System.out.println(ix);
                g.setColor(Color.red);
//              g.fillOval(100, 100, 34, 34);
//              g.fillOval(50, 50, 34, 34);

//          g.fillOval(0, 0, 34, 34);
            g.fillOval((int)(ix2 ),(int)(iy2 ), 34, 34);
            g.fillOval((int)(ix), (int)(iy), 34, 34);
            System.out.println("ix"+" "+" "+"iy"+" "+"ix2"+" "+"iy2");
            System.out.println(ix+" "+" "+iy+" "+ix2+" "+iy2);
            //g.fillOval(50, 50, 34, 34);


        }

}