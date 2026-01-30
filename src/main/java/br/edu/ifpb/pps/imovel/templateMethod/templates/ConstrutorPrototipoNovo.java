package br.edu.ifpb.pps.imovel.templateMethod.templates;

import br.edu.ifpb.pps.Enums.ImovelTipo;
import br.edu.ifpb.pps.Usuario.tiposUsuario.Anunciante;
import br.edu.ifpb.pps.imovel.Imovel;
import br.edu.ifpb.pps.imovel.templateMethod.PrototipoTemplateImovel;

public class ConstrutorPrototipoNovo extends PrototipoTemplateImovel {
    private final ImovelTipo tipo;

    public ConstrutorPrototipoNovo(ImovelTipo tipo) {
        this.tipo = tipo;
    }

    @Override
    protected Imovel construirImovel(Anunciante usuario) {
        return criarViaFactory(tipo, usuario);
    }
}