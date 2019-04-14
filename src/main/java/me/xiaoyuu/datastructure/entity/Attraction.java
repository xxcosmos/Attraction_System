package me.xiaoyuu.datastructure.entity;

import java.util.Objects;

public class Attraction {

    private int id;
    private String name;
    private String introduction;

    public Attraction() {
    }

    @Override
    public String toString() {
        return "Attraction{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", introduction='" + introduction + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Attraction that = (Attraction) o;
        return id == that.id &&
                name.equals(that.name) &&
                introduction.equals(that.introduction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, introduction);
    }

    public Attraction(int id, String name, String introduction) {
        this.id = id;
        this.name = name;
        this.introduction = introduction;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
}