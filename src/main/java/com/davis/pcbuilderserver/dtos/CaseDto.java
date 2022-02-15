package com.davis.pcbuilderserver.dtos;

import com.davis.pcbuilderserver.entities.Case;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CaseDto implements Serializable {
    private Long id;

    private String brand;

    private String name;

    private String type;

    private String color;

    private String price;

    private String amazonLink;

    public CaseDto(Case casw)
    {
        this.id = casw.getId();
        this.brand = casw.getBrand();
        this.name = casw.getName();
        this.type = casw.getType();
        this.color = casw.getColor();
        this.price = casw.getPrice();
        this.amazonLink = casw.getAmazonLink();
    }
}
