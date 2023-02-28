package com.exfscm.controller;

import java.io.FileNotFoundException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;
import org.springframework.web.servlet.ModelAndView;

import com.exfscm.model.CreateShipmentModel;
import com.exfscm.model.Devices;
import com.exfscm.repository.DevicesDataRepository;
import com.exfscm.service.CreateShipmentService;

import ch.qos.logback.core.model.Model;

@Controller
public class ShipmentController 
{
	@Autowired
	CreateShipmentService createShipmentService;
	
	@Autowired
	CreateShipmentModel createShipmentModel;
	
	@Autowired
	DevicesDataRepository dataRepository;
	
	// This method will post the CreateShipment Data in DB
	@PostMapping("/createShipment")
	public ModelAndView createShipment(@RequestParam Integer shipmentInvoiceNumber, @RequestParam Integer containerNumber, @RequestParam String shipmentDescription,
			@RequestParam String routeDetails, @RequestParam String goodsType, @RequestParam Integer device, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date expectedDelivaryDate, 
			@RequestParam Integer poNumber, @RequestParam Integer delivaryNumber, @RequestParam Integer ndcNumber, @RequestParam Integer batchId,
			@RequestParam Integer serialNumberOfGoods) throws FileNotFoundException, InternalServerError
	{
		ModelAndView modelAndView=null;
		try
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
			modelAndView = new ModelAndView();
			modelAndView.setViewName("createshipment");
			modelAndView.addObject("message", message);
			return modelAndView;
		}
		catch (Exception e) 
		{
			modelAndView = new ModelAndView();
			modelAndView.setViewName("errorPage");
			return modelAndView;
		}
	}
	
	//This method will gets the device stream data from DB
	@GetMapping("/devicesData")
	public ModelAndView getDevicesData() throws FileNotFoundException, InternalServerError
	{
		ModelAndView modelAndView;
		try
		{
			List<Devices> devices = dataRepository.findAll();
			modelAndView=new ModelAndView();
			modelAndView.addObject("devicedata", devices);
			modelAndView.setViewName("devicedata");
			return modelAndView;
		}
		catch (Exception e) 
		{
			modelAndView = new ModelAndView();
			modelAndView.setViewName("errorPage");
			return modelAndView;
		}
	}
}
