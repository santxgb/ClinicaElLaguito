package co.edu.uptc.laguito.service;

import co.edu.uptc.laguito.domain.MedicalAppointment;
import co.edu.uptc.laguito.repository.AppointmentRepository;
import java.util.HashMap;
import java.util.TreeSet;

/**
 * <b>Descripción: </b> Clase de servicio que gestiona la lógica de negocio
 * relacionada con las citas médicas del sistema <br>
 *
 * @author Santiago
 */
public class AppointmentService {
	
	/** Atributo que determina el repositorio de citas médicas */
	private AppointmentRepository appointmentRepository;
	
	/** Atributo que determina el servicio de pacientes para validar su existencia */
	private PatientService patientService;
	
	/** Atributo que determina el servicio de médicos para validar su existencia */
	private DoctorService doctorService;
	
	/**
     * <b>Descripción: </b> Constructor de la clase <br>
     * @param patientService Parámetro que determina el servicio de pacientes
     * @param doctorService Parámetro que determina el servicio de médicos
     */
	public AppointmentService(PatientService patientService,
			DoctorService doctorService) {
		super();
		this.appointmentRepository = new AppointmentRepository();
		this.patientService = patientService;
		this.doctorService = doctorService;
	}
	
	/**
     * <b>Descripción: </b> Valida que los datos de la cita médica sean correctos,
     * incluyendo que el paciente y el médico existan en el sistema <br>
     * @param appointment Parámetro que determina la cita médica a validar
     * @return true si los datos son válidos, false en caso contrario
     */
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
	
	/**
     * <b>Descripción: </b> Registra una cita médica en el sistema previa validación
     * de sus datos y de la existencia del paciente y el médico <br>
     * @param appointment Parámetro que determina la cita médica a registrar
     * @return true si la cita fue registrada, false si los datos no son válidos
     * o ya existe una cita con el mismo identificador
     */
	public boolean addAppointment(MedicalAppointment appointment) {
		if(!validate(appointment)) {
			return false;
		}
		return appointmentRepository.addAppointment(appointment);
	}
	
	/**
     * <b>Descripción: </b> Retorna todas las citas médicas registradas en el sistema <br>
     * @return HashMap con todas las citas médicas registradas
     */
	public HashMap<Integer, MedicalAppointment> findAll(){
		return appointmentRepository.findAll();
	}
	
	/**
     * <b>Descripción: </b> Busca y retorna una cita médica por su identificador <br>
     * @param idMedicalAppointment Parámetro que determina el identificador de la cita
     * @return La cita médica encontrada, o null si no existe
     */
	public MedicalAppointment findById(Integer idMedicalAppointment) {
		return appointmentRepository.findById(idMedicalAppointment);
	}
	
	/**
     * <b>Descripción: </b> Retorna todas las citas médicas ordenadas primero por hora
     * de atención y en caso de empate por mayor prioridad del paciente <br>
     * @return TreeSet con las citas médicas ordenadas
     */
	public TreeSet<MedicalAppointment> findAllByTimeAndPriority(){
		TreeSet<MedicalAppointment> orden = new TreeSet<>((a, b) ->{
			int byTime = a.getTimeAppointment().compareTo(b.getTimeAppointment());
			if(byTime == 0) {
				return Integer.compare(b.getPatient().getPriority().getValue(),
					a.getPatient().getPriority().getValue());
				}
				return byTime;
			});
		orden.addAll(appointmentRepository.findAll().values());
		return orden;
	}
	
	/**
     * <b>Descripción: </b> Retorna la cola de atención con todas las citas ordenadas
     * primero por hora y en caso de empate por mayor prioridad del paciente <br>
     * @return TreeSet con las citas médicas ordenadas
     */
	
}
