package com.example.elwart.user.service;

import com.example.elwart.user.dto.DelegationDto;
import com.example.elwart.user.exception.*;
import com.example.elwart.user.model.Delegation;
import com.example.elwart.user.model.User;
import com.example.elwart.user.repository.DelegationRepository;
import com.example.elwart.user.repository.UserRepository;
import com.example.elwart.user.transport.Transport;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DelegationServiceImpl implements DelegationService {

    private DelegationRepository delegationRepository;
    private UserRepository userRepository;

    @Autowired
    public DelegationServiceImpl(DelegationRepository delegationRepository, UserRepository userRepository) {
        this.delegationRepository = delegationRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void addDelegation(DelegationDto delegationDto, Long userId) throws BadAutoCapacityException, NotKmException, NotTicketPriceException{
        User user = userRepository.findById(userId).orElseThrow(()->new UserNotFoundException(userId));
        Delegation delegation = Delegation.DelegationBuilder.aDelegation().withAccommodationPrice(delegationDto.getAccommodationPrice()).
                withAutoCapacity(getAutoCapacity(delegationDto.getAutoCapacity())).withBreakfastNumber(delegationDto.getBreakfastNumber()).
                withDateTimeStart(delegationDto.getDateTimeStart()).withDateTimeStop(delegationDto.getDateTimeStop()).
                withDescription(delegationDto.getDescription()).withDinnerNumber(delegationDto.getDinnerNumber()).
                withKm(getKm(delegationDto.getKm(),delegationDto.getTransportType())).withOtherOutlayDesc(delegationDto.getOtherOutlayDesc()).
                withOtherOutlayPrice(delegationDto.getOtherOutlayPrice()).withOtherTicketsPrice(delegationDto.getOtherTicketsPrice()).
                withSupperNumber(delegationDto.getSupperNumber()).withTicketPrice(getTicketPrice(delegationDto.getTicketPrice(),delegationDto.getTransportType())).
                withTransportType(delegationDto.getTransportType()).withTravelDietAmount(delegationDto.getTravelDietAmount()).
                withUser(user).build();
        delegationRepository.save(delegation);
    }

    @Override
    public void changeDelegation(DelegationDto delegationDto, Long delgationId) throws BadAutoCapacityException, NotKmException, NotTicketPriceException {
        Delegation delegationFromDto = Delegation.DelegationBuilder.aDelegation().withAccommodationPrice(delegationDto.getAccommodationPrice()).
                withAutoCapacity(getAutoCapacity(delegationDto.getAutoCapacity())).withBreakfastNumber(delegationDto.getBreakfastNumber()).
                withDateTimeStart(delegationDto.getDateTimeStart()).withDateTimeStop(delegationDto.getDateTimeStop()).
                withDescription(delegationDto.getDescription()).withDinnerNumber(delegationDto.getDinnerNumber()).
                withKm(getKm(delegationDto.getKm(),delegationDto.getTransportType())).withOtherOutlayDesc(delegationDto.getOtherOutlayDesc()).
                withOtherOutlayPrice(delegationDto.getOtherOutlayPrice()).withOtherTicketsPrice(delegationDto.getOtherTicketsPrice()).
                withSupperNumber(delegationDto.getSupperNumber()).withTicketPrice(getTicketPrice(delegationDto.getTicketPrice(),delegationDto.getTransportType())).
                withTransportType(delegationDto.getTransportType()).withTravelDietAmount(delegationDto.getTravelDietAmount()).build();
        Delegation delegation = delegationRepository.findById(delgationId).orElseThrow(()->new DelegationNotFoundException(delgationId));
        delegationFromDto.setId(delegation.getId());
        delegationFromDto.setUser(delegation.getUser());
        delegationRepository.save(delegationFromDto);

    }

    private Double getTicketPrice(Double ticketPrice, Transport transport) throws NotTicketPriceException {
        if (ticketPrice == null && transport.isPublicTransport())
            throw new NotTicketPriceException();
        return ticketPrice;
    }
    private Integer getAutoCapacity(Integer autoCapacity) throws BadAutoCapacityException {
        if (autoCapacity >= 1900 || autoCapacity < 900)
            throw new BadAutoCapacityException(autoCapacity);
        return autoCapacity;
    }
    private Double getKm(Double km, Transport transport) throws NotKmException{
        if (km == null && !transport.isPublicTransport())
            throw new NotKmException();
        return km;
    }
}
