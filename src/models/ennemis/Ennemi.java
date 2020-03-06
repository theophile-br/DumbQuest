package models.ennemis;

import models.*;
import models.worldMap.Tile;

import java.util.ArrayList;

public abstract class Ennemi extends Moveable{

    private double respawnX;
    private double respawnY;

    public Ennemi(int areaX, int areaY, int tileX, int tileY, double boxWidth, double boxHeight, double attackBoxX, double attackBoxY, int vitesse) {
        super(areaX, areaY, tileX, tileY,boxWidth, boxHeight,attackBoxX,attackBoxY,vitesse);
        respawnX = getX();
        respawnY = getY();
    }


}
