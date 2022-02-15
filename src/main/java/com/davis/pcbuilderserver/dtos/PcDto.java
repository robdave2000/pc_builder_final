package com.davis.pcbuilderserver.dtos;

import com.davis.pcbuilderserver.entities.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PcDto implements Serializable {
    private Long id;

    private CaseDto casw;

    private CpuCoolerDto cpuCooler;

    private CpuDto cpu;

    private GpuDto gpu;

    private MotherboardDto motherboard;

    private PsuDto psu;

    private RamDto ram;

    private StorageDto storage;

    public PcDto(Pc pc){
        this.id = pc.getId();
        if (pc.getStorage() != null){
            this.storage = pc.getStorage();
        }
        if (pc.getRam()!=null){
            this.ram = pc.getRam();
        }
        if (pc.getCpu()!=null){
            this.cpu = pc.getCpu();
        }
        if (pc.getCpuCooler()!=null){
            this.cpuCooler = pc.getCpuCooler();
        }
        if (pc.getGpu()!=null){
            this.gpu = pc.getGpu();
        }
        if (pc.getPcCase()!=null){
            this.casw = pc.getPcCase();
        }
        if (pc.getPsu()!=null){
            this.psu = pc.getPsu();
        }
        if (pc.getMotherboard()!=null){
            this.motherboard = pc.getMotherboard();
        }
    }
}
