package edu.colostate.cs.cs414.project.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class EquipmentItem {
	
	@Id
	private String id;
	private String name;
	private byte[] picture;
	private int quantity;
	
}
