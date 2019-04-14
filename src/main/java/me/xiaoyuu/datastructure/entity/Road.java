package me.xiaoyuu.datastructure.entity;

import java.util.Objects;

public class Road {

    private int attractionFirstId;
    private int attractionSecondId;
    private int distance;
    private Attraction attractionFirst;
    private Attraction attractionSecond;

    public Road() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Road road = (Road) o;
        return distance == road.distance&&attractionFirstId == road.attractionFirstId &&
                attractionSecondId == road.attractionSecondId
                ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(attractionFirstId, attractionSecondId, distance);
    }

    @Override
    public String toString() {
        return "Road{" +
                "attractionFirstId=" + attractionFirstId +
                ", attractionSecondId=" + attractionSecondId +
                ", distance=" + distance +
                ", attractionFirst=" + attractionFirst+
                ", attractionSecond=" + attractionSecond+
                '}';
    }

    public Road(int attractionFirstId, int attractionSecondId, int distance) {
        this.attractionFirstId = attractionFirstId;
        this.attractionSecondId = attractionSecondId;
        this.distance = distance;
    }

    public Road(int attractionFirstId, int attractionSecondId, int distance, Attraction attractionFirst, Attraction attractionSecond) {
        this.attractionFirstId = attractionFirstId;
        this.attractionSecondId = attractionSecondId;
        this.distance = distance;
        this.attractionFirst = attractionFirst;
        this.attractionSecond = attractionSecond;
    }

    public int getAttractionFirstId() {
        return attractionFirstId;
    }

    public void setAttractionFirstId(int attractionFirstId) {
        this.attractionFirstId = attractionFirstId;
    }

    public int getAttractionSecondId() {
        return attractionSecondId;
    }

    public void setAttractionSecondId(int attractionSecondId) {
        this.attractionSecondId = attractionSecondId;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public Attraction getAttractionFirst() {
        return attractionFirst;
    }

    public void setAttractionFirst(Attraction attractionFirst) {
        this.attractionFirst = attractionFirst;
    }

    public Attraction getAttractionSecond() {
        return attractionSecond;
    }

    public void setAttractionSecond(Attraction attractionSecond) {
        this.attractionSecond = attractionSecond;
    }
}
