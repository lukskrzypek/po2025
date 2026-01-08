package symulator;

import static java.lang.Math.*;

public class Pozycja {
    private double x;
    private double y;

    public Pozycja(double x, double y){
        this.x = x;
        this.y = y;
    }
    public Pozycja getPozycja(){
        return new Pozycja(x,y);
    }

    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }

    public void przemieszczenie(Pozycja cel, float predkosc){
        double dt=0.1;
        double x=cel.x-this.x;
        double y=cel.y-this.y;
        double alfa = Math.atan2(x, y);
        double ds=predkosc*dt;
        double s = sqrt(pow(x,2)+ pow(y,2));
        double dx=sin(alfa)*ds;
        double dy=cos(alfa)*ds;

        if (s>ds){
            this.x+=dx;
            this.y+=dy;
        }else{
            this.x=cel.x;
            this.y=cel.y;
        }

    }
}
