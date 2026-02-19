package org.example.onlineshop.DTO;

import jakarta.persistence.*;
import org.example.onlineshop.Entity.City;

import java.util.List;

public class ProvinceDTO {

    private String name;

    private List<CityDTO> cities;


}
