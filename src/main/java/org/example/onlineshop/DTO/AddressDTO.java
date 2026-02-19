package org.example.onlineshop.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.onlineshop.Entity.City;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {
    private String address;

    private Integer licensePlate;

    private Integer unit;

    private String postalCode;

    private EmployeeDTO user;

    private CityDTO city;
}
