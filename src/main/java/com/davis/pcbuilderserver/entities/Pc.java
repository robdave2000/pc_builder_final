package com.davis.pcbuilderserver.entities;

import com.davis.pcbuilderserver.dtos.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Pcs")
public class Pc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;
    private StorageDto storage;
    private RamDto ram;
    private PsuDto psu;
    private MotherboardDto motherboard;
    private CpuDto cpu;
    private CpuCoolerDto cpuCooler;
    private GpuDto gpu;
    private CaseDto pcCase;

    @JsonBackReference
    @ManyToMany(mappedBy = "pcSet")
    @EqualsAndHashCode.Exclude
    Set<User> userSet = new HashSet<>();
}
