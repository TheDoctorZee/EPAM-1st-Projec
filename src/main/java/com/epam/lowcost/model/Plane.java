package com.epam.lowcost.model;

import lombok.*;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Plane {
    private long id;
    private String model;
    private int businessPlacesNumber;
    private int economPlacesNumber;
}
