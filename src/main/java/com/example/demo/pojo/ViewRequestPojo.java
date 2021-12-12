package com.example.demo.pojo;

import com.example.demo.enums.RequestStatus;

import java.sql.Timestamp;

public class ViewRequestPojo {

    private int reqID;
    private String firstName;
    private String lastName;
    private String description;
    private double cost ;
    private String purchaseDate ;
    private Timestamp requestDate ;
    private RequestStatus status ;


    private String receiptPic;


    public ViewRequestPojo(int reqID, String firstName, String lastName, String description, double cost, String purchaseDate, Timestamp requestDate, RequestStatus status, String receiptPic) {
        super();
        this.reqID = reqID;
        this.firstName = firstName;
        this.lastName = lastName;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
        return "ViewRequestPojo{" +
                "reqID=" + reqID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", description='" + description + '\'' +
                ", cost=" + cost +
                ", purchaseDate='" + purchaseDate + '\'' +
                ", requestDate='" + requestDate + '\'' +
                ", status='" + status + '\'' +
                ", receiptPic='" + receiptPic + '\'' +
                '}';
    }


}
