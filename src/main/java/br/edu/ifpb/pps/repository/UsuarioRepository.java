package br.edu.ifpb.pps.repository;

import br.edu.ifpb.pps.Usuario.Usuario;
import br.edu.ifpb.pps.repository.repositoryConfig.InMemoryRepository;

public class UsuarioRepository extends InMemoryRepository<Usuario, String> {

    private static UsuarioRepository instancia;

    private UsuarioRepository() {}

    public static UsuarioRepository getInstancia() {
        if (instancia == null) {
            instancia = new UsuarioRepository();
        }
        return instancia;
    }

    @Override
    protected String getId(Usuario usuario) {
        return usuario.getNome(); // ou UUID
    }
}
