package com.uskoryaev.travelbot.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CityDTO {
    Long cityId;
    String name;
    String description;
    String recommendation;
}
