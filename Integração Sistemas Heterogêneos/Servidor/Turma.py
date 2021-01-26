#Class

class Turma:
	def __init__(self, id, anoTurma, cursoTurma,nomeTurma):
		self.id = id
		self.anoTurma = anoTurma
		self.cursoTurma = cursoTurma
		self.nomeTurma = nomeTurma

	def getNomeTurma(self):
		return self.nomeTurma

	def getId(self):
		return self.id

	def getAnoTurma(self):
		return self.anoTurma

	def getSiglaTurma(self):
		return self.cursoTurma


	def setNomeTurma(self,nomeTurma):
		self.nomeTurma = nomeTurma

	def setIdTurma(self, idTurma):
		self.idTurma = idTurma

	def setAnoTurma(self, anoTurma):
		self.AnoTurma = anoTurma

	def setCursoTurma(self, cursoTurma):
		self.cursoTurma = cursoTurma


	#toString
	def __str__(self):
		return "A turma " + str(self.nomeTurma) + " de " + str(self.anoTurma) + " do curso " + str(self.cursoTurma)