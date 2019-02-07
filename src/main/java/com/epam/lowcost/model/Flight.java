package com.epam.lowcost.model;

import java.math.BigInteger;
import java.util.Date;
import java.util.Objects;

public class Flight {
    private int id;
    private BigInteger initiatedPrice;
    private Date departureDate;
    private Date arrivalDate;

    public Flight() {
    }

    public Flight(int id, BigInteger initiatedPrice, Date departureDate, Date arrivalDate) {
        this.id = id;
        this.initiatedPrice = initiatedPrice;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigInteger getInitiatedPrice() {
        return initiatedPrice;
    }

    public void setInitiatedPrice(BigInteger initiatedPrice) {
        this.initiatedPrice = initiatedPrice;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return id == flight.id &&
                initiatedPrice.equals(flight.initiatedPrice) &&
                departureDate.equals(flight.departureDate) &&
                arrivalDate.equals(flight.arrivalDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, initiatedPrice, departureDate, arrivalDate);
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", initiatedPrice=" + initiatedPrice +
                ", departureDate=" + departureDate +
                ", arrivalDate=" + arrivalDate +
                '}';
    }
}
