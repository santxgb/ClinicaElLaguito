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
		}
	}
}
