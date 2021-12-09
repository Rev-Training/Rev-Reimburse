package com.example.demo.controller;

import com.example.demo.exception.ApplicationException;
import com.example.demo.pojo.RequestPojo;

import com.example.demo.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/employee-reqs")
public class EmployeeReqsController {

    @Autowired
    RequestService requestService;

    @PostMapping()
    RequestPojo addRequest(@RequestBody RequestPojo request) throws ApplicationException {
        return null;
    }

    @GetMapping("{bid}")
    List<RequestPojo> getEmployeeRequests(@PathVariable("bid") int employeeID) throws ApplicationException {
        return null;
    }

    @GetMapping("req/{bid}")
    RequestPojo getRequest(@PathVariable("bid") int reqID) throws ApplicationException {
        return requestService.getARequest(reqID);
    }
}
