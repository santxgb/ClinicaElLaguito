package co.edu.uptc.laguito.ui;

import co.edu.uptc.laguito.service.AppointmentService;
import co.edu.uptc.laguito.service.DoctorService;
import co.edu.uptc.laguito.service.PatientService;
import co.edu.uptc.laguito.domain.Doctor;
import co.edu.uptc.laguito.domain.MedicalAppointment;
import co.edu.uptc.laguito.domain.Patient;
import co.edu.uptc.laguito.enums.PriorityEnum;
import co.edu.uptc.laguito.enums.IdentificationTypeEnum;
import javax.swing.JOptionPane;

public class Main {
	
	private PatientService patientService;
	
	private DoctorService doctorService;
	
	private AppointmentService appointmentService;

	public Main() {
		super();
		this.patientService = new PatientService();
		this.doctorService = new DoctorService();
		this.appointmentService = new AppointmentService(patientService, doctorService);
	}
	
	public static void main(String[] args) {
		new Main().iniciar();
	}
	
	public void iniciar() {
		int option = -1;
		while(option != 0) {
			option = Integer.parseInt(JOptionPane.showInputDialog(null, """
					===== Clínica el Laguito ====
					
					1). Registrar paciente
					2). Registrar médico
					3). Registrar cita médica
					4). Agregar medicamento a paciente
					5). Ver cola de antención
					6). Ver reporte de médicos por experiencia
					0). Salir
					
					Seleccione una opción:""",
					"Menu Principal", JOptionPane.PLAIN_MESSAGE)
					);
		switch(option) {
		case 1:
			registrarPaciente();
			break;
		case 2: registrarMedico();
			break;
		case 3:
			registrarCita();
			break;
		case 4:
			agregarMedicamento();
			break;
		case 5:
			verColaAtencion();
			break;
		case 6: 
			verReporteMedicos();
			break;
		case 0:
			JOptionPane.showMessageDialog(null, "Gracias por utilizar nuestro sistema", "Salir", JOptionPane.INFORMATION_MESSAGE);
			break;
		default:
			JOptionPane.showMessageDialog(null, "Opción no válida.", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	public void registrarPaciente() {
		String[] tipos = {"CC - Cédula de ciudadanía", "TI - Tarjeta de identidad", "CE - Cédula de extranjería", "PA - Pasaporte"};
		int tipoIndex = JOptionPane.showOptionDialog(null, "Seleccione el tipo de identificación:", "Registrar Paciente", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, tipos, tipos[0]);
		if(tipoIndex == -1) {
			return;
		}
		IdentificationTypeEnum identificationType = IdentificationTypeEnum.values()[tipoIndex];
		
		int idPatient = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el número de identificación:", "Registrar Paciente", JOptionPane.PLAIN_MESSAGE));
		String firstName = JOptionPane.showInputDialog(null, "Ingrese el nombre del paciente:", "Registrar Paciente", JOptionPane.PLAIN_MESSAGE);
		String lastName = JOptionPane.showInputDialog(null, "Ingrese los apellidos del paciente:", "Registrar Paciente", JOptionPane.PLAIN_MESSAGE);
		String email = JOptionPane.showInputDialog(null, "Ingrese el correo electrónico del paciente:", "Registrar Paciente", JOptionPane.PLAIN_MESSAGE);
		
		String[] prioridades = {
				"LOW - Baja", "MEDIUM - Media", "HIGH - Alta", "CRITICAL - Crítica"
		};
		int prioridadIndex = JOptionPane.showOptionDialog(null, "Seleccione la prioridad de atención:", "Registrar Paciente", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, prioridades, prioridades[0]);
		if(prioridadIndex == -1) {
			return;
		}
		PriorityEnum priority = PriorityEnum.values()[prioridadIndex];
		
		Patient patient = new Patient(identificationType, idPatient, firstName, lastName, email, null, priority);
		
		if(patientService.addPatient(patient)) {
			JOptionPane.showMessageDialog(null, "Paciente registrado exitosamente.", "Correcto", JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "No se puedo registrar al paciente. El ID o el email ya existen dentro del sistema", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	public void registrarMedico() {
		
	}
	public void registrarCita() {
		
	}
	public void agregarMedicamento() {
		
	}
	public void verColaAtencion(){
		
	}
	public void verReporteMedicos() {
		
	}
}
