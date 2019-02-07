package com.epam.lowcost.model;

import java.util.Objects;

public class Plane {
    private int id;
    private String model;
    private int businessPlaces;
    private int economPlaces;

    public Plane() {
    }

    public Plane(int id, String model, int businessPlaces, int economPlaces) {
        this.id = id;
        this.model = model;
        this.businessPlaces = businessPlaces;
        this.economPlaces = economPlaces;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getBusinessPlaces() {
        return businessPlaces;
    }

    public void setBusinessPlaces(int businessPlaces) {
        this.businessPlaces = businessPlaces;
    }

    public int getEconomPlaces() {
        return economPlaces;
    }

    public void setEconomPlaces(int economPlaces) {
        this.economPlaces = economPlaces;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plane plane = (Plane) o;
        return id == plane.id &&
                businessPlaces == plane.businessPlaces &&
                economPlaces == plane.economPlaces &&
                model.equals(plane.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, model, businessPlaces, economPlaces);
    }

    @Override
    public String toString() {
        return "Plane{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", businessPlaces=" + businessPlaces +
                ", economPlaces=" + economPlaces +
                '}';
    }
}
