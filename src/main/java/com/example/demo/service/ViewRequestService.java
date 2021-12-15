package com.example.demo.service;

import com.example.demo.entity.ViewRequest;
import com.example.demo.enums.RequestStatus;
import com.example.demo.exception.ApplicationException;
import com.example.demo.pojo.ViewRequestPojo;

import java.util.List;

public interface ViewRequestService {
    ViewRequestPojo updateRequest(ViewRequestPojo request) throws ApplicationException;
    List<ViewRequestPojo> getAllRequests() throws ApplicationException;
    ViewRequestPojo getARequest(int reqID) throws ApplicationException;
    List<ViewRequestPojo> getEmployeeRequests(int empID) throws ApplicationException;
    List<ViewRequestPojo> getStatusRequests(RequestStatus status);


    void exitApplication();

}
