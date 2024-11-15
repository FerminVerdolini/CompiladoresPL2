package game;

import java.awt.Point;


public class Mine {
    private Point position;
    private static int points; 
    private boolean isFounded;


    public Mine(Point position) {
        
        this.position = position;
        this.isFounded =  false;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }


    public static void setPoints(int points){
        Mine.points = points;
    }


    public boolean isFounded() {
        return isFounded;
    }

    public void setFounded(boolean isFounded) {
        this.isFounded = isFounded;
    }

    public static int getPoints(){
        return points;
    }

    @Override
    public String toString() {
        return "La Mina";
    }
    
}