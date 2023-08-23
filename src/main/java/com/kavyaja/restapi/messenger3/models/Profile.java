package com.kavyaja.restapi.messenger3.models;

import java.sql.Date;

public class Profile {
		
		private long id;
		private String profilename;
		private String firstname;
		private String lastname;
		
		public Profile()
		{
			
		}
		
		public Profile(long id, String profilename, String firstname, String lastname)
		{
			this.id = id;
			this.profilename = profilename;
			this.firstname = firstname;
			this.lastname =  lastname;
			
		}
		
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public String getprofilename() {
			return profilename;
		}
		public void setprofilename(String profilename) {
			this.profilename = profilename;
		}
		public String getfirstname() {
			return firstname;
		}
		public void setfirstname(String firstname) {
			this.firstname = firstname;
		}
		public String getlastname() {
			return lastname;
		}
		public void setlastname(String lastname) {
			this.lastname = lastname;
		}

		
//		public String getAuthor() {
//			return lastname;
//		}
//		public void setAuthor(String lastname) {
//			this.lastname = lastname;
//		}
//		public String getcreated() {
//			return lastname;
//		}
//		public void setcreated(String lastname) {
//			this.created = created;
//		}
//
//		public String getProfileName() {
//			return profilename;
//		}	
		
	}


