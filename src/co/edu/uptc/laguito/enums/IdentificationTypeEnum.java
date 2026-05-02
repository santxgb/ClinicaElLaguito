package co.edu.uptc.laguito.enums;

/** 
 * <b>Descripción: </b> Enum que representa todos los tipos de 
 * identificación aceptados en el sistema de la clinica<br>
 * 
 * @author Santiago
 */

public enum IdentificationTypeEnum {
	
	/** Cédula de ciudadanía*/
    CC("Cédula de ciudadanía"),
    
    /** Tarjeta de identidad*/
    TI("Tarjeta de identidad"),
    
    /** Cédula de extranjería*/
    CE("Cédula de extranjería"),
    
    /** Pasaporte*/
    PA("Pasaporte");
	
	/** Atributo que determina el nombre del tipo de identificación*/
	private final String officialName;
	
	/** 
	 * <b>Descripción:</b> Constructor del enum <br>
	 * @param officialName Parámetro que determina el nombre oficial
	 */

	private IdentificationTypeEnum(String officialName) {
		this.officialName = officialName;
	}
	/**
     * <b>Descripción: </b> Retorna el nombre oficial del tipo de identificación <br>
     * @return officialName Nombre oficial del tipo de identificación
     */
	public String getOfficialName() {
		return officialName;
	}

}
