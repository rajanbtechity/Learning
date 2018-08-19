package com.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="RTCI_UI_USERS")
public class RtciUIUser {
	@Id
	@Column(name="RTCI_UI_ID")
	private int rtciUIId;
	@Column(name="VZID")
	private String vzid;
	public int getRtciUIId() {
		return rtciUIId;
	}
	public String getVzid() {
		return vzid;
	}

}
