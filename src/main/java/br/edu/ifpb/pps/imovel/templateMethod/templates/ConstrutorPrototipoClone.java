package br.edu.ifpb.pps.imovel.templateMethod.templates;
import br.edu.ifpb.pps.Usuario.tiposUsuario.Anunciante;
import br.edu.ifpb.pps.imovel.Imovel;
import br.edu.ifpb.pps.imovel.templateMethod.PrototipoTemplateImovel;

public class ConstrutorPrototipoClone extends PrototipoTemplateImovel {

    private final Imovel prototipoBase;

    public ConstrutorPrototipoClone(Imovel prototipoBase) {
        this.prototipoBase = prototipoBase;
    }

    @Override
    protected Imovel construirImovel(Anunciante usuario) {
        Imovel clone = prototipoBase.clonar();
        return clone;
    }
}
