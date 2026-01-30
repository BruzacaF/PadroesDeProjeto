package br.edu.ifpb.pps.Usuario.tiposUsuario;

import br.edu.ifpb.pps.Enums.UsuarioTipo;
import br.edu.ifpb.pps.Usuario.Usuario;

public class UsuarioComum extends Usuario {

    public UsuarioComum(String nome) {
        super(nome, UsuarioTipo.USUARIO_COMUM);
    }

}
