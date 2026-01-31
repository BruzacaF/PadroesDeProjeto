package br.edu.ifpb.pps.imovel.builder;

import br.edu.ifpb.pps.Enums.ImovelTipo;
import br.edu.ifpb.pps.Usuario.tiposUsuario.Anunciante;
import br.edu.ifpb.pps.imovel.DadosImovel;
import br.edu.ifpb.pps.imovel.Imovel;

public class ImovelDirector {

    private final ImovelBuilder builder;

    public ImovelDirector(ImovelBuilder builder) {
        this.builder = builder;
    }

    public Imovel construirImovel(DadosImovel dados, Anunciante usuario, ImovelTipo tipo) {

        builder.definirDadosBasicos(
                dados.getTitulo(),
                usuario,
                tipo
        );

        builder.definirCaracteristicasComuns(
                dados.getArea(),
                dados.getEndereco(),
                dados.getQuartos(),
                dados.getBanheiros(),
                dados.getVagasGaragem(),
                dados.getDescricao()
        );

        builder.definirCaracteristicasEspecificas(dados);

        return builder.getResultado();
    }
}
