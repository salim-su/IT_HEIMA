package com.powernode.domain;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
