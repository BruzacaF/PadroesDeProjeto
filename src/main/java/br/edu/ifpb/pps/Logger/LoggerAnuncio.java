package br.edu.ifpb.pps.Logger;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LoggerAnuncio {
    private static LoggerAnuncio instancia;
    private static final String ARQUIVO_LOG = "logs/anuncios.log";
    private static final DateTimeFormatter FORMATO_DATA = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private PrintWriter writer;

    private LoggerAnuncio() {
        try {
            new java.io.File("logs").mkdirs();
            
            FileWriter fw = new FileWriter(ARQUIVO_LOG, true);
            writer = new PrintWriter(fw, true); // true = autoflush
        } catch (IOException e) {
            System.err.println("Erro ao inicializar logger: " + e.getMessage());
        }
    }

    public static synchronized LoggerAnuncio getInstancia() {
        if (instancia == null) {
            instancia = new LoggerAnuncio();
        }
        return instancia;
    }

    public static void registrar(String mensagem) {
        LoggerAnuncio logger = getInstancia();
        String timestamp = LocalDateTime.now().format(FORMATO_DATA);
        String logMessage = String.format("[%s] %s", timestamp, mensagem);
        
        if (logger.writer != null) {
            logger.writer.println(logMessage);
        }
        System.out.println("📝 Log: " + mensagem);
    }

    public static void fechar() {
        LoggerAnuncio logger = getInstancia();
        if (logger.writer != null) {
            logger.writer.close();
        }
    }
}