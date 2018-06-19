package com.pmt.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * Address entity.
 */
@Entity
@Table(name="ADDRESS")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="address_id")
    private Integer addressId;

    @Column(name="profile_id")
    private Integer profileId;
    
    @Column(name="addr_type")
    private String addrType;
    
    @Column(name="address")
    private String address;
    
    @ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "profile_id", insertable = false, updatable = false)
	private Profile profile;

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public Integer getProfileId() {
		return profileId;
	}

	public void setProfileId(Integer profileId) {
		this.profileId = profileId;
	}

	public String getAddrType() {
		return addrType;
	}

	public void setAddrType(String addrType) {
		this.addrType = addrType;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public Address(Integer profileId, String addrType, String address) {
		super();
		this.profileId = profileId;
		this.addrType = addrType;
		this.address = address;
	}
    
}
