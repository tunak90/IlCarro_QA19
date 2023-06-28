package models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@Builder
@ToString

public class Car {
    String location;
    String make;
    String model;
    String year;
    String fuel;
    String seats;
    String carClass;
    String carRegNumber;
    String price;

}
