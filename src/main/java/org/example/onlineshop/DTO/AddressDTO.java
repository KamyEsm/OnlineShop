package org.example.onlineshop.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.example.onlineshop.Entity.City;

public class AddressDTO {
    private String address;

    private Integer licensePlate;

    private Integer unit;

    private String postalCode;

    private EmployeeDTO user;

    private CityDTO city;
}
