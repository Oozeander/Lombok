package org.example.model;

import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

@Builder
@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
@FieldDefaults(level = AccessLevel.PRIVATE) // makeFinal
@Accessors(fluent = true)
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Person {

    @EqualsAndHashCode.Include
    String firstName, lastName;

    @ToString.Exclude
    int age;
}
