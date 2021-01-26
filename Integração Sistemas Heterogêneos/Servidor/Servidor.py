
import socket
import json

from Turma import Turma

def qtdeAlunosEMatriculas(dados):
	contadorAlunos = 0
	contadorMatricula = 0
	for alunos in dados["alunos"]:
		contadorAlunos +=1
		if (alunos['matriculado'] == True):
			contadorMatricula +=1
	return contadorAlunos, contadorMatricula



host = '127.0.0.1' 
port = 12345 
addr = (host, port)
while(True):
	serv_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
	serv_socket.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1) 
	serv_socket.bind(addr) 
	serv_socket.listen(1000) 
	print('aguardando conexao')
	con, cliente = serv_socket.accept() 
	print('conectado') 

	recebe = con.recv(1024) 
	dados = json.loads(recebe)


	turma1 = Turma(dados['id'],dados['anoTurma'],dados['curso'],dados['nomeTurma'])

	contagemAlunos, matriculas = qtdeAlunosEMatriculas(dados)

	print(str(turma1) + " possui " + str(contagemAlunos) + " alunos, dos quais " + str(matriculas) + " estão devidamente matriculados.")
	serv_socket.close