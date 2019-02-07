package com.epam.lowcost.model;

import java.math.BigInteger;
import java.util.Date;
import java.util.Objects;

public class Ticket {
    private int id;
    private User user;
    private Flight flight;
    private boolean isBusiness;
    private boolean hasLuggage;
    private boolean placeChoice;
    private Date departureDate;
    private Date arrivalDate;
    private BigInteger price;

    public Ticket() {
    }

    public Ticket(int id, User user, Flight flight, boolean isBusiness, boolean hasLuggage, boolean placeChoice, Date departureDate,
            Date arrivalDate, BigInteger price) {
        this.id = id;
        this.user = user;
        this.flight = flight;
        this.isBusiness = isBusiness;
        this.hasLuggage = hasLuggage;
        this.placeChoice = placeChoice;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public boolean isBusiness() {
        return isBusiness;
    }

    public void setBusiness(boolean business) {
        isBusiness = business;
    }

    public boolean isHasLuggage() {
        return hasLuggage;
    }

    public void setHasLuggage(boolean hasLuggage) {
        this.hasLuggage = hasLuggage;
    }

    public boolean isPlaceChoice() {
        return placeChoice;
    }

    public void setPlaceChoice(boolean placeChoice) {
        this.placeChoice = placeChoice;
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

    public BigInteger getPrice() {
        return price;
    }

    public void setPrice(BigInteger price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return id == ticket.id &&
                isBusiness == ticket.isBusiness &&
                hasLuggage == ticket.hasLuggage &&
                placeChoice == ticket.placeChoice &&
                user.equals(ticket.user) &&
                flight.equals(ticket.flight) &&
                departureDate.equals(ticket.departureDate) &&
                arrivalDate.equals(ticket.arrivalDate) &&
                price.equals(ticket.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, flight, isBusiness, hasLuggage, placeChoice, departureDate, arrivalDate, price);
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", user=" + user +
                ", flight=" + flight +
                ", isBusiness=" + isBusiness +
                ", hasLuggage=" + hasLuggage +
                ", placeChoice=" + placeChoice +
                ", departureDate=" + departureDate +
                ", arrivalDate=" + arrivalDate +
                ", price=" + price +
                '}';
    }
}
