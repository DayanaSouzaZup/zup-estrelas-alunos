package br.com.zup.estrelas.alunos.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zup.estrelas.alunos.entity.Aluno;
import br.com.zup.estrelas.alunos.repository.AlunoRepository;

@Service
public class AlunoService {

	@Autowired
	AlunoRepository repository;

	public Aluno insereAluno(Aluno aluno) {

		if (repository.existsById(aluno.getMatricula())) {

			return null;
		}
		return this.repository.save(aluno);
	}

	public Aluno alteraAluno(Aluno aluno) {

		if (repository.existsById(aluno.getMatricula())) {
			// Aqui iriam os set's se houvesse uma classe alunoDTO

			return repository.save(aluno);
		}
		return null;

	}

	public Aluno buscaAlunoPorMatricula(Long matricula) {

		if (repository.existsById(matricula)) {
			return repository.findById(matricula).get();
		}

		return null;
	}

	public Optional<Aluno> buscaPorCpf(String cpf) {
		if (repository.existsByCpf(cpf)) {

			return repository.findByCpf(cpf);
		}

		return null;
	}

	public List<Aluno> listaAlunos() {
		
		return (List<Aluno>) repository.findAll();
	}

	//trocar boolean por mensagemDTO
	public boolean removeAluno(Long matricula) {
		if (repository.existsById(matricula)) {
			repository.deleteById(matricula);
			return true;
		}
		return false;
	}
}
