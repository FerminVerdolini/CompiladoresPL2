package game;

import java.awt.Point;
import java.util.HashSet;
import java.util.Set;

public class TreasureMap {
    private static int width;
    private static int height;
    private static Set<Point> board = new HashSet<>();
    private static Set<Point> PositionsWithSomething = new HashSet<>();
    private static Set<Point> PositionsShoteds = new HashSet<>(); 
    private static Set<Ship> ships = new HashSet<>();
    private static Set<Mine> mines = new HashSet<>();

    public static boolean createMap(int width, int height){
        boolean isvalid = false;
        if (width > 0 && height > 0) {
            isvalid = true;          
            TreasureMap.height = height;
            TreasureMap.width = width;

            for (int i = 0; i < width; i++) {
                for (int j = 0; j < height; j++) {
                    board.add(new Point(i, j));
                }
            }
        }
        return isvalid;
    }

    public static int getWidth() {
        return width;
    }

    public static int getHeight() {
        return height;
    }

    public static boolean isValidPosition(Point p){
        return (p.getX() >= 0) && (p.getY() >= 0) && (p.getX() <= width) && (p.getY() <= height) && !PositionsShoteds.contains(p);
    }

    public static boolean addShip(Ship ship) {
        boolean isValidTresure = true;        

        for (Parts p : ship.getParts()) {
            if (!TreasureMap.isValidPosition(p.getPosition()) ||
            TreasureMap.PositionsWithSomething.contains(p.getPosition())) {
               isValidTresure = false;
            }
        }

        //No puedo ponerlo arriba pq tengo que estar seguro que todo el barco el valido antes de agregarlo
        if(isValidTresure){
            for (Parts p : ship.getParts()) {
                TreasureMap.PositionsWithSomething.add(p.getPosition());
            }
            ships.add(ship);
        }
        
        return isValidTresure;
    }

    public static Ship checkShip(Point position) {

        PositionsShoteds.add(position);
        for (Ship t : TreasureMap.ships) {
            
            for (Parts part : t.getParts()) {
                if(part.getPosition().equals(position)){

                    return  t;
                }
            }
        }

        return null;
    }

    public static void removeShip(Ship t){
        ships.remove(t);
    }
    
    public static boolean addMine(Mine mine) {

        boolean isValidMine;
        if (!TreasureMap.isValidPosition(mine.getPosition()) || 
            TreasureMap.PositionsWithSomething.contains(mine.getPosition())) {
            isValidMine = false;
        }else{
            TreasureMap.PositionsWithSomething.add(mine.getPosition());
            isValidMine = true;
            mines.add(mine);
        }
        
        return isValidMine;
    }

    public static Mine checkMine(Point position) {
        PositionsShoteds.add(position);
        for (Mine m : TreasureMap.mines) {
            if(m.getPosition().equals(position)){
                
                return  m;

            }
        }

        return null;
    }

    public static void removeMine(Mine m){
        mines.remove(m);
    }

    public static boolean isEmpyOfObjects(){
        return mines.isEmpty() && ships.isEmpty();
    }

    public static boolean isFullOfShots(){
        return PositionsShoteds.size() >= (height*width);
    }

    // public static void displayMap(Player player) {
    //     System.out.println("Current Map (Player: " + player.getName() + "):");
    //     for (int i = 0; i < height; i++) {
    //         for (int j = 0; j < width; j++) {
    //             if (player.getX() == j && player.getY() == i) {
    //                 System.out.print(" P "); // Player's position
    //             } else if (isTreasureDiscovered(j, i)) {
    //                 System.out.print(" T "); // Discovered treasure
    //             } else {
    //                 System.out.print(" . "); // Empty space
    //             }
    //         }
    //         System.out.println();
    //     }
    // }

    public static void resetMap() {
        ships.clear();
    }

    
    public static String info() {
        String ret = "";
        ret = "El mapa tiene " + mines.size() + " minas, " + ships.size() + " barcos y tiene ocupadas las posiciones: ";
        for(Point p: PositionsWithSomething){
            ret += p.toString() + " ";
        }
        return ret;
    }
}
