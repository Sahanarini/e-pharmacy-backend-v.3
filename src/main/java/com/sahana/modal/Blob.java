package com.sahana.modal;

import jakarta.persistence.Entity;
import jakarta.persistence.*;

@Entity
@Table(name = "imagess")
public class Blob {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Lob
	@Column(columnDefinition = "LONGBLOB", length = 1000000)
	private byte[] prescriptionImage;

	@OneToOne
	@JoinColumn(name = "order_id") // This is the foreign key column
	private Order order;

	public Blob() {
		super();

	}

	public Blob(int id, byte[] prescriptionImage, Order order) {
		super();
		this.id = id;
		this.prescriptionImage = prescriptionImage;
		this.order = order;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte[] getPrescriptionImage() {
		return prescriptionImage;
	}

	public void setPrescriptionImage(byte[] prescriptionImage) {
		this.prescriptionImage = prescriptionImage;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

}
