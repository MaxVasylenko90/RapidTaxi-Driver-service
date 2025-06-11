package dev.mvasylenko.rapidtaxidriverservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    private String name;

    @NotBlank(message = "Email is required")
    @Column(unique = true, nullable = false)
    @Email(message = "Email must be valid")
    private String email;

    @NotBlank
    private String password;

    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "^[0-9]{9}$", message = "Number should contain only 9 digits from 0 to 9")
    private String phoneNumber;

    @NotBlank
    private String licence;

    @NotNull
    @OneToOne
    @JoinColumn(name = "car_id")
    private Car car;

    @OneToMany(mappedBy = "driver")
    private List<Ride> rides = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "salary_id")
    private Salary salary;




}
