package main.java;

import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.ArrayList;
import java.util.List;

public class Order implements Cloneable {
    private int id;
    private long TotalAmount;
    private String date;
    private boolean status;
    private String CustomerName;
    private String CustomerPhone;
    private List<OrderDetail> orderdetail;
    @Override
    public Order clone() {
        try {
            return (Order) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    public Order(int id) {
        this.id = id;
        orderdetail = new ArrayList<>();
        this.status = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getTotalAmount() {
        return TotalAmount;
    }

    public void setTotalAmount(long totalAmount) {
        TotalAmount = totalAmount;
    }

    public List<OrderDetail> getOrderdetail() {
        return orderdetail;
    }

    public void setOrderdetail(List<OrderDetail> orderdetail) {
        this.orderdetail = orderdetail;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public String getCustomerPhone() {
        return CustomerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        CustomerPhone = customerPhone;
    }

    public void printOrder() {

        System.out.println("Order ID: " + id);
        System.out.printf("Customer: %s, Phone: %s \n", CustomerName, CustomerPhone);
        System.out.println("Total Amount: " + TotalAmount + " VNĐ");
        System.out.println("Status:       " + status);
        System.out.println("OrderID - Product - Price - Quantity");

        for (OrderDetail order:
             orderdetail) {
            System.out.printf("  %d -    %s -    %d VND -    %d \n", order.getId(), order.getProduct().getName(),
                    order.getProduct().getPrice(), order.getAmount());
        }

    }
}
