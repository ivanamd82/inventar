package com.example.inventar.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class Computer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long regNumber;

    @Column
    private String name;

    @Column
    private double price;

    @Column
    private LocalDate dateOfPurchase;

    @Column
    private String processor;

    @Column
    private LocalDate dateOfProcessorInstallation;

    @Column
    private String chipset;

    @Column
    private LocalDate dateOfChipsetInstallation;

    @Column
    private long maxMemory;

    @Column
    private long memoryInstalled;

    @Column
    private LocalDate dateOfMemoryInstallation;

    public Computer(String name, double price, LocalDate dateOfPurchase, String processor, String chipset, long maxMemory, long memoryInstalled){
        this.name = name;
        this.price = price;
        this.processor = processor;
        this.chipset = chipset;
        this.maxMemory = maxMemory;
        this.memoryInstalled = memoryInstalled;
        setDefaultDate(dateOfPurchase);
    }

    public void setDefaultDate(LocalDate dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
        dateOfProcessorInstallation = dateOfPurchase;
        dateOfChipsetInstallation = dateOfPurchase;
        dateOfMemoryInstallation = dateOfPurchase;
    }

}
