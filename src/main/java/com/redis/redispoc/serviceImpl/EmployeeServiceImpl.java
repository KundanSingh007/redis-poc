package com.redis.redispoc.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redis.redispoc.bean.EmployeeBean;
import com.redis.redispoc.exception.ResourceNotFoundException;
import com.redis.redispoc.payloads.EmpDto;
import com.redis.redispoc.repository.EmployeeRepository;
import com.redis.redispoc.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository empRepo;

    @Autowired
    private ModelMapper modelMapper;

    // @Autowired
    // private RedisTemplate template;

    public static final String HASH_KEY = "Employee";


    /**
     * fetch the list of emp
     */
    @Override
    public List<EmpDto> getAllEmp() {
         List<EmployeeBean> empBeans = this.empRepo.findAll();
         List<EmpDto> empDtos = empBeans.stream().map(empBean->this.empToDto(empBean)).collect(Collectors.toList());
         return empDtos;
       // return template.opsForHash().values(HASH_KEY);

    }

    
    /**
     * delete the User By Id
     */

    @Override
    public void deleteUser(String Id) {
        EmployeeBean employeeBean = this.empRepo.findById(Id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee Not Found with the Id:","Id",Id));
        this.empRepo.delete(employeeBean);

    }


    /**
     * get Single Emp data by its Id
     */
    @Override
    public EmpDto getEmpById(String Id) {
    
         EmployeeBean empBeans = this.empRepo.findById(Id).orElseThrow(()->new ResourceNotFoundException("Emp Not Found: ", "Id", Id));
    
         return this.empToDto(empBeans);
      //  return (EmpDto) template.opsForHash().get(HASH_KEY,Id);


    }

    /*
     * model mappers
     */

    private EmployeeBean dtoToEmp(EmpDto empDto) {
        EmployeeBean employeeBean = this.modelMapper.map(empDto, EmployeeBean.class);
        return employeeBean;
    }

    private EmpDto empToDto(EmployeeBean empBeans) {

        EmpDto empDto = this.modelMapper.map(empBeans, EmpDto.class);
        return empDto;
    }



    

}
