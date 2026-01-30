package br.edu.ifpb.pps.repository.repositoryConfig;
import java.util.List;

public interface Repository<T, ID> {

    void salvar(T entidade);

    T buscarPorId(ID id);

    List<T> listarTodos();

    void remover(ID id);
}
