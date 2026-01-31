package br.edu.ifpb.pps.Usuario.tiposUsuario;

import br.edu.ifpb.pps.Enums.UsuarioTipo;
import br.edu.ifpb.pps.Usuario.Usuario;
import br.edu.ifpb.pps.imovel.CatalogoPrototiposImovel;

public class Anunciante extends Usuario {

    private final CatalogoPrototiposImovel catalogo = new CatalogoPrototiposImovel();

    public Anunciante(String nome) {
        super(nome, UsuarioTipo.ANUNCIANTE);
    }

    public CatalogoPrototiposImovel getCatalogo() {
        return catalogo;
    }
}
