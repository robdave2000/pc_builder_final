package com.davis.pcbuilderserver.entities;

import com.davis.pcbuilderserver.dtos.CaseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "cases")
@Data
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "Case_sequence", initialValue = 93)
public class Case {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Case_sequence")
    private Long id;

    @Column(name = "brand")
    private String brand;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "color")
    private String color;

    @Column(name = "price")
    private String price;

    @Column(name = "amazon_link")
    private String amazonLink;

    @Override
    public String toString() {
        return "Case{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", color='" + color + '\'' +
                ", price='" + price + '\'' +
                ", amazonLink='" + amazonLink + '\'' +
                '}';
    }

    public Case (CaseDto caseDto)
    {
        this.id = caseDto.getId();
        this.brand = caseDto.getBrand();
        this.name = caseDto.getName();
        this.type = caseDto.getType();
        this.color = caseDto.getColor();
        this.price = caseDto.getPrice();
        this.amazonLink = caseDto.getAmazonLink();
    }
}