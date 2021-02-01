/*package com.ohm.pojos;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "orderid")
    private Long orderId;
    
    @Column(name = "customerName", length = 255, nullable = false)
    private String customerName;
 
    @Column(name = "customerAddress", length = 255, nullable = false)
    private String customerAddress;
 
    @Column(name = "customerEmail", length = 128, nullable = false)
    private String customerEmail;
 
    @Column(name = "customerPhone", length = 128, nullable = false)
    private String customerPhone;
 

    @Column(name = "paymentType", nullable = false)
    private String paymentType;

    @Column(name = "paymentDate")
    private String paymentDate;
	
    @Column(name = "amount", nullable = false)
    private Long amount;
    
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orderDetailsId", fetch = FetchType.LAZY)
    private List<OrderDetails> orderDetails;
   
    @JsonManagedReference
	public List<OrderDetails> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetails> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public Order() {
    	System.out.println("in costr of "+getClass().getName());
	}


	


	public Order(Long orderId, String customerName, String customerAddress, String customerEmail, String customerPhone,
			String paymentType, String paymentDate, Long amount) {
		super();
		this.orderId = orderId;
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.customerEmail = customerEmail;
		this.customerPhone = customerPhone;
		this.paymentType = paymentType;
		this.paymentDate = paymentDate;
		this.amount = amount;
	}





	public Long getOrderId() {
		return orderId;
	}





	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}





	public String getCustomerName() {
		return customerName;
	}





	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}





	public String getCustomerAddress() {
		return customerAddress;
	}





	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}





	public String getCustomerEmail() {
		return customerEmail;
	}





	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}





	public String getCustomerPhone() {
		return customerPhone;
	}





	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}





	public String getPaymentType() {
		return paymentType;
	}





	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}





	public String getPaymentDate() {
		return paymentDate;
	}





	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}





	public Long getAmount() {
		return amount;
	}





	public void setAmount(Long amount) {
		this.amount = amount;
	}





	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		return true;
	}
    
    


}*/
