package br.edu.ifpb.pps.Usuario;
import br.edu.ifpb.pps.Enums.UsuarioTipo;
import br.edu.ifpb.pps.imovel.CatalogoPrototiposImovel;

public abstract class Usuario {

    protected String nome;
    protected UsuarioTipo tipo;


    public Usuario(String nome, UsuarioTipo tipo) {
        this.nome = nome;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }
}
