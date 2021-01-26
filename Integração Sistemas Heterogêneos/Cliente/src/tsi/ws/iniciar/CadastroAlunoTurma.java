package tsi.ws.iniciar;

import static tsi.ws.entradaesaida.EntradaESaida.converteInteiro;
import static tsi.ws.entradaesaida.EntradaESaida.exibirTexto;
import static tsi.ws.entradaesaida.EntradaESaida.inputString;

import com.google.gson.*;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import tsi.ws.modelo.Aluno;
import tsi.ws.modelo.Turma;
public class CadastroAlunoTurma {

	public static void main(String[] args) {
		iniciar();
	}

	public static void iniciar() {
		List<Turma> turmas = new ArrayList<>();
		int op = 0;
		do {
			op = converteInteiro("Menu","1-Cadastrar Turma\n2-Cadastrar Aluno\n3-Enviar Dados\n4-Sair\n\nOpção:");
			switch (op) {
			case 1:
				cadastrarTurma(turmas);
				break;
			case 2:
				cadastrarAluno(turmas);
				break;
			case 3:
				enviarToServidor(turmas);
				break;
			}
		}while(op != 4);
	}

	public static void enviarToServidor(List<Turma> turmas) {
		if(turmas.size() == 0)
			exibirTexto("Envio de Dados", "Cadastre uma turma primeiro!");
		else{
			Gson gson = new Gson();
			int numeroTurma = converteInteiro("Envio de Dados", "Id da turma para envio de dados:");
			if(turmas.size() >= numeroTurma) {
				
				if(turmas.get(numeroTurma-1).getAlunos() != null) {
					String json = gson.toJson(turmas.get(numeroTurma-1));
					System.out.println("-->"+json);
					try {
						Socket cliente = new Socket("127.0.0.1",12345);
						try(OutputStreamWriter out = new OutputStreamWriter(cliente.getOutputStream(),StandardCharsets.UTF_8)) {
							out.write(json);
						}
						cliente.close();
					} catch (UnknownHostException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
					
				}
				else
					exibirTexto("Envio de Dados", "Cadastre alunos na turma primeiro!");
			}
			else
				exibirTexto("Envio de Dados", "Id de Turma inexistente!");
		}
	}

	public static void cadastrarAluno(List<Turma> turmas) {
		int numeroTurma = converteInteiro("Cadastro de Alunos", "ID da turma que se deseja cadastrar o aluno:");
		if(turmas.size() >= numeroTurma) {
			List<Aluno>alunos = new ArrayList<Aluno>();

			if(turmas.get(numeroTurma-1).getAlunos()!= null)
				alunos = turmas.get(numeroTurma-1).getAlunos();

			Turma turma = turmas.get(numeroTurma-1);

			int cadastro = 0;
			do {
				Aluno aluno = new Aluno();
				aluno.setNomeAluno(inputString("Cadastro de Alunos", "Nome do Aluno"));
				aluno.setMatriculado((converteInteiro("Cadastro de Alunos:","O Aluno está matriculado?\n1-Sim\n2-Não:")== 1) ? true:false );
				alunos.add(aluno);
				turma.setAlunos(alunos);
				turmas.add(turma);
				cadastro = converteInteiro("Cadastro de Alunos", "Cadastrar novo aluno?\n1-Sim\n2-Não:");
			}while(cadastro == 1);
		}else {
			exibirTexto("Cadastro de Alunos", "ID da Turma Inexistente:");
		}

	}

	public static void cadastrarTurma(List<Turma> turmas) {
		Turma turma = new Turma();
		turma.setNomeTurma(inputString("Cadastro de Turma", "Nome da Turma:"));
		turma.setAnoTurma(converteInteiro("Cadastro de Turma", "Ano da Turma:"));
		turma.setCurso(inputString("Cadastro de Turma", "Curso da Turma:"));
		turmas.add(turma);
		System.out.println(turma.getId());
	}
}
