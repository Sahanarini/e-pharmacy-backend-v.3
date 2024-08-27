package com.sahana.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.sahana.modal.Blob;

import io.jsonwebtoken.io.IOException;

public interface BlobService {
	void savePrescriptionImage(MultipartFile file, Long orderId) throws IOException, java.io.IOException;

	List<Blob> getAllPrescription();

	Blob getBlobById(int id);
}
