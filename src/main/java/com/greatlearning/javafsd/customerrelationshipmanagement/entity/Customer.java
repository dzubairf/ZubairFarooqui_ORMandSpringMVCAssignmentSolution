package com.greatlearning.javafsd.customerrelationshipmanagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table (name="customer")
@Entity (name="customer_entity")
public class Customer {

	// define fields for the student table
		@Id
		@GeneratedValue (strategy = GenerationType.IDENTITY)
		@Column (name="id")
		private int id;
		
		@Column (name="firstName")
		private String firstName;
		
		@Column (name="lastName")
		private String lastName;
		
		@Column (name="email")
		private String email;

		// constructor with no arguments
		public Customer() {
			super();
		}

		// constructor with 3 arguments (all except id which is auto-generated)
		public Customer(String firstName, String lastName, String email) {
			super();
			this.firstName = firstName;
			this.lastName = lastName;
			this.email = email;
		}

		@Override
		public String toString() {
			return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
					+ "]";
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
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

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}
}
