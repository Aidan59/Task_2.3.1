package spring_mvc.model;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import spring_mvc.enums.EmploymentType;

@Getter
@Setter
public class User {

    private long id;

    private String name;

    private String surname;

    private int age;

    private String email;

    private BigDecimal salary;

    private String position;

    private EmploymentType employmentType;

}
