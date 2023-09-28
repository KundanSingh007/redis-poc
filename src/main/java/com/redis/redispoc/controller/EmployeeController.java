package com.redis.redispoc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.redis.redispoc.payloads.EmpDto;
import com.redis.redispoc.service.EmployeeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@EnableCaching
@RestController
@RequestMapping("/api/v1/emp-status")
@CrossOrigin("*")
public class EmployeeController {

    @Autowired
    private EmployeeService empService;

    /**
     * Fetch list of emp
     */
    @Operation(summary = "This is to fetch the details of All the Employee of Indigo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Details of All the Employee's ", content = {
                    @Content(mediaType = "application/json") }) })
    @GetMapping("/fetch-all")
    private ResponseEntity<List<EmpDto>> fetchAll() {
        return ResponseEntity.ok(this.empService.getAllEmp());
    }

    /**
     * 
     * @param Id
     * @return emp on the basis of Id
     * @throws Exception
     */
    @Operation(summary = "This is to fetch the employee on the basis of Id")
    @Cacheable(key = "#id", value = "Employee", unless = "#result.price > 1000")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Details of the employee Found", content = {
                    @Content(mediaType = "application/json") }) })
    @GetMapping("fetch-all/{Id}")
    public ResponseEntity<EmpDto> fetchById(@PathVariable("Id") String Id) throws Exception {
        return ResponseEntity.ok(empService.getEmpById(Id));
    }

    /**
     * * @param Id
     * 
     * @return delete by id
     */
    @DeleteMapping("/delete/{Id}")
    public ResponseEntity<?> deleteEmpById(@PathVariable("Id") String Id) {

        try {
            this.empService.deleteUser(Id);
            return new ResponseEntity("Product Delete Successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
