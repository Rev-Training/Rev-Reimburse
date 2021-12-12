package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.Request;
import com.example.demo.enums.RequestStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestRepositoryDao extends JpaRepository<Request, Integer> {
    List<Request> findByEmpID(int empID);
    List<Request> findByStatus(RequestStatus status);

}
