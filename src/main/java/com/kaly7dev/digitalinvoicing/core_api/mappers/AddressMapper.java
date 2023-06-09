package com.kaly7dev.digitalinvoicing.core_api.mappers;

import com.kaly7dev.digitalinvoicing.core_api.dtos.AddressDto;
import com.kaly7dev.digitalinvoicing.entities.Address;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {
    public Address mapToEntity(AddressDto addressDto) {
        Address address = new Address();
        address.setStreet(addressDto.getStreet());
        address.setCity(addressDto.getCity());
        address.setCountry(addressDto.getCountry());
        address.setZipCode(addressDto.getZipCode());
        return address;
    }
    public AddressDto maptoDto(Address address){
        AddressDto addressDto = new AddressDto();
        addressDto.setAddId(address.getAddId());
        addressDto.setStreet(address.getStreet());
        addressDto.setCity(address.getCity());
        addressDto.setCountry(address.getCountry());
        addressDto.setZipCode(address.getZipCode());
        return addressDto;
    }
}
