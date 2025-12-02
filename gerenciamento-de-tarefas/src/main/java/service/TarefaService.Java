package service;

import model.Tarefa;
import repository.TarefaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class TarefaService {
    private TarefaRepository repository;

    public TarefaService() {
        this.repository = new TarefaRepository();
    }

    public void cadastrarTarefa(String titulo, String descricao, LocalDate dataConclusao) {
        Tarefa tarefa = new Tarefa(titulo, descricao, dataConclusao);
        repository.adicionar(tarefa);
        System.out.println("Tarefa cadastrada com sucesso!");
    }

    public List<Tarefa> listarTarefas() {
        return repository.listar();
    }

    public boolean atualizarTarefa(int id, String novoTitulo, String novaDescricao, LocalDate novaDataConclusao) {
        Optional<Tarefa> tarefaOpt = repository.buscarPorId(id);
        if (tarefaOpt.isPresent()) {
            Tarefa tarefa = tarefaOpt.get();
            tarefa.setTitulo(novoTitulo);
            tarefa.setDescricao(novaDescricao);
            tarefa.setDataConclusao(novaDataConclusao);
            return true;
        }
        return false;
    }

    public boolean excluirTarefa(int id) {
        Optional<Tarefa> tarefaOpt = repository.buscarPorId(id);
        if (tarefaOpt.isPresent()) {
            repository.remover(tarefaOpt.get());
            return true;
        }
        return false;
    }
}
