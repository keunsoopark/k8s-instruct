package com.okta.spring.springbootkbe;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@AllArgsConstructor     // generates a constructor with 1 parameter for each field in your class
@NoArgsConstructor      // generate a constructor with no parameters
public class Kayak {

    private String name;
    private String owner;
    private Number value;
    private String makeModel;

}
