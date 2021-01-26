package tsi.ws.modelo;


public class Aluno {
	private int id;
	private String nomeAluno;
	private boolean matriculado;
	private static int identificacaoAluno;
	public Aluno() {
		id = ++identificacaoAluno;
	}
	
	public Aluno(int id, String nomeAluno, boolean matriculado) {
		super();
		this.nomeAluno = nomeAluno;
		this.matriculado = matriculado;
	}

	public int getId() {
		return id;
	}

	public String getNomeAluno() {
		return nomeAluno;
	}

	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}

	public boolean isMatriculado() {
		return matriculado;
	}

	public void setMatriculado(boolean matriculado) {
		this.matriculado = matriculado;
	}
		
}
