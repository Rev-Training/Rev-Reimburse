package com.example.demo.controller;

import com.example.demo.exception.ApplicationException;
import com.example.demo.pojo.ViewRequestPojo;
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
@RequestMapping("api/manager-reqs")

public class ManagerReqsController {
    @GetMapping
    List<ViewRequestPojo> getAllRequests() throws ApplicationException {
        return null;
    }

    @GetMapping("{bid}")
    List<ViewRequestPojo> getEmployeeRequests(@PathVariable("bid") int employeeID) throws ApplicationException {
        return null;
    }

    @PutMapping
    ViewRequestPojo updateRequest(@RequestBody ViewRequestPojo request) throws ApplicationException {
        return null;
    }

    @GetMapping("pending")
    List<ViewRequestPojo> getPendingReqs() throws ApplicationException {
        return null;
    }
    @GetMapping("denied")
    List<ViewRequestPojo> getDeniedReqs() throws ApplicationException {
        return null;
    }
    @GetMapping("approved")
    List<ViewRequestPojo> getApprovedReqs() throws ApplicationException {
        return null;
    }

}
