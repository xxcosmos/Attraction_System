package me.xiaoyuu.datastructure.dto;

import me.xiaoyuu.datastructure.entity.Road;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class PrimInfo {
    int length;
   Set<Road> roads;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Set<Road> getRoads() {
        return roads;
    }

    public void setRoads(Set<Road> roads) {
        this.roads = roads;
    }

    public PrimInfo(int length, Set<Road> roads) {
        this.length = length;
        this.roads = roads;


    }
}
