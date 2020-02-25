package models;

import models.worldMap.Tile;

import java.util.ArrayList;

public class GraphNode {
    public int f;
    public int g;
    public int h;
    public int indiceX;
    public int indiceY;
    public GraphNode parent;

    public GraphNode(Tile tile){
        this.indiceX = tile.getIndiceX();
        this.indiceY = tile.getIndiceY();
        f=0;
        g=0;
        h=0;
    }

    public boolean graphEquals(GraphNode o) {
        return indiceX == o.indiceX &&
                indiceY == o.indiceY;
    }
}
