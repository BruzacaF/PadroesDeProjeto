package br.edu.ifpb.pps.imovel.builder;

import br.edu.ifpb.pps.Usuario.tiposUsuario.Anunciante;
import br.edu.ifpb.pps.imovel.Imovel;

public interface ImovelBuilder {
    ImovelBuilder titulo(String titulo);
    ImovelBuilder preco(double preco);
    ImovelBuilder usuario(Anunciante usuario);
    Imovel build();
}