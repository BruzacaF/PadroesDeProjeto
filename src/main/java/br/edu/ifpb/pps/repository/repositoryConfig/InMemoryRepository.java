package br.edu.ifpb.pps.repository.repositoryConfig;

import java.util.*;

public abstract class InMemoryRepository<T, ID> implements Repository<T, ID> {

    protected Map<ID, T> banco = new HashMap<>();

    protected abstract ID getId(T entidade);

    @Override
    public void salvar(T entidade) {
        banco.put(getId(entidade), entidade);
    }

    @Override
    public T buscarPorId(ID id) {
        return banco.get(id);
    }

    @Override
    public List<T> listarTodos() {
        return new ArrayList<>(banco.values());
    }

    @Override
    public void remover(ID id) {
        banco.remove(id);
    }
}
