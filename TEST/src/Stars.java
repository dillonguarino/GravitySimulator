import java.util.Observable;
import java.util.Observer;

public class Stars extends Observable{
        public double x, y, vx, vy, ax = 0, ay = 0, angx = 0, angy = 0, sqDistance, m;

        public Stars(double x, double y, double vx, double vy, double m){
                this.x = x;
                this.y = y;
                this.vx = vx;
                this.vy = vy;
                this.m = m;
        }
        public void impact(Stars s2){
                sqDistance = (s2.x-x)*(s2.x-x)+(s2.y-y)*(s2.y-y);
                angx = -(x-s2.x)/Math.sqrt(sqDistance);
                angy = -(y-s2.y)/Math.sqrt(sqDistance);
                ax = s2.m/(sqDistance)*angx;
                ay = s2.m/(sqDistance)*angy;
                vx += ax;
                vy += ay;
                x += vx;
                y += vy;

                setChanged();
                notifyObservers();
        }

        public double getX(){
                return x;
        }
        public double getY(){
                return y;
        }

        public static void main(String[] args){
                Stars s = new Stars(500, 0, 0, 0, 50000);
            Stars s2 = new Stars(300, 500, 0, 0, 50000);

        GravityWin w = new GravityWin();
                w.add(s);
                w.add(s2);

                for (int i = 0; i < 100 ; i++){
                        s.impact(s2);
            try {
                  Thread.sleep(100);
                    } // Wait 100 milliseconds
                          catch (InterruptedException e) {
                } // Ignore interruptions

                //s.impact(s2);
                s2.impact(s);
            try {
                  Thread.sleep(100);
                    } // Wait 100 milliseconds
                          catch (InterruptedException e) {
                } // Ignore interruptions
                //System.out.println(s.x);
                //System.out.println(s2.x);
                }
        }

}