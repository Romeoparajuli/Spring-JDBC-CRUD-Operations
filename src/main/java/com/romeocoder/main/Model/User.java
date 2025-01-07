package com.romeocoder.main.Model;

/**
 * Represents a User entity with attributes such as name, age, address, and
 * gender. This class provides getter and setter methods to access and modify
 * these attributes.
 * 
 * It can be used as a Data Transfer Object (DTO) for CRUD operations in the
 * application.
 */
public class User {

    // Name of the user
    private String name;

    // Age of the user
    private int age;

    // Address of the user
    private String address;

    // Gender of the user
    private String gender;

    /**
     * Default constructor for the User class. Required for frameworks like
     * Hibernate or Spring to instantiate the object.
     */
    public User() {
    }

    /**
     * Parameterized constructor to initialize a User object with specific details.
     * 
     * @param name    the name of the user
     * @param age     the age of the user
     * @param address the address of the user
     * @param gender  the gender of the user
     */
    public User(String name, int age, String address, String gender) {
	this.name = name;
	this.age = age;
	this.address = address;
	this.gender = gender;
    }

    /**
     * Retrieves the name of the user.
     * 
     * @return the name of the user
     */
    public String getName() {
	return name;
    }

    /**
     * Updates the name of the user.
     * 
     * @param name the new name of the user
     */
    public void setName(String name) {
	this.name = name;
    }

    /**
     * Retrieves the age of the user.
     * 
     * @return the age of the user
     */
    public int getAge() {
	return age;
    }

    /**
     * Updates the age of the user.
     * 
     * @param age the new age of the user Must be a non-negative integer.
     */
    public void setAge(int age) {
	this.age = age;
    }

    /**
     * Retrieves the address of the user.
     * 
     * @return the address of the user
     */
    public String getAddress() {
	return address;
    }

    /**
     * Updates the address of the user.
     * 
     * @param address the new address of the user
     */
    public void setAddress(String address) {
	this.address = address;
    }

    /**
     * Retrieves the gender of the user.
     * 
     * @return the gender of the user
     */
    public String getGender() {
	return gender;
    }

    /**
     * Updates the gender of the user.
     * 
     * @param gender the new gender of the user
     */
    public void setGender(String gender) {
	this.gender = gender;
    }

    /**
     * Provides a string representation of the User object.
     * 
     * @return a string containing all the details of the user
     */
    @Override
    public String toString() {
	return "User{" + "name='" + name + '\'' + ", age=" + age + ", address='" + address + '\'' + ", gender='"
		+ gender + '\'' + '}';
    }
}
