package me.xiaoyuu.datastructure.entity;

import java.util.List;
import java.util.Set;

public class Graph {

    private int vexNum;
    private int edgeNum;
    private int[][] matrix;
    private Attraction[] attractionList;

    public Graph(int vexNum, int edgeNum, List<Attraction> attractionList) {
        this.attractionList = ( attractionList.toArray(new Attraction[attractionList.size()]));
        this.attractionList = new Attraction[attractionList.size()];
        for (int i = 0; i<this.attractionList.length;i++){
            this.attractionList[i]=attractionList.get(i);
        }
        this.vexNum = vexNum;
        this.edgeNum = edgeNum;
        this.matrix = new int[vexNum][vexNum];
        for (int i = 0; i < vexNum; i++) {
            for (int j = 0; j < vexNum; j++) {
                if (i == j) {
                    matrix[i][j] = 0;
                } else {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }
    }

    public Attraction[] getAttractionList() {
        return attractionList;
    }

    public void setAttractionList(Attraction[] attractionList) {
        this.attractionList = attractionList;
    }

    public int getVexNum() {
        return vexNum;
    }

    public void setVexNum(int vexNum) {
        this.vexNum = vexNum;
    }

    public int getEdgeNum() {
        return edgeNum;
    }

    public void setEdgeNum(int edgeNum) {
        this.edgeNum = edgeNum;
    }

    public void setValue(int v, int e, int value) {
        matrix[v][e] = value;
    }

    public int getValue(int v, int e) {
        return matrix[v][e];
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }
}
