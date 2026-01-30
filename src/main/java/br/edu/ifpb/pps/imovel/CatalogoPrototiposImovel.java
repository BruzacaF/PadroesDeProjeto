package br.edu.ifpb.pps.imovel;
import br.edu.ifpb.pps.Enums.ImovelTipo;
import br.edu.ifpb.pps.Usuario.Usuario;
import br.edu.ifpb.pps.Usuario.tiposUsuario.Anunciante;

import java.util.HashMap;
import java.util.Map;

public class CatalogoPrototiposImovel {

    private Map<String, Imovel> prototipos = new HashMap<>();

    public void adicionar(String nome, Imovel imovel) {
        prototipos.put(nome.toLowerCase(), imovel);
    }

    public Imovel obter(String nome) {
        return prototipos.get(nome.toLowerCase());
    }

    public Map<String, Imovel> listar() {
        return prototipos;
    }

    public void listarBonito() {
        prototipos.forEach((chave, imovel) -> {
            System.out.println("Chave: " + chave + " | Imóvel: " + imovel.titulo + " | Preço:" + imovel.preco);
        });
    }

}
