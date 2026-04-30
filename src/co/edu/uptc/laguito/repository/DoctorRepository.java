package co.edu.uptc.laguito.repository;

import co.edu.uptc.laguito.domain.Doctor;
import java.util.HashMap;
import java.util.TreeSet;

public class DoctorRepository {
	
	private HashMap<Integer, Doctor> doctors;

	public DoctorRepository() {
		super();
		this.doctors = new HashMap<>();
	}
	
	public boolean addDoctor(Doctor doctor) {
		if(doctors.containsKey(doctor.getMedicalId())) {
			return false;
		}
		doctors.put(doctor.getMedicalId(), doctor);
		return true;
	}
	
	public HashMap<Integer, Doctor> findAll(){
		return doctors;
	}
	
	public Doctor findById(Integer medicalId) {
		return doctors.get(medicalId);
	}
	
	public TreeSet<Doctor> findAllByExperience() {
		TreeSet<Doctor> orden = new TreeSet<>();
		orden.addAll(doctors.values());
		return orden;
	}
	
}
