package me.xiaoyuu.datastructure.dto;

import java.util.List;

public class ShortestPathInfo {

    private int length;
    private List<String> path;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public List<String> getPath() {
        return path;
    }

    public void setPath(List<String> path) {
        this.path = path;
    }

    public ShortestPathInfo(int length, List<String> path) {
        this.length = length;
        this.path = path;
    }
}
