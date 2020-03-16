package com.example.elwart.user.service;

import com.example.elwart.user.dto.DelegationDto;
import com.example.elwart.user.exception.BadAutoCapacityException;
import com.example.elwart.user.exception.NotKmException;
import com.example.elwart.user.exception.NotTicketPriceException;

public interface DelegationService {

    void addDelegation(DelegationDto delegationDto, Long userId) throws BadAutoCapacityException, NotKmException, NotTicketPriceException;
}
