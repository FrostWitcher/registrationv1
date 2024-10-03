package com.api;

import com.api.payload.EmployeeDto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
public class A {

    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee(1, "Alokesh"),
                new Employee(2, "Naba"),
                new Employee(3, "Somenath")
        );
         //Lambda
      //  List<EmployeeDto> dtos = employees.stream().map(e -> mapToDto(e)).collect(Collectors.toList());
        //Method Reference
        List<EmployeeDto> dtos = employees.stream().map(A::mapToDto).collect(Collectors.toList());

    }
    
   static EmployeeDto mapToDto(Employee employee){
        
        EmployeeDto dto = new EmployeeDto();
        dto.setId(employee.getId());
        dto.setName(employee.getName());
        return dto;
    }
}
