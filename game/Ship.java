package game;

import java.awt.Point;
import java.util.*;


public class Ship {
    private Set<Parts> parts = new HashSet<>();
    private String name;
    private int points; 
    private boolean isFounded;


    public Ship(String name, Set<Point> positions, int points) {
        
        for (Point position : positions) {
            parts.add(new Parts(position));
        }

        this.name = name;
        this.points = points;
        this.isFounded =  false;
    }

    public Set<Parts> getParts() {
        return parts;
    }


    public boolean isFounded() {
        return isFounded;
    }

    public void setFounded(boolean isFounded) {
        this.isFounded = isFounded;
    }


    public boolean removePart(Point p){
        for (Parts part : parts) {
            
            if(part.getPosition().equals(p)){
                part.setIsfuonded(true);
            }
        }

        return isAllFound();
    }
    
    public boolean isAllFound() {
        boolean retval = true;
        for (Parts part : parts) {
            if(!part.isIsfuonded()){
                retval = false;
            }
        }
        return retval;
    }

    public int getPoints(){
        return points;
    }

    @Override
    public String toString() {
        return "Tesoro: " + name;
    }
    
//     private static boolean areConsecutives(Set<BoardPosition> positions) {
        
//         List<BoardPosition> positionsList = new ArrayList<>(positions);
        
//  //       positionsList.sort(Comparator.comparingInt(BoardPosition::getX).thenComparingInt(BoardPosition::getY));
        
    
//         for (int i = 1; i < positionsList.size(); i++) {
//             BoardPosition p1 = positionsList.get(i - 1);
//             BoardPosition p2 = positionsList.get(i);
            
//             if (!(p1.getX() == p2.getX() && Math.abs(p1.getY() - p2.getY()) == 1) &&
//                 !(p1.getY() == p2.getY() && Math.abs(p1.getX() - p2.getX()) == 1)) {
//                 return false; 
//             }
//         }

//         return true; 
//     }

}