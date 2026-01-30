package br.edu.ifpb.pps.repository;

import br.edu.ifpb.pps.Anuncio.Anuncio;
import br.edu.ifpb.pps.Anuncio.Estados.Ativo;
import br.edu.ifpb.pps.repository.repositoryConfig.InMemoryRepository;

import java.util.List;

public class AnuncioRepository extends InMemoryRepository<Anuncio, String> {

    private static AnuncioRepository AnuncioRepository;

    private AnuncioRepository() {}

    public static AnuncioRepository getInstancia() {
        if (AnuncioRepository == null) {
            AnuncioRepository = new AnuncioRepository();
        }
        return AnuncioRepository;
    }

    @Override
    protected String getId(Anuncio anuncio) {
        return anuncio.getTitulo(); // ou UUID
    }

}
