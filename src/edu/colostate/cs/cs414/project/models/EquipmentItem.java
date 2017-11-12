package edu.colostate.cs.cs414.project.models;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Blob;
import java.sql.SQLException;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Transient;
import javax.swing.ImageIcon;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Type;
import org.hibernate.type.MaterializedBlobType;


@Entity
public class EquipmentItem {
	
	@Id
	private String id;
	
	private String name;
	
	@Lob
	@Fetch(FetchMode.SELECT)
	@Type(type="org.hibernate.type.MaterializedBlobType")
	private byte[] image;
	
	@Transient
	private File imageFile;
	
	private int quantity;
	
	public EquipmentItem(){
		
	}
	
	public void setImageFile(File imageFile) {
		this.imageFile = imageFile;
	}

	public EquipmentItem(String name, int quantity, File imageFile){
		
		this.id = java.util.UUID.randomUUID().toString();
		this.name = name;
		this.quantity = quantity;

		this.imageFile = imageFile;
		
	}
	
	public void setImageBlob(Blob imageBlob){
		try {
			this.image = imageBlob.getBytes( 1L, (int) imageBlob.length());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public File getImageFile(){return this.imageFile;}

	@Override
	public String toString() {
		return this.name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public byte[] getImageBlob() {
		return image;
	}
	
	public ImageIcon getImageIcon(){
		
		return new ImageIcon(image);
		
	}
}
