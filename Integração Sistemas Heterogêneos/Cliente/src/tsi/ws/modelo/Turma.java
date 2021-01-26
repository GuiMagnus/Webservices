package tsi.ws.modelo;

import java.util.List;

public class Turma {
	private int id,anoTurma;
	private String curso,nomeTurma;
	private List<Aluno> alunos;
	private static int identificacaoTurma;
	public Turma() {
		id = ++identificacaoTurma;
	}
		
	public Turma(int anoTurma, String curso, String nomeTurma, List<Aluno> alunos) {
		super();
		this.anoTurma = anoTurma;
		this.curso = curso;
		this.nomeTurma = nomeTurma;
		this.alunos = alunos;
	}

	public String getNomeTurma() {
		return nomeTurma;
	}

	public void setNomeTurma(String nomeTurma) {
		this.nomeTurma = nomeTurma;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
	
	public int getAnoTurma() {
		return anoTurma;
	}
	public void setAnoTurma(int anoTurma) {
		this.anoTurma = anoTurma;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
		
}
