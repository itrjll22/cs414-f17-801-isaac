package edu.colostate.cs.cs414.project.models;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Arrays;

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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + Arrays.hashCode(image);
		result = prime * result + ((imageFile == null) ? 0 : imageFile.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + quantity;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EquipmentItem other = (EquipmentItem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (!Arrays.equals(image, other.image))
			return false;
		if (imageFile == null) {
			if (other.imageFile != null)
				return false;
		} else if (!imageFile.equals(other.imageFile))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (quantity != other.quantity)
			return false;
		return true;
	}

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
