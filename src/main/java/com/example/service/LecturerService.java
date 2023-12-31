package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.LecturerRepository;
import com.example.dao.SubjectRepository;
import com.example.model.Lecturer;
import com.example.model.Subject;

@Service
public class LecturerService {
	
	@Autowired
	private LecturerRepository lecturerRepository;
	
	@Autowired
	private SubjectRepository subjectRepository;
	
	public Lecturer createLecturer(Lecturer lecturer) {
		return lecturerRepository.save(lecturer);
	}
	
	public List<Lecturer> createLecturers(List<Lecturer> lecturers) {
		return lecturerRepository.saveAll(lecturers);
	}
	
	public Lecturer updateLecturer(Lecturer lecturer) {
		Lecturer oldLecturer = null;
		Optional<Lecturer> optionalLecturer = lecturerRepository.findById(lecturer.getId());
		if(optionalLecturer.isPresent()) {
			oldLecturer = optionalLecturer.get();
	        oldLecturer.setFirstName(lecturer.getFirstName());
	        oldLecturer.setLastName(lecturer.getLastName());
	        oldLecturer.setAddress(lecturer.getAddress());
	        oldLecturer.setPhoneNumber(lecturer.getPhoneNumber());
	        oldLecturer.setEmail(lecturer.getEmail());
	        oldLecturer.setNic(lecturer.getNic());
	        oldLecturer.setGender(lecturer.getGender());
	        oldLecturer.setDateOfBirth(lecturer.getDateOfBirth());
	        oldLecturer.setDegree(lecturer.getDegree());
	        lecturerRepository.save(oldLecturer);
		}
		else {
			return new Lecturer();
		}
		return oldLecturer;
	}
	
	public String deleteLecturer(int id) {
		lecturerRepository.deleteById(id);
		return "Deleted";
	}
	
	public List<Subject> getAllSubjectsByLecturerId(int lecturerId) {
		return subjectRepository.findSubjectsByLecturersId(lecturerId);
	}

	public Lecturer getLecturerById(int id) {
		return lecturerRepository.findById(id).orElse(null);
	}
	
	public void assignLecturerToSubject(int subjectId, Lecturer lecturer) {
		Optional<Subject> optionalSubject = subjectRepository.findById(subjectId);
		if(optionalSubject.isPresent()) {
			Subject subject = optionalSubject.get();
			subject.addLecturer(lecturer);
			subjectRepository.save(subject);
		}
	}
	
	public void removelecturerFromSubject(int subjectId, int lecturerId) {
		Optional<Subject> optionalSubject = subjectRepository.findById(subjectId);
		if(optionalSubject.isPresent()) {
			Subject subject = optionalSubject.get();
			subject.removeLecturer(lecturerId);
			subjectRepository.save(subject);
		}
		else {
			System.out.println("Error");
		}
	}
}
