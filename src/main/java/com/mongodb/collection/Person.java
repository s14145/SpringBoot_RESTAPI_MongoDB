package com.mongodb.collection;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Document(collection = "Persons")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Person {

    @Id
    private String person_Id;

    @Field
    @Indexed(unique = true)
    @NotBlank(message = "Firstname is a required field.")
    @Size(max = 20, message = "Firstname shouldn't exceed 20 characters")
    private String firstName;

    @Field
    @NotBlank(message = "Lastname is a required field.")
    @Size(max = 20, message = "Lastname shouldn't exceed 20 characters")
    private String lastName;

    @Field
    @NotBlank(message = "Age is a required field.")
    private Integer age;

    @Field
    private List<String> hobbies;

    private List<Address>  addressList;
}