package br.edu.ifpb.pps.Factory;
import br.edu.ifpb.pps.Enums.ImovelTipo;
import br.edu.ifpb.pps.Usuario.tiposUsuario.Anunciante;
import br.edu.ifpb.pps.imovel.Imovel;
import br.edu.ifpb.pps.imovel.builder.ImovelBuilder;

public abstract class ImovelAbstractFactory {
    public abstract ImovelBuilder criarBuilder(ImovelTipo tipo, Anunciante usuario);
}