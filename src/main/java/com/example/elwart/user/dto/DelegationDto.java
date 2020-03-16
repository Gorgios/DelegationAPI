package com.example.elwart.user.dto;

import com.example.elwart.user.transport.Transport;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.time.LocalDateTime;

public class DelegationDto {
    private String description;
    private LocalDateTime dateTimeStart;
    private LocalDateTime dateTimeStop;
    private Double travelDietAmount = 30D;
    private Integer breakfastNumber = 0;
    private Integer dinnerNumber = 0;
    private Integer supperNumber =0;
    private Transport transportType;
    private Double ticketPrice;
    private Integer autoCapacity;
    private Double km;
    private Double accommodationPrice;
    private Double otherTicketsPrice;
    private String otherOutlayDesc;
    private Double otherOutlayPrice;

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

    public LocalDateTime getDateTimeStop() {
        return dateTimeStop;
    }

    public void setDateTimeStop(LocalDateTime dateTimeStop) {
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

    public Double getTravelDietAmount() {
        return travelDietAmount;
    }

    public void setTravelDietAmount(Double travelDietAmount) {
        this.travelDietAmount = travelDietAmount;
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

    public Double getAccommodationPrice() {
        return accommodationPrice;
    }

    public void setAccommodationPrice(Double accommodationPrice) {
        this.accommodationPrice = accommodationPrice;
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
}
