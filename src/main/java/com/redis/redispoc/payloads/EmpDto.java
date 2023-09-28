
package com.redis.redispoc.payloads;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpDto {

    @NotEmpty
    private String empId;

    private String firstName;

    private String lastName;

    private String designation;

    private String labNo;

}