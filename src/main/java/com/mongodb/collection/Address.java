package com.mongodb.collection;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Document(collection = "Addresses")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Address {

    @Id
    private String address_Id;

    @NotBlank(message = "Address is a required field")
    @Size(min = 2, max = 20, message = "Address should be between 2 and 20 characters")
    private String address1;

    private String address2;

    @NotBlank(message = "City is a required field")
    @Size(min = 2, max = 15, message = "Address should be between 2 and 15 characters")
    private String city;
}