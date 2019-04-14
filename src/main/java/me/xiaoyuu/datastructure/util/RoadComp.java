package me.xiaoyuu.datastructure.util;

import me.xiaoyuu.datastructure.entity.Road;

import java.util.Comparator;

public class RoadComp implements Comparator<Road> {
    @Override
    public int compare(Road o1, Road o2) {
        return Integer.compare(o2.getDistance(), o1.getDistance());
    }
}
