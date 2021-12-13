package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.ViewRequest;
import com.example.demo.enums.RequestStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViewRequestRepositoryDao extends JpaRepository<ViewRequest, Integer> {
    List<ViewRequest> findByEmpID(int empID);
    List<ViewRequest> findByStatus(RequestStatus status);
//    List<ViewRequest> findByStatusIS(String status);

}
