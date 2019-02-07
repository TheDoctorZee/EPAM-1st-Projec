package com.epam.lowcost.model;

import lombok.*;

@Data
@ToString (exclude = {"id"})
@NoArgsConstructor
@AllArgsConstructor
public class Plane {
    private long id;
    private String model;
    private int businessPlaces;
    private int economPlaces;
}
