package com.example.demo.entity;

//import com.example.demo.converters.RequestStatusConverter;
import com.example.demo.enums.RequestStatus;
import com.example.demo.types.PostgresSQLEnumType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="requests")
//@TypeDef(
//    name = "postgres_enum",
//    typeClass = PostgresSQLEnumType.class
//)
public class ViewRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "req_id")
    private int reqID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "emp_id", nullable = false, insertable = false, updatable = false)
    private User user;

    @Column(name = "emp_id")
    private int empID;


    @Column(name = "description")
    private String description;

    @Column(
            name = "cost",
            columnDefinition = "NUMERIC(100, 2)"
    )
    private double cost;

    @Column(name = "purchase_date")
    private String purchaseDate;

    @Column(name = "request_date")
    private Timestamp requestDate;

    @Enumerated(EnumType.STRING)
    @Column(
        name = "status",
        columnDefinition = "request_statuses"
    )
//    @Convert(converter = RequestStatusConverter.class)
//    @Type( type = "postgres_enum")
    private RequestStatus status;

    @Column(name = "receipt_pic")
    private String receiptPic;

    public ViewRequest() {
        super();
    }

    public ViewRequest(int reqID, User user, int empID, String description, double cost, String purchaseDate, Timestamp requestDate, RequestStatus status, String receiptPic) {
        this.reqID = reqID;
        this.user = user;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
}


