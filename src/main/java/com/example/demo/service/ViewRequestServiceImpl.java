package com.example.demo.service;

import com.example.demo.dao.RequestRepositoryDao;
import com.example.demo.dao.ViewRequestRepositoryDao;
import com.example.demo.entity.Request;
import com.example.demo.entity.ViewRequest;
import com.example.demo.enums.RequestStatus;
import com.example.demo.exception.ApplicationException;
import com.example.demo.pojo.ViewRequestPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ViewRequestServiceImpl implements ViewRequestService{

    @Autowired
    ViewRequestRepositoryDao viewRequestRepositoryDao;
    @Autowired
    RequestRepositoryDao requestRepositoryDao;

    private List<ViewRequestPojo> getViewRequestPojos(List<ViewRequest> allViewRequestsEntity) {
        List<ViewRequestPojo> allViewRequestsPojo = new ArrayList<ViewRequestPojo>();
        allViewRequestsEntity.forEach((viewRequest) -> {
            ViewRequestPojo viewRequestPojo = new ViewRequestPojo( viewRequest.getReqID(), viewRequest.getEmpID(), viewRequest.getUser().getFirstName(), viewRequest.getUser().getLastName(), viewRequest.getDescription(), viewRequest.getCost(), viewRequest.getPurchaseDate(),
                    viewRequest.getRequestDate(), viewRequest.getStatus(), viewRequest.getReceiptPic());

            allViewRequestsPojo.add(viewRequestPojo);
        });

        return allViewRequestsPojo;
    }


    @Override
    public ViewRequestPojo updateRequest(ViewRequestPojo request) throws ApplicationException {
        Request updateRequest = new Request( request.getReqID(), request.getEmpID(), request.getDescription(), request.getCost(), request.getPurchaseDate(),
                request.getRequestDate(), request.getStatus(), request.getReceiptPic());
        Request returnRequest = requestRepositoryDao.save(updateRequest);
        return request;
    }

    @Override
    public List<ViewRequestPojo> getAllRequests() throws ApplicationException {
        List<ViewRequest> allViewRequestsEntity = this.viewRequestRepositoryDao.findAll();
        return getViewRequestPojos(allViewRequestsEntity);
    }

    @Override
    public ViewRequestPojo getARequest(int reqID) throws ApplicationException {
        return null;
    }

    @Override
    public List<ViewRequestPojo> getEmployeeRequests(int empID) throws ApplicationException {
        List<ViewRequest> allViewRequestsEntity = this.viewRequestRepositoryDao.findByEmpID(empID);
        return getViewRequestPojos(allViewRequestsEntity);
    }

    @Override
    public List<ViewRequestPojo> getStatusRequests(RequestStatus status) {
        List<ViewRequest> allViewRequestsEntity = this.viewRequestRepositoryDao.findByStatus(status);
        return getViewRequestPojos(allViewRequestsEntity);

    }

    @Override
    public void exitApplication() {

    }
}
