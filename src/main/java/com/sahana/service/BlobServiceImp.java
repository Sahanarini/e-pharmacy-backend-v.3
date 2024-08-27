package com.sahana.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.sahana.modal.Blob;
import com.sahana.modal.Order;
import com.sahana.repository.Blobrep;
import com.sahana.repository.OrderRepository;

@Service
public class BlobServiceImp implements BlobService {

	 @Autowired
	    private Blobrep blobRepository;

	    @Autowired
	    private OrderRepository orderRepository; // Inject OrderRepository to find Order by ID

	    @Transactional
	    @Override
	    public void savePrescriptionImage(MultipartFile file, Long id) throws IOException {
	        Order order = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
	        Blob blob = new Blob();
	        blob.setPrescriptionImage(file.getBytes());
	        blob.setOrder(order);
	        blobRepository.save(blob);
	    }

	    @Override
	    public List<Blob> getAllPrescription() {
	        return blobRepository.findAll();
	    }

	    @Override
	    public Blob getBlobById(int id) {
	        return blobRepository.findById(id).orElse(null);
	    }
}
