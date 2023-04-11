package com.github.nelsoncastro.springbootrest.api;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "PERSONS")
@NamedNativeQuery(name = "Person.findPersonNameDtoByName_Named",
                  query = "SELECT p.id, p.name FROM PERSONS p WHERE p.name = :name",
                  resultSetMapping = "Mapping.PersonDTO")
@SqlResultSetMapping(name = "Mapping.PersonDTO",
                     classes = @ConstructorResult(targetClass = com.github.nelsoncastro.springbootrest.api.PersonDTO.class,
                                                  columns = {@ColumnResult(name = "id", type = Long.class),
                                                             @ColumnResult(name = "name", type = String.class)}))
public class Person implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer age;

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Person person = (Person) o;
        return name.equals(person.name) && age.equals(person.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
