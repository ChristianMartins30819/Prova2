package questao10;

public class Sentimento {
	private Integer id;
	private String mensagem;
	
	public Sentimento(String mensagem) {
		super();
		this.mensagem = mensagem;
	}
	
	public Sentimento(Integer id, String mensagem) {
		this.id = id;
		this.mensagem = mensagem;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	@Override
	public String toString() {
		return String.format("A mensagem é: : %d, %s", this.id, this.mensagem);
	}
	
	
	
}
