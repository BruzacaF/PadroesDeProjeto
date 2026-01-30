package br.edu.ifpb.pps.imovel.templateMethod;
import br.edu.ifpb.pps.Enums.ImovelTipo;
import br.edu.ifpb.pps.Factory.ImovelAbstractFactory;
import br.edu.ifpb.pps.Factory.ImovelFactoryConcreta;
import br.edu.ifpb.pps.Usuario.tiposUsuario.Anunciante;
import br.edu.ifpb.pps.imovel.Imovel;
import br.edu.ifpb.pps.imovel.builder.ImovelBuilder;

public abstract class PrototipoTemplateImovel {

    private final ImovelAbstractFactory factory = new ImovelFactoryConcreta();

    public final Imovel criarPrototipo(
            Anunciante usuario,
            String nomePadrao) {

        validarUsuario(usuario);
        validarNome(nomePadrao);

        Imovel imovel = construirImovel(usuario);

        usuario.getCatalogo().adicionar(nomePadrao, imovel);

        return imovel;
    }

    protected abstract Imovel construirImovel(Anunciante usuario);

    protected void validarUsuario(Anunciante usuario) {
        if (usuario == null) {
            throw new IllegalArgumentException("Usuário inválido");
        }
    }

    protected void validarNome(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome do padrão inválido");
        }
    }

    protected Imovel criarViaFactory(ImovelTipo tipo, Anunciante usuario) {
        ImovelBuilder builder = factory.criarBuilder(tipo, usuario);
        return builder
                .titulo("Protótipo " + tipo)   // título padrão
                .preco(0.0)                    // preço default
                .build();
    }
}
