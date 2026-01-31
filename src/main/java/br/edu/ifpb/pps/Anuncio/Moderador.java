package br.edu.ifpb.pps.Anuncio;

import br.edu.ifpb.pps.Anuncio.CoR.FiltroPrecoValidoHandler;
import br.edu.ifpb.pps.Anuncio.CoR.FiltroTermosProibidosHandler;
import br.edu.ifpb.pps.Anuncio.CoR.ModeracaoHandler;

import javax.swing.*;
import java.util.Scanner;

public class Moderador {
    private static Moderador instancia;
    private ModeracaoHandler corrente;

    // Construtor privado
    private Moderador() {
        FiltroTermosProibidosHandler termos = new FiltroTermosProibidosHandler();
        FiltroPrecoValidoHandler preco = new FiltroPrecoValidoHandler();

        termos.setNext(preco);

        this.corrente = termos;
    }

    // Método estático para obter a instância única
    public static Moderador getInstancia() {
        if (instancia == null) {
            instancia = new Moderador();
        }
        return instancia;
    }

    public boolean moderarManual(Anuncio anuncio) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("🔎 Moderação manual para anúncio: " + anuncio.getTitulo());
        System.out.print("Digite 's' para aprovar ou 'n' para reprovar: ");
        String resposta = scanner.nextLine().trim().toLowerCase();

        if (resposta.equals("s")) {
            System.out.println("✅ Moderador manual aprovou o anúncio: " + anuncio.getTitulo());
            return true;
        } else {
            System.out.println("❌ Moderador manual reprovou o anúncio: " + anuncio.getTitulo());
            return false;
        }
    }



    // Método de moderação
    public boolean moderar(Anuncio anuncio) {
        return corrente.handle(anuncio);
    }
}