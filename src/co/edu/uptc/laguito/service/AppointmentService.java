package co.edu.uptc.laguito.service;

import co.edu.uptc.laguito.domain.MedicalAppointment;
import co.edu.uptc.laguito.repository.AppointmentRepository;
import java.util.HashMap;
import java.util.TreeSet;

public class AppointmentService {
	
	private AppointmentRepository appointmentRepository;
	private PatientService patientService;
	private DoctorService doctorService;
	public AppointmentService(PatientService patientService,
			DoctorService doctorService) {
		super();
		this.appointmentRepository = new AppointmentRepository();
		this.patientService = patientService;
		this.doctorService = doctorService;
	}
	
	private boolean validate(MedicalAppointment appointment) {
		if(appointment.getIdMedicalAppointment() == null) {
			return false;
		}
		if(appointment.getTimeAppointment() == null) {
			return false;
		}
		if(patientService.findById(appointment.getPatient().getIdPatient()) == null) {
			return false;
		}
		if(doctorService.findById(appointment.getDoctor().getMedicalId()) == null) {
			return false;
		}
		return true;
	}
	
	public boolean addAppointment(MedicalAppointment appointment) {
		if(!validate(appointment)) {
			return false;
		}
		return appointmentRepository.addAppointment(appointment);
	}
	
	public HashMap<Integer, MedicalAppointment> findAll(){
		return appointmentRepository.findAll();
	}
	
	public MedicalAppointment findById(Integer idMedicalAppointment) {
		return appointmentRepository.findById(idMedicalAppointment);
	}
	
	public TreeSet<MedicalAppointment> getAttention(){
		return appointmentRepository.findAllByTimeAndPriority();
	}
	
}
