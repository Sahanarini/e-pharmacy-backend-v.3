//package com.sahana.repository;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//import org.springframework.web.multipart.MultipartFile;
//
//import com.sahana.modal.Blob;
//
//import jakarta.persistence.EntityManager;
//
//@Repository
//public class BlobRepo {
//		
//	@Autowired
//	EntityManager e;
//	
//	public void imageStore(MultipartFile prescriptionImage) {
//		try {
//			Blob blobby = new Blob();
//			blobby.setPrescriptionImage(prescriptionImage.getBytes());
//			e.persist(blobby);
//		}
//		catch(Exception e) {
//			System.out.print("not added");
//		}
//		
//		
//	}
//	
//	public List<Blob> getAllImages(){
//		return e.createQuery("From Blob").getResultList();
//	}
//	
//	
//
//}

package com.sahana.repository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.sahana.modal.Blob;

import jakarta.persistence.EntityManager;

@Repository
public class BlobRepo {

    private static final Logger logger = LoggerFactory.getLogger(BlobRepo.class);

    @Autowired
    private EntityManager e;

    public void imageStore(MultipartFile prescriptionImage) {
        try {
            Blob blobby = new Blob();
            blobby.setPrescriptionImage(prescriptionImage.getBytes());
            e.persist(blobby);
            logger.info("Image stored successfully with ID: {}", blobby.getId());
        } catch (Exception ex) {
            logger.error("Error while storing image", ex);
        }
    }

    public List<Blob> getAllImages() {
        return e.createQuery("From Blob", Blob.class).getResultList();
    }
}

