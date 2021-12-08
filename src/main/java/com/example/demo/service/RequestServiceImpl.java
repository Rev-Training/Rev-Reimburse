package com.example.demo.service;

import com.example.demo.exception.ApplicationException;
import com.example.demo.pojo.RequestPojo;

import java.util.List;

public class RequestServiceImpl implements RequestService{

    @Override
    public RequestPojo addRequest(RequestPojo request) throws ApplicationException {
        return null;
    }

    @Override
    public RequestPojo updateRequest(RequestPojo request) throws ApplicationException {
        return null;
    }

    @Override
    public boolean deleteRequest(int reqID) throws ApplicationException {
        return false;
    }

    @Override
    public List<RequestPojo> getAllRequests() throws ApplicationException {
        return null;
    }

    @Override
    public RequestPojo getARequest(int reqID) throws ApplicationException {
        return null;
    }

    @Override
    public void exitApplication() {

    }
}
