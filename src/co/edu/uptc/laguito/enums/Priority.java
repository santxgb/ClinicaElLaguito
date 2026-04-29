package co.edu.uptc.laguito.enums;

/** 
 * <b>Descripción: </b> Enum que representa todos los tipos de 
 * identificación aceptados en el sistema de la clinica<br>
 * 
 * @author Santiago
 */

public enum Priority {
	
	/** Prioridad baja */
    LOW(0),

    /** Prioridad media */
    MEDIUM(1),

    /** Prioridad alta */
    HIGH(2),

    /** Prioridad crítica */
    CRITICAL(3);

    /** Atributo que determina el valor numérico de la prioridad */
    private final int value;

    /**
     * <b>Descripción: </b> Constructor del enum <br>
     * @param value Parámetro que determina el valor numérico de la prioridad
     */
	private Priority(int value) {
		this.value = value;
	}
	
	/**
     * <b>Descripción: </b> Retorna el valor numérico de la prioridad <br>
     * @return value Valor numérico de la prioridad
     */
	public int getValue() {
		return value;
	}
    
    
}
