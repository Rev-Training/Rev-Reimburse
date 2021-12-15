package com.example.demo.service;

import com.example.demo.enums.RequestStatus;
import com.example.demo.exception.ApplicationException;
import com.example.demo.pojo.RequestPojo;
import com.example.demo.pojo.ViewRequestPojo;

import java.util.List;

public interface RequestService {
    RequestPojo addRequest(RequestPojo request) throws ApplicationException;
    RequestPojo updateRequest(RequestPojo request) throws ApplicationException;
    boolean deleteRequest(int reqID) throws ApplicationException;
    List<RequestPojo> getAllRequests() throws ApplicationException;
    RequestPojo getARequest(int reqID) throws ApplicationException;
    List<RequestPojo> getEmployeeRequests(int empID) throws ApplicationException;
    List<RequestPojo> getStatusRequests(RequestStatus requestStatus) throws ApplicationException;


    void exitApplication();

}
