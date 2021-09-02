package com.mohsinkd786.mapper;

import com.mohsinkd786.data.entities.Address;
import com.mohsinkd786.data.entities.Credentials;
import com.mohsinkd786.data.entities.Customer;
import com.mohsinkd786.dtos.AddressDto;
import com.mohsinkd786.dtos.CustomerDto;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class CustomerMapper extends ConfigurableMapper {
    @Override
    protected void configure(MapperFactory factory) {

        factory.registerClassMap(
                factory.classMap(CustomerDto.class, Customer.class)
                        .fieldAToB("username", "credentials.username")
                        .fieldAToB("password", "credentials.password")
                        .byDefault()
                        .field("addresses{city}","addresses{city}")
                        .field("addresses{streetName}","addresses{city}")
                        .field("addresses{}","addresses{city}")
                        .toClassMap());

        factory.registerClassMap(
                factory.classMap(CustomerDto.class, Credentials.class)
                        .byDefault());
    }

}

class AddressCustomMapper extends CustomMapper<AddressDto,Address>{
    @Override
    public void mapAtoB(AddressDto addressDto,Address address, MappingContext context) {
        addressDto.setCity(address.getCity());
        addressDto.setPinCode(address.getZipCode());
        addressDto.setStreetName(address.getStreet());
    }

    @Override
    public void mapBtoA(Address address, AddressDto addressDto, MappingContext context) {
        address.setCity(addressDto.getCity());
        address.setStreet(addressDto.getStreetName());
        address.setZipCode(addressDto.getPinCode());
    }
}
