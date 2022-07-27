package com.example.bookingorder.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Document(collection = "Orders")
public class BookingOrder {

	@Id
	private String Id;
	private String trainid;
//	@NotBlank(message="Please mention the quantity")
	private int quantity;
	@NotEmpty(message = "User Name Should not be blank")
	private String userName;
	@NotBlank(message="Please mention the Start Station")
	private String startStation;
	@NotBlank(message="Please mention the End Station")
	private String endStation;
	
	public String getTrainid() {
		return trainid;
	}
	public void setTrainId(String trainid) {
		this.trainid = trainid;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getStartStation() {
		return startStation;
	}
	public void setStartStation(String startStation) {
		this.startStation = startStation;
	}
	public String getEndStation() {
		return endStation;
	}
	public void setEndStation(String endStation) {
		this.endStation = endStation;
	}
	
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setTrainid(String trainid) {
		this.trainid = trainid;
	}
	
	@Override
	public String toString() {
		return "BookingOrder [Id=" + Id + ", trainid=" + trainid + ", quantity=" + quantity + ", userName=" + userName
				+ ", startStation=" + startStation + ", endStation=" + endStation + "]";
	}
	public BookingOrder(String id, String trainid, int quantity,
			@NotEmpty(message = "User Name Should not be blank") String userName,
			@NotBlank(message = "Please mention the Start Station") String startStation,
			@NotBlank(message = "Please mention the End Station") String endStation) {
		super();
		Id = id;
		this.trainid = trainid;
		this.quantity = quantity;
		this.userName = userName;
		this.startStation = startStation;
		this.endStation = endStation;
	}
	public BookingOrder() {
		super();
		// TODO Auto-generated constructor stub
	}

}