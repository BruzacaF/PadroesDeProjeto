package br.edu.ifpb.pps.Factory;

import br.edu.ifpb.pps.Enums.UsuarioTipo;
import br.edu.ifpb.pps.Usuario.tiposUsuario.Anunciante;
import br.edu.ifpb.pps.Usuario.tiposUsuario.Moderador;
import br.edu.ifpb.pps.Usuario.Usuario;
import br.edu.ifpb.pps.Usuario.tiposUsuario.UsuarioComum;

public class UsuarioFactory {
    public static Usuario criarUsuario(String nome, UsuarioTipo tipo) {
        switch (tipo) {
            case ANUNCIANTE:
                return new Anunciante(nome);
            case USUARIO_COMUM:
                return new UsuarioComum(nome);
            case MODERADOR:
                return new Moderador(nome);
            default:
                throw new IllegalArgumentException("Tipo de usuário inválido: " + tipo);
        }
    }
}