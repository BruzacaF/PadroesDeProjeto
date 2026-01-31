package br.edu.ifpb.pps.imovel.templateMethod.templates;

import br.edu.ifpb.pps.Enums.ImovelTipo;
import br.edu.ifpb.pps.Usuario.tiposUsuario.Anunciante;
import br.edu.ifpb.pps.imovel.DadosImovel;
import br.edu.ifpb.pps.imovel.Imovel;
import br.edu.ifpb.pps.imovel.builder.ImovelBuilder;
import br.edu.ifpb.pps.imovel.builder.ImovelDirector;
import br.edu.ifpb.pps.imovel.builder.tiposBuilder.ApartamentoBuilder;
import br.edu.ifpb.pps.imovel.builder.tiposBuilder.CasaBuilder;
import br.edu.ifpb.pps.imovel.templateMethod.PrototipoTemplateImovel;

public class CriarPrototipoDoZero extends PrototipoTemplateImovel {

    private final ImovelTipo tipo;

    public CriarPrototipoDoZero(ImovelTipo tipo) {
        this.tipo = tipo;
    }

    @Override
    protected Imovel obterImovelBase(Anunciante usuario, DadosImovel dados) {
        ImovelBuilder builder;

        switch (tipo) {
            case APARTAMENTO -> builder = new ApartamentoBuilder();
            case CASA -> builder = new CasaBuilder();
            default -> throw new IllegalArgumentException("Tipo de imóvel não suportado: " + tipo);
        }

        ImovelDirector director = new ImovelDirector(builder);

        return director.construirImovel(dados, usuario, tipo);
    }
}
