package negocio;
public class Insumo {
	private String nome;
	private TipoEnum tipo;
	private String descricao;
	
	@Override
	public String toString() {
		return "Insumo - " + nome + "\nTipo: " + tipo + "\nDescrição: " + descricao + "\n";
	}

	public Insumo(String nome, TipoEnum tipo, String descricao){
		this.nome = nome;
		this.tipo = tipo;
		this.descricao = descricao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public TipoEnum getTipo() {
		return tipo;
	}

	public void setTipo(TipoEnum tipo) {
		this.tipo = tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
        
        
}
