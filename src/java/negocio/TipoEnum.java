package negocio;
public enum TipoEnum {
	ALIMENTO(1), HIGIENE(2), ROUPA(3);
	
	private final int valor;
	
	TipoEnum(int valorOpcao){
		valor = valorOpcao;
	}
	
	public int getValor(){
		return valor;
	}
}
