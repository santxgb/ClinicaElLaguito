package co.edu.uptc.laguito.service;

import co.edu.uptc.laguito.domain.Doctor;
import co.edu.uptc.laguito.repository.DoctorRepository;
import java.util.HashMap;
import java.util.TreeSet;

public class DoctorService {
	
	private DoctorRepository doctorRepository;

	public DoctorService() {
		super();
		this.doctorRepository = new DoctorRepository();
	}
	
	private boolean validate(Doctor doctor) {
		if (doctor.getFirstName() == null || doctor.getFirstName().isBlank()) {
			return false;
		}
		if (doctor.getLastName() == null || doctor.getLastName().isBlank()) {
			return false;
		}
		if (doctor.getSpecialty() == null || doctor.getSpecialty().isBlank()) {
			return false;
		}
		if (doctor.getMedicalId() == null || doctor.getMedicalId() <= 0) {
			return false;
		}
		if (doctor.getYearsOfExperience() == null || doctor.getYearsOfExperience() < 0) {
			return false;
		}
		return true;
	}
	
	public boolean addDoctor(Doctor doctor) {
		if(!validate(doctor)) {
			return false;
		}
		return doctorRepository.addDoctor(doctor);
	}
	
	public HashMap<Integer, Doctor> findAll(){
		return doctorRepository.findAll();
	}
	
	public Doctor findById(Integer medicalId) {
		return doctorRepository.findById(medicalId);
	}
	
	public TreeSet<Doctor> getReportByExperience(){
		return doctorRepository.findAllByExperience();
	}
	
}
