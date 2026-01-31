package br.edu.ifpb.pps.imovel.templateMethod.templates;
import br.edu.ifpb.pps.Usuario.tiposUsuario.Anunciante;
import br.edu.ifpb.pps.imovel.CatalogoGlobalPrototipos;
import br.edu.ifpb.pps.imovel.DadosImovel;
import br.edu.ifpb.pps.imovel.Imovel;
import br.edu.ifpb.pps.imovel.templateMethod.PrototipoTemplateImovel;

public class ClonarPrototipoGlobal extends PrototipoTemplateImovel {

    private final String nomePrototipoGlobal;

    public ClonarPrototipoGlobal(String nomePrototipoGlobal) {
        this.nomePrototipoGlobal = nomePrototipoGlobal;
    }

    @Override
    protected Imovel obterImovelBase(Anunciante usuario, DadosImovel dados) {
        return CatalogoGlobalPrototipos
                .getInstancia()
                .obterClone(nomePrototipoGlobal);
    }

    @Override
    protected void aplicarDadosExtras(Imovel imovel, DadosImovel dados, Anunciante usuario) {
        imovel.setUsuario(usuario);

        if (dados.getTitulo() != null) imovel.setTitulo(dados.getTitulo());
        if (dados.getArea() != null) imovel.setArea(dados.getArea());
        if (dados.getEndereco() != null) imovel.setEndereco(dados.getEndereco());
        if (dados.getDescricao() != null) imovel.setDescricao(dados.getDescricao());
    }
}
