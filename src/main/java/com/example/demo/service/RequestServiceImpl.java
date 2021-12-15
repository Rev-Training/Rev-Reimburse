package com.example.demo.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.example.demo.dao.RequestRepositoryDao;

import com.example.demo.entity.Request;
import com.example.demo.entity.User;
import com.example.demo.enums.RequestStatus;
import com.example.demo.exception.ApplicationException;
import com.example.demo.pojo.RequestPojo;
import com.example.demo.pojo.UserPojo;
import com.example.demo.pojo.ViewRequestPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RequestServiceImpl implements RequestService{
	
	private static final Logger logger = LogManager.getLogger(RequestServiceImpl.class);
	
    @Autowired
    RequestRepositoryDao requestRepositoryDao;

    @Override
    public RequestPojo addRequest(RequestPojo request) throws ApplicationException {
    	
    	logger.info("Entered addRequest() in service");
        Request newRequest = new Request(  request.getReqID(), request.getEmpID(), request.getDescription(), request.getCost(), request.getPurchaseDate(), 
                                          request.getStatus(), request.getReceiptPic());
        Request returnRequest = requestRepositoryDao.saveAndFlush(newRequest);
        request.setReqID(returnRequest.getReqID());
    	logger.info("Exited addRequest() in service");
        return request;
    }

    @Override
    public RequestPojo updateRequest(RequestPojo request) throws ApplicationException {
    	logger.info("Entered updateRequest() in service");
        Request updateRequest = new Request( request.getReqID(), request.getEmpID(), request.getDescription(), request.getCost(), request.getPurchaseDate(),
                request.getRequestDate(), request.getStatus(), request.getReceiptPic());
        Request returnRequest = requestRepositoryDao.save(updateRequest);
    	logger.info("Exited addRequest() in service");
        return request;
    }

    @Override
    public boolean deleteRequest(int reqID) throws ApplicationException {
    	logger.info("Entered deleteRequest() in service");
    	logger.info("Exited deleteRequest() in service");
        return false;
    }

    @Override
    public List<RequestPojo> getAllRequests() throws ApplicationException {
    	logger.info("Entered getAllRequest() in service");
        List<Request> allRequestsEntity = this.requestRepositoryDao.findAll();
        List<RequestPojo> allRequestsPojo = new ArrayList<RequestPojo>();
        allRequestsEntity.forEach((request) -> {
            RequestPojo requestPojo = new RequestPojo( request.getReqID(), request.getEmpID(), request.getDescription(), request.getCost(), request.getPurchaseDate(),
                    request.getRequestDate(), request.getStatus(), request.getReceiptPic());

            allRequestsPojo.add(requestPojo);
        	logger.info("Entered getAllRequest() in service");
        });
        return allRequestsPojo;


    }

    @Override
    public RequestPojo getARequest(int reqID) throws ApplicationException {
    	logger.info("Entered getARequest() in service");
        RequestPojo requestPojo = null;

        Optional<Request> optional = this.requestRepositoryDao.findById(reqID);
        if(optional.isPresent()) {
            Request request = optional.get();
            requestPojo = new RequestPojo(  request.getReqID(), request.getEmpID(), request.getDescription(), request.getCost(), request.getPurchaseDate(),
                                            request.getRequestDate(), request.getStatus(), request.getReceiptPic());
        	logger.info("Exited getARequest() in service");
        }
        return requestPojo;
    }

    @Override
    public List<RequestPojo> getEmployeeRequests(int empID) throws ApplicationException {
    	logger.info("Entered getEmployeeRequests() in service");
        List<Request> allRequestsEntity = this.requestRepositoryDao.findByEmpID(empID);
        List<RequestPojo> allRequestsPojo = new ArrayList<RequestPojo>();
        allRequestsEntity.forEach((request) -> {
            RequestPojo requestPojo = new RequestPojo( request.getReqID(), request.getEmpID(), request.getDescription(), request.getCost(), request.getPurchaseDate(),
                    request.getRequestDate(), request.getStatus(), request.getReceiptPic());

            allRequestsPojo.add(requestPojo);
        	logger.info("Entered getEmployeeRequests() in service");
        });
        return allRequestsPojo;
    }

    @Override
    public List<RequestPojo> getStatusRequests(RequestStatus requestStatus) throws ApplicationException {
    	logger.info("Entered getStatusRequests() in service");
        List<Request> allRequestsEntity = this.requestRepositoryDao.findByStatus(requestStatus);
        List<RequestPojo> allRequestsPojo = new ArrayList<RequestPojo>();
        allRequestsEntity.forEach((request) -> {
            RequestPojo requestPojo = new RequestPojo( request.getReqID(), request.getEmpID(), request.getDescription(), request.getCost(), request.getPurchaseDate(),
                    request.getRequestDate(), request.getStatus(), request.getReceiptPic());

            allRequestsPojo.add(requestPojo);
        	logger.info("Entered getStatusRequest() in service");
        });
        return allRequestsPojo;
    }

    @Override
    public void exitApplication() {

    }
}
