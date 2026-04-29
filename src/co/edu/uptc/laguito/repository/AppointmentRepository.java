package co.edu.uptc.laguito.repository;

import co.edu.uptc.laguito.domain.MedicalAppointment;
import java.util.HashMap;
import java.util.TreeSet;


public class AppointmentRepository {
		
		private HashMap<Integer, MedicalAppointment> appointments;
		
		public AppointmentRepository() {
			this.appointments = new HashMap<>();
		}
		
		public boolean addAppointment(MedicalAppointment appointment) {
			if(appointments.containsKey(appointment.getIdMedicalAppointment())) {
				return false;
		}
			appointments.put(appointment.getIdMedicalAppointment(), appointment);
			return true;
		}
		
		public HashMap<Integer, MedicalAppointment> findAll(){
			return appointments;
		}
		
		public MedicalAppointment findById(Integer idMedicalAppointment) {
			return appointments.get(idMedicalAppointment);
		}
		
		public TreeSet<MedicalAppointment> findAllByTimeAndPriority(){
			TreeSet<MedicalAppointment> orden = new TreeSet<>((a, b) ->{
				int byTime = a.getTimeAppointment().compareTo(b.getTimeAppointment());
				if(byTime == 0) {
					return Integer.compare(b.getPatient().getPriority().getValue(),
							a.getPatient().getPriority().getValue()
							);
				}
				return byTime;
			});
			orden.addAll(appointments.values());
			return orden;
		}

}
