
package com.redis.redispoc.bean;

import java.io.Serializable;

import org.springframework.data.redis.core.RedisHash;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("Employee")
@Entity
@Table(name = "Employee")
public class EmployeeBean implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)   
    private String empId;

    @Column(name = "First_Name")
    private String firstName;

    @Column(name = "Last_Name")
    private String lastName;
    @Column(name = "Designation")
    private String designation;

    @Column(name = "labNo")
    private String labNo;

}