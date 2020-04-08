package com.KSHRD.springsecurity4.Controller;

import com.KSHRD.springsecurity4.model.Employee;
import com.KSHRD.springsecurity4.repository.EmployeeRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/v1")
@Api( value = "Employee Management System", description = "Operations pertaining to employee in Employee ")
public class EmployeeController {


    private EmployeeRepository employeeRepository;
    @ApiOperation(value = "View a list of available employees", response = List.class)

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping("/employees")
    public String GetData(){
        return "hello";
    }


}
