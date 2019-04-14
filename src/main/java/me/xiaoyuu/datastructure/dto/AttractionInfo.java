package me.xiaoyuu.datastructure.dto;

import me.xiaoyuu.datastructure.entity.Attraction;
import me.xiaoyuu.datastructure.entity.Road;

import java.util.List;

public class AttractionInfo {
    private Attraction attraction;
    private List<Road> roads;

    @Override
    public String toString() {
        return "AttractionInfo{" +
                "attraction=" + attraction +
                ", roads=" + roads +
                '}';
    }

    public AttractionInfo(Attraction attraction, List<Road> roads) {
        this.attraction = attraction;
        this.roads = roads;
    }

    public AttractionInfo() {
    }

    public Attraction getAttraction() {
        return attraction;
    }

    public void setAttraction(Attraction attraction) {
        this.attraction = attraction;
    }

    public List<Road> getRoads() {
        return roads;
    }

    public void setRoads(List<Road> roads) {
        this.roads = roads;
    }
}
