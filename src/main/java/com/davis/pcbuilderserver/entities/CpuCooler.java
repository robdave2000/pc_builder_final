package com.davis.pcbuilderserver.entities;

import com.davis.pcbuilderserver.dtos.CpuCoolerDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "cpuCoolers")
@Data
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "CpuCooler_sequence", initialValue = 35)
public class CpuCooler {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CpuCooler_sequence")
    private Long id;

    private String company;

    private String name;

    private String type;

    private String radiator;

    private String price;

    private String amazonLink;

    @Override
    public String toString() {
        return "pcbuilder.CPU_Cooler{" +
                "id=" + id +
                ", company='" + company + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", radiator='" + radiator + '\'' +
                ", price='" + price + '\'' +
                ", amazonLink='" + amazonLink + '\'' +
                '}';
    }

    public CpuCooler (CpuCoolerDto cpuCoolerDto)
    {
        this.id = cpuCoolerDto.getId();
        this.company = cpuCoolerDto.getCompany();
        this.name = cpuCoolerDto.getName();
        this.type = cpuCoolerDto.getType();
        this.radiator = cpuCoolerDto.getRadiator();
        this.price = cpuCoolerDto.getPrice();
        this.amazonLink = cpuCoolerDto.getAmazonLink();
    }
}
