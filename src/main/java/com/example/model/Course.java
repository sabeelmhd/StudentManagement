package com.example.model;

import java.util.Set;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Course {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;
	    private String name;
	    private String description;
	    private double fee;
	    private int duration;
	    private String startDate;
	    private String endDate;
	    
	    @ManyToMany(cascade = CascadeType.ALL)
	    @JoinTable(
	    		name = "Course_Subject",
	    		joinColumns = @JoinColumn(name = "course_id"),
	    		inverseJoinColumns = @JoinColumn(name = "subject_id"))
	    @JsonProperty("subjects")
	    private Set<Subject> subjects;
		
	    public Set<Subject> getSubjects() {
			return subjects;
		}
		public void setSubjects(Set<Subject> subjects) {
			this.subjects = subjects;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public double getFee() {
			return fee;
		}
		public void setFee(double fee) {
			this.fee = fee;
		}
		public int getDuration() {
			return duration;
		}
		public void setDuration(int duration) {
			this.duration = duration;
		}
		public String getStartDate() {
			return startDate;
		}
		public void setStartDate(String startDate) {
			this.startDate = startDate;
		}
		public String getEndDate() {
			return endDate;
		}
		public void setEndDate(String endDate) {
			this.endDate = endDate;
		}

	
}
