package com.example.demo.service;

import com.example.demo.dao.RequestRepositoryDao;
import com.example.demo.entity.Request;
import com.example.demo.exception.ApplicationException;
import com.example.demo.pojo.RequestPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RequestServiceImpl implements RequestService{

    @Autowired
    RequestRepositoryDao requestRepositoryDao;

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
        RequestPojo requestPojo = null;

        Optional<Request> optional = this.requestRepositoryDao.findById(reqID);
        if(optional.isPresent()) {
            Request request = optional.get();
            requestPojo = new RequestPojo(  request.getReqID(), request.getEmpID(), request.getDescription(), request.getCost(), request.getPurchaseDate(),
                                            request.getRequestDate(), request.getStatus(), request.getReceiptPic());
        }
        return requestPojo;
    }

    @Override
    public void exitApplication() {

    }
}
