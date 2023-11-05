package com.mpcortez.dscomponente.entities;

import lombok.*;

import java.io.Serializable;

@Data
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Order implements Serializable {

    @EqualsAndHashCode.Include
    private Integer code;

    private Double basic;

    private Double discount;
}
