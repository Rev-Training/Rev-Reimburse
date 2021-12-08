package com.example.demo.entity;

import com.example.demo.enums.RequestStatus;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name="requests")
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="req_id")
    private int reqID;

    @Column(name="emp_id")
    private int empID;

    @Column(name="description")
    private String description;

    @Column(name="cost")
    private double cost;

    @Column(name="purchase_date")
    private String purchaseDate;

    @Column(name="request_date")
    private Timestamp requestDate;

    @Column(name="status")
    private RequestStatus status;

    @Column(name="receipt_pic")
    private String receiptPic;

    public Request() {
        super();
    }

    public Request(int reqID, int empID, String description, double cost, String purchaseDate,
                   Timestamp requestDate, RequestStatus status, String receiptPic) {
        this.reqID = reqID;
        this.empID = empID;
        this.description = description;
        this.cost = cost;
        this.purchaseDate = purchaseDate;
        this.requestDate = requestDate;
        this.status = status;
        this.receiptPic = receiptPic;
    }

    public int getReqID() {
        return reqID;
    }

    public void setReqID(int reqID) {
        this.reqID = reqID;
    }

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Timestamp getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Timestamp requestDate) {
        this.requestDate = requestDate;
    }

    public RequestStatus getStatus() {
        return status;
    }

    public void setStatus(RequestStatus status) {
        this.status = status;
    }

    public String getReceiptPic() {
        return receiptPic;
    }

    public void setReceiptPic(String receiptPic) {
        this.receiptPic = receiptPic;
    }

    @Override
    public String toString() {
        return "Request{" +
                "reqID=" + reqID +
                ", empID=" + empID +
                ", description='" + description + '\'' +
                ", cost=" + cost +
                ", purchaseDate='" + purchaseDate + '\'' +
                ", requestDate=" + requestDate +
                ", status=" + status +
                ", receiptPic='" + receiptPic + '\'' +
                '}';
    }
}
