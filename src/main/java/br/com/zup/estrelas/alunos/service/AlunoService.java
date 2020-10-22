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

			LocalDate dataRef = LocalDate.of(1990, 12, 31);

			if (aluno.getDataNascimento().isBefore(dataRef) && aluno.getValorMensalidade() > 100) {

			}

			return null;
		}
		return this.repository.save(aluno);
	}

	public Aluno alteraAluno(Aluno aluno) {

		if (repository.existsById(aluno.getMatricula())) {
			return repository.save(aluno);
		}
		return null;

	}

	public Aluno buscaAlunoPorMatricula(Long matricula) {
		return repository.findById(matricula).get();
	}

	public Optional<Aluno> buscaPorCpf(String cpf) {
		return repository.findByCpf(cpf);
	}

	public List<Aluno> listaALunos() {
		return (List<Aluno>) repository.findAll();
	}

	public boolean removeAluno(Long matricula) {
		if (repository.existsById(matricula)) {
			repository.deleteById(matricula);
			return true;
		}
		return false;
	}
}
