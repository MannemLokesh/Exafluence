package com.exfscm.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.exfscm.model.CreateShipmentModel;
import com.exfscm.service.CreateShipmentService;

@Controller
public class ShipmentController 
{
	@Autowired
	CreateShipmentService createShipmentService;
	
	@Autowired
	CreateShipmentModel createShipmentModel;
	
	// This method will post the CreateShipment Data in DB
	@PostMapping("/createShipment")
	public ModelAndView createShipment(@RequestParam Integer shipmentInvoiceNumber, @RequestParam Integer containerNumber, @RequestParam String shipmentDescription,
			@RequestParam String routeDetails, @RequestParam String goodsType, @RequestParam Integer device, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date expectedDelivaryDate, 
			@RequestParam Integer poNumber, @RequestParam Integer delivaryNumber, @RequestParam Integer ndcNumber, @RequestParam Integer batchId,
			@RequestParam Integer serialNumberOfGoods)
	{
		
		createShipmentModel.setShipmentInvoiceNumber(shipmentInvoiceNumber);
		createShipmentModel.setContainerNumber(containerNumber);
		createShipmentModel.setShipmentDescription(shipmentDescription);
		createShipmentModel.setRouteDetails(routeDetails);
		createShipmentModel.setGoodsType(goodsType);
		createShipmentModel.setDevice(device);
		createShipmentModel.setExpectedDelivaryDate(expectedDelivaryDate);
		createShipmentModel.setPoNumber(poNumber);
		createShipmentModel.setDelivaryNumber(delivaryNumber);
		createShipmentModel.setNdcNumber(ndcNumber);
		createShipmentModel.setBatchId(batchId);
		createShipmentModel.setSerialNumberOfGoods(serialNumberOfGoods);
		
		String message=createShipmentService.save(createShipmentModel);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("createshipment");
		modelAndView.addObject("message", message);
		return modelAndView;
	}
}
