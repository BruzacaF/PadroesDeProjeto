package br.edu.ifpb.pps.Factory;

import br.edu.ifpb.pps.Enums.ImovelTipo;
import br.edu.ifpb.pps.Usuario.tiposUsuario.Anunciante;
import br.edu.ifpb.pps.imovel.builder.ImovelBuilder;
import br.edu.ifpb.pps.imovel.builder.tiposBuilder.ApartamentoBuilder;
import br.edu.ifpb.pps.imovel.builder.tiposBuilder.CasaBuilder;
import br.edu.ifpb.pps.imovel.builder.tiposBuilder.TerrenoBuilder;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ImovelFactoryConcreta extends ImovelAbstractFactory {
    // Registro de Builders por tipo
    private final Map<ImovelTipo, Supplier<ImovelBuilder>> registry = new HashMap<>();

    public ImovelFactoryConcreta() {
        // Registrar tipos conhecidos
        registry.put(ImovelTipo.CASA, CasaBuilder::new);
        registry.put(ImovelTipo.APARTAMENTO, ApartamentoBuilder::new);
        registry.put(ImovelTipo.TERRENO, TerrenoBuilder::new); // exemplo de novo tipo
    }

    @Override
    public ImovelBuilder criarBuilder(ImovelTipo tipo, Anunciante usuario) {
        Supplier<ImovelBuilder> builderSupplier = registry.get(tipo);
        if (builderSupplier == null) {
            throw new IllegalArgumentException("Tipo de imóvel não registrado: " + tipo);
        }
        return builderSupplier.get().usuario(usuario);
    }

    // Permite registrar novos tipos dinamicamente
    public void registrarTipo(ImovelTipo tipo, Supplier<ImovelBuilder> builderSupplier) {
        registry.put(tipo, builderSupplier);
    }
}