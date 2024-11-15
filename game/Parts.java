package game;

import java.awt.Point;


public class Parts {
    private Point position;
    private boolean isfuonded;

    public Parts(Point position) {
        this.position = position;
        this.isfuonded = false;
    }

    public Point getPosition() {
        return position;
    }
    public void setPosition(Point position) {
        this.position = position;
    }
    public boolean isIsfuonded() {
        return isfuonded;
    }
    public void setIsfuonded(boolean isfuonded) {
        this.isfuonded = isfuonded;
    }

}
