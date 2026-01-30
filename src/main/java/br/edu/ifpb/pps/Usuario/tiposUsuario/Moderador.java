package br.edu.ifpb.pps.Usuario.tiposUsuario;

import br.edu.ifpb.pps.Enums.UsuarioTipo;
import br.edu.ifpb.pps.Usuario.Usuario;

public class Moderador extends Usuario {

    public Moderador(String nome) {
        super(nome, UsuarioTipo.MODERADOR);

    }

}
