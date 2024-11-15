package game;

import java.awt.Point;


public class Player {
    private String name;
    private int score;
    private int shotsLeft;

    public Player(String name, int totalShots) {
        this.name = name;
        this.score = 0;
        this.shotsLeft = totalShots; // Set initial number of shots
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public int getShotsLeft() {
        return shotsLeft;
    }

    public void updateScore(Ship treasure) {
        this.score += treasure.getPoints();
    }

    public void shot(Point shot) {

        if (shotsLeft > 0){
            if( TreasureMap.isValidPosition(shot)){
                Ship t = TreasureMap.checkShip(shot); 
                if(t != null){
                    System.out.println("disparo acertado a " + t);    

                    if(t.removePart(shot)){ //si se hundio todo el barco
                        TreasureMap.removeShip(t); // Creo que no hace falta
                        score += t.getPoints();
                        System.out.println("\033[32m" + t + " recuperado! jugador: "+ name +" suma "+ t.getPoints() + " puntos");    
                    }
                }else{
                    
                    Mine m = TreasureMap.checkMine(shot);

                    if(m != null){
                        m.setFounded(true);
                        TreasureMap.removeMine(m); // Creo que no hace falta
                        score -= Mine.getPoints();
                        System.out.println("\033[33m" + m + " encontrada! jugador: "+ name +" resta "+ Mine.getPoints() + " puntos" + "\033[0m");    
                    }else{
                        System.out.println("\033[34m" + "Disparo al agua" + "\033[0m");    
                    }
                }
                shotsLeft--;
            }else{
                System.out.println("\033[31m" + " La posicion no es valida porque ya fue disparada o porque esta fuera de los limites!" + "\033[0m");    
            }    
        }else {
            System.out.println("No shots left!");
        }
    }

    public boolean hasShots() {
        return shotsLeft > 0;
    }

    @Override
    public String toString() {
        return "Player: " + name + " with score: " + score + " and " + shotsLeft + " shots left.";
    }
}
