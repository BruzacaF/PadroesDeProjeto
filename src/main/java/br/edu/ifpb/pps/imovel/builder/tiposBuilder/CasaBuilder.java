package br.edu.ifpb.pps.imovel.builder.tiposBuilder;

import br.edu.ifpb.pps.Enums.ImovelTipo;
import br.edu.ifpb.pps.Usuario.tiposUsuario.Anunciante;
import br.edu.ifpb.pps.imovel.DadosImovel;
import br.edu.ifpb.pps.imovel.Imovel;
import br.edu.ifpb.pps.imovel.builder.ImovelBuilder;
import br.edu.ifpb.pps.imovel.tipoImovel.Casa;

import br.edu.ifpb.pps.Usuario.tiposUsuario.Anunciante;
import java.util.List;

public class CasaBuilder implements ImovelBuilder {

    private Casa casa;

    public CasaBuilder() {
        this.casa = new Casa();
    }

    @Override
    public void resetar() {

    }

    @Override
    public void definirDadosBasicos(String titulo, Anunciante usuario, ImovelTipo tipo) {
        casa.setTitulo(titulo);
        casa.setUsuario(usuario);
        casa.setTipo(tipo);
    }

    @Override
    public void definirCaracteristicasComuns(double area, String endereco, int quartos, int banheiros,
                                             int vagasGaragem, String descricao) {
        casa.setArea(area);
        casa.setEndereco(endereco);
        casa.setQuartos(quartos);
        casa.setBanheiros(banheiros);
        casa.setVagasGaragem(vagasGaragem);
        casa.setDescricao(descricao);
    }

    @Override
    public void definirCaracteristicasEspecificas(DadosImovel dados) {
        casa.setPiscina(dados.getPiscina());
        casa.setQuintal(dados.getQuintal());
    }

    @Override
    public Imovel getResultado() {
        return casa;
    }
}
