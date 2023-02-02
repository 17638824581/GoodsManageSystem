package com.xty.bean;

public class Goods {
    private int id;
    private String name;
    private double prise;
    private int count;

    public Goods() {
    }

    public Goods(int id, String name, double prise, int count) {
        this.id = id;
        this.name = name;
        this.prise = prise;
        this.count = count;
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

    public double getPrise() {
        return prise;
    }

    public void setPrise(double prise) {
        this.prise = prise;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", prise=" + prise +
                ", count=" + count +
                '}';
    }
}
