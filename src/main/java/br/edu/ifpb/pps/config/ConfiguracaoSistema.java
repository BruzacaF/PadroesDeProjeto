package br.edu.ifpb.pps.config;

import java.util.Properties;
import java.io.InputStream;
import java.io.IOException;

public class ConfiguracaoSistema {
    private static ConfiguracaoSistema instancia;
    private Properties propriedades;

    // Construtor privado
    private ConfiguracaoSistema() {
        propriedades = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            if (input != null) {
                propriedades.load(input);
            } else {
                throw new RuntimeException("Arquivo config.properties não encontrado!");
            }
        } catch (IOException e) {
            throw new RuntimeException("Erro ao carregar configurações", e);
        }
    }

    // Método estático para obter a instância única
    public static ConfiguracaoSistema getInstancia() {
        if (instancia == null) {
            instancia = new ConfiguracaoSistema();
        }
        return instancia;
    }

    // Método para recuperar valores
    public String getPropriedade(String chave) {
        return propriedades.getProperty(chave);
    }
}