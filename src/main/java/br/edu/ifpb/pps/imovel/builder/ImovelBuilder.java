package br.edu.ifpb.pps.imovel.builder;

import br.edu.ifpb.pps.Enums.ImovelTipo;
import br.edu.ifpb.pps.Usuario.tiposUsuario.Anunciante;
import br.edu.ifpb.pps.imovel.DadosImovel;
import br.edu.ifpb.pps.imovel.Imovel;
import br.edu.ifpb.pps.imovel.builder.tiposBuilder.ApartamentoBuilder;

import java.util.List;

public interface ImovelBuilder {

    void resetar();

    void definirDadosBasicos(String titulo, Anunciante usuario, ImovelTipo tipo);

    void definirCaracteristicasComuns(double area, String endereco, int quartos, int banheiros,
                                      int vagasGaragem, String descricao);

    void definirCaracteristicasEspecificas(DadosImovel dados);

    Imovel getResultado();
}
