package br.edu.ifpb.pps.imovel;

import br.edu.ifpb.pps.imovel.builder.tiposBuilder.ApartamentoBuilder;
import br.edu.ifpb.pps.imovel.builder.tiposBuilder.CasaBuilder;
import java.util.HashMap;
import java.util.Map;

public class CatalogoGlobalPrototipos {
    private static CatalogoGlobalPrototipos instancia;

    // Registro de protótipos globais
    private final Map<String, Imovel> prototiposBase = new HashMap<>();

    private CatalogoGlobalPrototipos() {
        registrar("apartamento_padrao", new ApartamentoBuilder()
                .titulo("Apartamento padrão")
                .preco(200000)
                .andar(2)
                .elevador(true)
                .build());

        registrar("casa_padrao", new CasaBuilder()
                .titulo("Casa padrão")
                .preco(250000)
                .quintal(true)
                .build());
    }


    public static CatalogoGlobalPrototipos getInstancia() {
        if (instancia == null) {
            instancia = new CatalogoGlobalPrototipos();
        }
        return instancia;
    }

    // Registrar novo protótipo global dinamicamente
    public void registrar(String nome, Imovel imovel) {
        prototiposBase.put(nome.toLowerCase(), imovel);
    }

    // Obter clone (Prototype)
    public Imovel obterClone(String nome) {
        Imovel base = prototiposBase.get(nome.toLowerCase());
        if (base == null) {
            throw new IllegalArgumentException("Protótipo global não encontrado: " + nome);
        }
        return base.clonar();
    }

    public void listarBonito() {
        prototiposBase.forEach((chave, imovel) -> {
            System.out.println("Protótipo global: " + chave + " | Imóvel: " + imovel.titulo);
        });
    }
}