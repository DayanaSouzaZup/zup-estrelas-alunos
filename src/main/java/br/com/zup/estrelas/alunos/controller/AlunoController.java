package br.com.zup.estrelas.alunos.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.estrelas.alunos.entity.Aluno;
import br.com.zup.estrelas.alunos.service.AlunoService;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
	
	@Autowired
	AlunoService alunoService; // instaciamento da classe AlunoService

	@PostMapping
	public Aluno insereAluno(@RequestBody Aluno aluno) {
		return this.alunoService.insereAluno(aluno);
	}

	@GetMapping(path = "/{matricula}", produces = { MediaType.APPLICATION_JSON_VALUE })

	public Aluno buscaAlunoPorMatricula(@PathVariable Long matricula) {

		return alunoService.buscaAlunoPorMatricula(matricula);
	}

	@GetMapping(path = "/cpf/{cpf}", produces = { MediaType.APPLICATION_JSON_VALUE })

	public Optional<Aluno> buscaAlunoPorCpf(@PathVariable String cpf) {

		return alunoService.buscaPorCpf(cpf);

	}

	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })

	public List<Aluno> listaAlunos() {

		return alunoService.listaAlunos();

	}

	@DeleteMapping(path = "/{matricula}", produces = { MediaType.APPLICATION_JSON_VALUE })

	public String removeAluno(@PathVariable long matricula) {

		boolean verificaRemocao = alunoService.removeAluno(matricula);

		if (verificaRemocao) {
			return ("Aluno removido com sucesso");
		}
		return ("Matrícula inexistente");
	}

	@PutMapping(path = "/{matricula}", produces = { MediaType.APPLICATION_JSON_VALUE })

	public Aluno alteraAluno(@PathVariable Long matricula, @RequestBody Aluno aluno) {

		return this.alunoService.alteraAluno(aluno);
	}

}

/*
 * @PostMapping public Aluno insereAluno(@RequestBody Aluno aluno) { return*
 * this.repository.save(aluno); }
 * 
 * @GetMapping(path = "/{matricula}", produces =
 * {MediaType.APPLICATION_JSON_VALUE}) public Aluno
 * buscaAlunoPorMatricula(@PathVariable Long matricula) { return
 * repository.findById(matricula).get(); }
 * 
 * @GetMapping(path = "/cpf/{cpf}", produces =
 * {MediaType.APPLICATION_JSON_VALUE}) public Aluno
 * buscaAlunoPorCpf(@PathVariable String cpf) { return
 * repository.findByCpf(cpf); }
 * 
 * @GetMapping(path = "/nome/{nome}", produces =
 * {MediaType.APPLICATION_JSON_VALUE}) public Aluno
 * buscaAlunoPorNome(@PathVariable String nome) { return
 * repository.findByNome(nome); }
 */

/*
 * @GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE }) public
 * List<Aluno> buscaPorAlunos() { return
 * alunoService.buscaAlunoPorMatricula(matricula); }
 */