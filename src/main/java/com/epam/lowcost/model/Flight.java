package com.epam.lowcost.model;

import lombok.*;

import java.util.Date;

@Data
@ToString (exclude = {"id"})
@NoArgsConstructor
@AllArgsConstructor
public class Flight {
    private long id;
    private long initiatedPrice;
    private Date departureDate;
    private Date arrivalDate;
}
