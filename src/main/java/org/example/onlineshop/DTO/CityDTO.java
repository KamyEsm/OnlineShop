package org.example.onlineshop.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.onlineshop.Entity.Province;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CityDTO {

    private String name;

    private ProvinceDTO province;

    private List<AddressDTO> addresses;

}
