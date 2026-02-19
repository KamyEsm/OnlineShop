package org.example.onlineshop.DTO;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.onlineshop.Entity.City;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProvinceDTO {

    private String name;

    private List<CityDTO> cities;


}
