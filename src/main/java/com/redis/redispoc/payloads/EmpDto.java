
package com.redis.redispoc.payloads;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpDto {

    private String empId;

    private String firstName;

    private String lastName;

    private String designation;

    private String labNo;

}