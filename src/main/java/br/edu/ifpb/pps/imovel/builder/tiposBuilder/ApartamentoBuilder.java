package br.edu.ifpb.pps.imovel.builder.tiposBuilder;
import br.edu.ifpb.pps.Enums.ImovelTipo;
import br.edu.ifpb.pps.Usuario.Usuario;
import br.edu.ifpb.pps.Usuario.tiposUsuario.Anunciante;
import br.edu.ifpb.pps.imovel.DadosImovel;
import br.edu.ifpb.pps.imovel.Imovel;
import br.edu.ifpb.pps.imovel.builder.ImovelBuilder;
import br.edu.ifpb.pps.imovel.tipoImovel.Apartamento;

public class ApartamentoBuilder implements ImovelBuilder {
    private Apartamento apartamento;

    public ApartamentoBuilder() {
        resetar();
    }

    @Override
    public void resetar() {
        this.apartamento = new Apartamento();
    }

    @Override
    public void definirDadosBasicos(String titulo,  Anunciante usuario, ImovelTipo tipo) {
        apartamento.setTitulo(titulo);
        apartamento.setUsuario(usuario);
        apartamento.setTipo(tipo);
    }

    @Override
    public void definirCaracteristicasComuns(double area, String endereco, int quartos, int banheiros,
                                             int vagasGaragem, String descricao) {
        apartamento.setArea(area);
        apartamento.setEndereco(endereco);
        apartamento.setQuartos(quartos);
        apartamento.setBanheiros(banheiros);
        apartamento.setVagasGaragem(vagasGaragem);
        apartamento.setDescricao(descricao);
    }

    @Override
    public void definirCaracteristicasEspecificas(DadosImovel dados) {
        apartamento.setAndar(dados.getAndar());
        apartamento.setElevador(dados.getElevador());
        apartamento.setTaxaCondominio(dados.getTaxaCondominio());
    }

    @Override
    public Imovel getResultado() {
        return apartamento;
    }
}
