package com.sahana.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sahana.modal.Blob;
import com.sahana.service.BlobService;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class BlobController {

    @Autowired
    private BlobService service;

    @PostMapping("/prescription")
    public ResponseEntity<String> uploadPrescriptionImage(@RequestParam("prescriptionImage") MultipartFile file,
                                                           @RequestParam("id") Long id) {
        try {
            service.savePrescriptionImage(file, id);
            return ResponseEntity.ok("File uploaded and saved successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error uploading file");
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Blob>> getAllPrescription() {
        return ResponseEntity.ok(service.getAllPrescription());
    }

    @GetMapping("/prescription/{id}")
    public ResponseEntity<byte[]> getPrescriptionImage(@PathVariable int id) {
        try {
            Blob blob = service.getBlobById(id);
            if (blob == null) {
                return ResponseEntity.notFound().build();
            }
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            return new ResponseEntity<>(blob.getPrescriptionImage(), headers, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}


