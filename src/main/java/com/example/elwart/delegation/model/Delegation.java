package com.example.elwart.delegation.model;


import com.example.elwart.delegation.transport.Transport;
import com.example.elwart.user.model.User;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

@Entity
@Table(name="delegation")
public class Delegation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "delegation_id")
    private Long id;
    @Column
    private String description;
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime dateTimeStart;
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date dateTimeStop;
    private Integer breakfastNumber = 0;
    private Integer dinnerNumber = 0;
    private Integer supperNumber =0;
    private Transport transportType;
    private Double ticketPrice;
    private Integer autoCapacity;
    private Double km;
    private Double accomodationPrice;
    private Double otherTicketsPrice;
    private String otherOutlayDesc;
    private Double otherOutlayPrice;
    @ManyToOne(fetch=FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name="user_id")
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDateTimeStart() {
        return dateTimeStart;
    }

    public void setDateTimeStart(LocalDateTime dateTimeStart) {
        this.dateTimeStart = dateTimeStart;
    }

    public Date getDateTimeStop() {
        return dateTimeStop;
    }

    public void setDateTimeStop(Date dateTimeStop) {
        this.dateTimeStop = dateTimeStop;
    }

    public Integer getBreakfastNumber() {
        return breakfastNumber;
    }

    public void setBreakfastNumber(Integer breakfastNumber) {
        this.breakfastNumber = breakfastNumber;
    }

    public Integer getDinnerNumber() {
        return dinnerNumber;
    }

    public void setDinnerNumber(Integer dinnerNumber) {
        this.dinnerNumber = dinnerNumber;
    }

    public Integer getSupperNumber() {
        return supperNumber;
    }

    public void setSupperNumber(Integer supperNumber) {
        this.supperNumber = supperNumber;
    }

    public Transport getTransportType() {
        return transportType;
    }

    public void setTransportType(Transport transportType) {
        this.transportType = transportType;
    }

    public Double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(Double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public Integer getAutoCapacity() {
        return autoCapacity;
    }

    public void setAutoCapacity(Integer autoCapacity) {
        this.autoCapacity = autoCapacity;
    }

    public Double getKm() {
        return km;
    }

    public void setKm(Double km) {
        this.km = km;
    }

    public Double getAccomodationPrice() {
        return accomodationPrice;
    }

    public void setAccomodationPrice(Double accomodationPrice) {
        this.accomodationPrice = accomodationPrice;
    }

    public Double getOtherTicketsPrice() {
        return otherTicketsPrice;
    }

    public void setOtherTicketsPrice(Double otherTicketsPrice) {
        this.otherTicketsPrice = otherTicketsPrice;
    }

    public String getOtherOutlayDesc() {
        return otherOutlayDesc;
    }

    public void setOtherOutlayDesc(String otherOutlayDesc) {
        this.otherOutlayDesc = otherOutlayDesc;
    }

    public Double getOtherOutlayPrice() {
        return otherOutlayPrice;
    }

    public void setOtherOutlayPrice(Double otherOutlayPrice) {
        this.otherOutlayPrice = otherOutlayPrice;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
