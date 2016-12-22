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
        
        public String toString(int valor) {
        if (valor == 1) {
            return "ALIMENTO";
        } else if (valor == 2) {
            return "HIGIENE";
        } else if (valor == 3){
            return "ROUPA";
        }
        return "";
    }

    public TipoEnum toEnum(String opcao) {
        if (opcao.equals("ALIMENTO")) {
            return TipoEnum.ALIMENTO;
        } else if (opcao.equals("HIGIENE")) {
            return TipoEnum.HIGIENE;
        } else if (opcao.equals("ROUPA")) {
            return (TipoEnum.ROUPA);
        }
        return null;
    }
}
