package com.sahana.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sahana.modal.Blob;

@Repository
public interface Blobrep extends JpaRepository<Blob, Integer> {
//	List<Blob> findByUsersId(Long userId);

}
