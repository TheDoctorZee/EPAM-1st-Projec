package com.epam.lowcost.model;

import lombok.*;

import java.util.Date;

@Data
@ToString (exclude = {"id"})
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {
    private long id;
    private User user;
    private Flight flight;
    private boolean isBusiness;
    private boolean hasLuggage;
    private boolean placeChoice;
    private Date departureDate;
    private Date arrivalDate;
    private long price;
}
