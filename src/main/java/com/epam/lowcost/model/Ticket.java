package com.epam.lowcost.model;

import lombok.*;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {
    private long id;
    private User user;
    private Flight flight;
    private boolean isBusiness;
    private boolean hasLuggage;
    private boolean placePriority;
    private long price;
}
