package com.example.demo.controller;

import com.example.demo.enums.RequestStatus;
import com.example.demo.exception.ApplicationException;
import com.example.demo.pojo.RequestPojo;
import com.example.demo.pojo.ViewRequestPojo;
import com.example.demo.service.RequestService;
import com.example.demo.service.ViewRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/manager-reqs")
public class ManagerReqsController {

    @Autowired
    ViewRequestService viewRequestService;

//    @Autowired
//    RequestService requestService;

//    Code with ViewRequest instead of Request
    @GetMapping
    List<ViewRequestPojo> getAllRequests() throws ApplicationException {
        return viewRequestService.getAllRequests();
    }


    @GetMapping("{bid}")
    List<ViewRequestPojo> getEmployeeRequests(@PathVariable("bid") int empID) throws ApplicationException {
        return viewRequestService.getEmployeeRequests(empID);
    }

    @PutMapping
    ViewRequestPojo updateRequest(@RequestBody ViewRequestPojo request) throws ApplicationException {
        return viewRequestService.updateRequest(request);
    }

    @GetMapping("pending")
    List<ViewRequestPojo> getPendingReqs() throws ApplicationException {
        return viewRequestService.getStatusRequests(RequestStatus.PENDING);
    }
    @GetMapping("denied")
    List<ViewRequestPojo> getDeniedReqs() throws ApplicationException {
        return viewRequestService.getStatusRequests(RequestStatus.DENIED);
    }
    @GetMapping("approved")
    List<ViewRequestPojo> getApprovedReqs() throws ApplicationException {
        return viewRequestService.getStatusRequests(RequestStatus.APPROVED);
    }

}
