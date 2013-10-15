package com.venu;

import java.util.Date;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Reference;

import com.cuesol.cc.customer.enumeration.CustomerRegistrationStatusEnum;
import com.cuesol.cc.customer.enumeration.CustomerRestrictionEnum;
import com.cuesol.cc.lossprevention.enumeration.ScanToGoStatusEnum;

@Entity
public class Customer {
	
		@Id ObjectId id;
		private String firstName;
	    private String credential;
	    private String alternateId;
	    private String emailAddress;
	    private String lastName;
	    private long personId;
	    private long householdId;
	    private String ccName;
	    private String middleInitial;
	   @Reference
	    private Address address;
	    //private CustomerRegistrationStatusEnum customerRegistrationEnum;
	    //private ScanToGoStatusEnum scanToGoEnum = ScanToGoStatusEnum.STATUS_ALLOWED;
	    private long trustPoints;
	    private int totalTrips;
	    //private CustomerRestrictionEnum customerRestrictionEnum = CustomerRestrictionEnum.None;
	    private int smallTripCount;
	    private Date lastSuccessfulSmallTripAudit;
		
	    public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getCredential() {
			return credential;
		}
		public void setCredential(String credential) {
			this.credential = credential;
		}
		public String getAlternateId() {
			return alternateId;
		}
		public void setAlternateId(String alternateId) {
			this.alternateId = alternateId;
		}
		public String getEmailAddress() {
			return emailAddress;
		}
		public void setEmailAddress(String emailAddress) {
			this.emailAddress = emailAddress;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public long getPersonId() {
			return personId;
		}
		public void setPersonId(long personId) {
			this.personId = personId;
		}
		public long getHouseholdId() {
			return householdId;
		}
		public void setHouseholdId(long householdId) {
			this.householdId = householdId;
		}
		public String getCcName() {
			return ccName;
		}
		public void setCcName(String ccName) {
			this.ccName = ccName;
		}
		public String getMiddleInitial() {
			return middleInitial;
		}
		public void setMiddleInitial(String middleInitial) {
			this.middleInitial = middleInitial;
		}
		
		public long getTrustPoints() {
			return trustPoints;
		}
		public void setTrustPoints(long trustPoints) {
			this.trustPoints = trustPoints;
		}
		public int getTotalTrips() {
			return totalTrips;
		}
		public void setTotalTrips(int totalTrips) {
			this.totalTrips = totalTrips;
		}
		
		public int getSmallTripCount() {
			return smallTripCount;
		}
		public void setSmallTripCount(int smallTripCount) {
			this.smallTripCount = smallTripCount;
		}
		public Date getLastSuccessfulSmallTripAudit() {
			return lastSuccessfulSmallTripAudit;
		}
		public void setLastSuccessfulSmallTripAudit(Date lastSuccessfulSmallTripAudit) {
			this.lastSuccessfulSmallTripAudit = lastSuccessfulSmallTripAudit;
		}
		
		public Address getAddress() {
			return address;
		}
		public void setAddress(Address address) {
			this.address = address;
		}
		@Override
		public String toString() {
			return "Customer [id=" + id + ", firstName=" + firstName
					+ ", credential=" + credential + ", alternateId="
					+ alternateId + ", emailAddress=" + emailAddress
					+ ", lastName=" + lastName + ", personId=" + personId
					+ ", householdId=" + householdId + ", ccName=" + ccName
					+ ", middleInitial=" + middleInitial + ", address="
					+ address.toString() + ", trustPoints=" + trustPoints
					+ ", totalTrips=" + totalTrips + ", smallTripCount="
					+ smallTripCount + ", lastSuccessfulSmallTripAudit="
					+ lastSuccessfulSmallTripAudit + "]";
		}
		
	    
}
