package bean;

public class userbean {
private String name;
private int id;
private boolean valid;
public boolean isValid() {
	return valid;
}
public void setValid(boolean valid) {
	this.valid = valid;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
private String email;
private String password;
private int age;
private String gender;
private String address;
private String contact;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getContact() {
	return contact;
}
public void setContact(String contact) {
	this.contact = contact;
}

}
