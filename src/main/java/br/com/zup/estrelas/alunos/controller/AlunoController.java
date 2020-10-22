package br.com.zup.estrelas.alunos.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.estrelas.alunos.entity.Aluno;
import br.com.zup.estrelas.alunos.repository.AlunoRepository;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
	
	@Autowired
	AlunoRepository repository;
	
	@PostMapping
	public Aluno insereAluno(@RequestBody Aluno aluno) {
	return this.repository.save(aluno);
	}
	
	@GetMapping(path = "/{matricula}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public Aluno buscaAlunoPorMatricula(@PathVariable Long matricula) {
	return repository.findById(matricula).get();
	}
	
	@GetMapping(path = "/cpf/{cpf}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public Aluno buscaAlunoPorCpf(@PathVariable String cpf) {
		return repository.findByCpf(cpf);
	}
	
	@GetMapping(path = "/nome/{nome}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public Aluno buscaAlunoPorNome(@PathVariable String nome) {
		return repository.findByNome(nome);
	}
	
	

	
	
	
	
	
	
}
