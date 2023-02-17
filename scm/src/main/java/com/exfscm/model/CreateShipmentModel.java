package com.exfscm.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Component
@Document(collection = "createShipment")
public class CreateShipmentModel 
{
	@Id
	private Integer shipmentInvoiceNumber;
	private Integer containerNumber;
	private String shipmentDescription;
	private String routeDetails;
	private String goodsType;
	private Integer device;
	private Date expectedDelivaryDate;
	private Integer poNumber;
	private Integer delivaryNumber;
	private Integer ndcNumber;
	private Integer batchId;
	private Integer serialNumberOfGoods;
	
	
	public int getShipmentInvoiceNumber() {
		return shipmentInvoiceNumber;
	}
	public void setShipmentInvoiceNumber(Integer shipmentInvoiceNumber) {
		this.shipmentInvoiceNumber = shipmentInvoiceNumber;
	}
	public int getContainerNumber() {
		return containerNumber;
	}
	public void setContainerNumber(Integer containerNumber) {
		this.containerNumber = containerNumber;
	}
	public String getShipmentDescription() {
		return shipmentDescription;
	}
	public void setShipmentDescription(String shipmentDescription) {
		this.shipmentDescription = shipmentDescription;
	}
	public String getRouteDetails() {
		return routeDetails;
	}
	public void setRouteDetails(String routeDetails) {
		this.routeDetails = routeDetails;
	}
	public String getGoodsType() {
		return goodsType;
	}
	public void setGoodsType(String goodsType) {
		this.goodsType = goodsType;
	}
	public int getDevice() {
		return device;
	}
	public void setDevice(Integer device) {
		this.device = device;
	}
	public Date getExpectedDelivaryDate() {
		return expectedDelivaryDate;
	}
	public void setExpectedDelivaryDate(Date expectedDelivaryDate) {
		this.expectedDelivaryDate = expectedDelivaryDate;
	}
	public int getPoNumber() {
		return poNumber;
	}
	public void setPoNumber(Integer poNumber) {
		this.poNumber = poNumber;
	}
	public int getDelivaryNumber() {
		return delivaryNumber;
	}
	public void setDelivaryNumber(Integer delivaryNumber) {
		this.delivaryNumber = delivaryNumber;
	}
	public int getNdcNumber() {
		return ndcNumber;
	}
	public void setNdcNumber(Integer ndcNumber) {
		this.ndcNumber = ndcNumber;
	}
	public int getBatchId() {
		return batchId;
	}
	public void setBatchId(Integer batchId) {
		this.batchId = batchId;
	}
	public int getSerialNumberOfGoods() {
		return serialNumberOfGoods;
	}
	public void setSerialNumberOfGoods(Integer serialNumberOfGoods) {
		this.serialNumberOfGoods = serialNumberOfGoods;
	}
}
