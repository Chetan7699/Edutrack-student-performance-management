package admin.beans;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Admin implements Serializable
{
   private String firstName;
   private String lastName;
   private String password;
   private String username;
   private String mailId;
   private String city;
   private long mobileNo;
   
   
   public Admin()
   {
	   
   }
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getMailId() {
	return mailId;
}
public void setMailId(String mailId) {
	this.mailId = mailId;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public long getMobileNo() {
	return mobileNo;
}
public void setMobileNo(long mobileNo) {
	this.mobileNo = mobileNo;
}
   
   
   
}
