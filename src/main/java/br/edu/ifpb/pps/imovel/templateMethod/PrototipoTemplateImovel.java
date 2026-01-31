package br.edu.ifpb.pps.imovel.templateMethod;
import br.edu.ifpb.pps.Enums.ImovelTipo;
import br.edu.ifpb.pps.Usuario.tiposUsuario.Anunciante;
import br.edu.ifpb.pps.imovel.DadosImovel;
import br.edu.ifpb.pps.imovel.Imovel;
import br.edu.ifpb.pps.imovel.builder.ImovelBuilder;
import br.edu.ifpb.pps.imovel.builder.ImovelDirector;
import br.edu.ifpb.pps.imovel.builder.tiposBuilder.ApartamentoBuilder;
import br.edu.ifpb.pps.imovel.builder.tiposBuilder.CasaBuilder;


public abstract class PrototipoTemplateImovel {

    // TEMPLATE METHOD (não pode ser sobrescrito)
    public final Imovel executarFluxo(Anunciante usuario, String nomePadrao, DadosImovel dados) {
        validarUsuario(usuario);
        validarNome(nomePadrao);

        Imovel imovel = obterImovelBase(usuario, dados);

        aplicarDadosExtras(imovel, dados, usuario); // hook opcional

        registrarNoCatalogo(usuario, nomePadrao, imovel);

        return imovel;
    }

    // === ETAPAS ABSTRATAS ===

    protected abstract Imovel obterImovelBase(Anunciante usuario, DadosImovel dados);

    // === ETAPAS COM IMPLEMENTAÇÃO PADRÃO ===

    protected void validarUsuario(Anunciante usuario) {
        if (usuario == null) throw new IllegalArgumentException("Usuário inválido");
    }

    protected void validarNome(String nome) {
        if (nome == null || nome.isBlank()) throw new IllegalArgumentException("Nome do padrão inválido");
    }

    protected void registrarNoCatalogo(Anunciante usuario, String nomePadrao, Imovel imovel) {
        usuario.getCatalogo().adicionar(nomePadrao, imovel);
    }

    // === HOOK (pode ser sobrescrito ou não) ===
    protected void aplicarDadosExtras(Imovel imovel, DadosImovel dados, Anunciante usuario) {
        // implementação padrão: não faz nada
    }
}
