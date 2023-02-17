package com.exfscm.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exfscm.model.CreateShipmentModel;
import com.exfscm.repository.CreateShipmentRepository;
import com.exfscm.service.CreateShipmentService;

@Service
public class CreateShipmentServiceImpl implements CreateShipmentService
{
	@Autowired
	CreateShipmentRepository createShipmentRepository;
	
	//Service Implementation method to save CreateShipment details in DB
	@Override
	public String save(CreateShipmentModel createShipmentModel) 
	{
		Optional<CreateShipmentModel> detais = createShipmentRepository.findById(createShipmentModel.getShipmentInvoiceNumber());
		
		//If the above Object details is empty, that means there is no InvoiceNumber in DB (@Id) and hence we can save it to DB
		if(detais.isEmpty())
		{
			createShipmentRepository.save(createShipmentModel);
			return "Shipment Successfully Created!";
		}
		//If the above Object details is not empty, that means there is a InvoiceNumber in DB (@Id) and we cannot store it again.
		else
		{
			return "Invoice Number Already Exist!";
		}
	}
}
