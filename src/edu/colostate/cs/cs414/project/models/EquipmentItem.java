package edu.colostate.cs.cs414.project.models;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Blob;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Transient;


@Entity
public class EquipmentItem {
	
	@Id
	private String id;
	
	private String name;
	
	@Lob
	private Blob imageBlob;
	
	@Transient
	private File imageFile;
	
	private int quantity;
	
	public EquipmentItem(String name, int quantity, File imageFile){
		
		this.id = java.util.UUID.randomUUID().toString();
		this.name = name;
		this.quantity = quantity;

		this.imageFile = imageFile;
		
	}
	
	public void setImageBlob(Blob imageBlob){
		this.imageBlob = imageBlob;
	}
	
	public File getImageFile(){return this.imageFile;}

	@Override
	public String toString() {
		return this.name;
	}
	
	
}
