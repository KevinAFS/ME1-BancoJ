package repository;

import model.Tarefa;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TarefaRepository {
    private List<Tarefa> tarefas;

    public TarefaRepository() {
        this.tarefas = new ArrayList<>();
    }

    public void adicionar(Tarefa tarefa) {
        tarefas.add(tarefa);
    }

    public List<Tarefa> listar() {
        return tarefas;
    }

    public Optional<Tarefa> buscarPorId(int id) {
        return tarefas.stream().filter(t -> t.getId() == id).findFirst();
    }

    public void remover(Tarefa tarefa) {
        tarefas.remove(tarefa);
    }
}
