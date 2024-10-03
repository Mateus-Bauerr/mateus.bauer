import java.util.HashMap;

public class FazPix { 
    private HashMap<String, String> chavesPix; // Armazena as chaves Pix

    public FazPix() {
        chavesPix = new HashMap<>();
    }

    // Adiciona uma nova chave Pix
    public void adicionarChavePix(String chavePix, String descricao) {
        chavesPix.put(chavePix, descricao);
        System.out.println("Chave Pix cadastrada.");
    }

    // Remove uma chave Pix
    public void removerChavePix(String chavePix) {
        if (chavesPix.containsKey(chavePix)) {
            chavesPix.remove(chavePix);
            System.out.println("Chave Pix removida.");
        } else {
            System.out.println("Essa chave Pix não existe!");
        }
    }

    // Lista todas as chaves Pix
    public void listarChavesPix() {
        if (chavesPix.isEmpty()) {
            System.out.println("Nenhuma chave Pix cadastrada.");
        } else {
            System.out.println("Chaves Pix cadastradas:");
            for (String chave : chavesPix.keySet()) {
                System.out.println(chave + " - " + chavesPix.get(chave));
            }
        }
    }

    // Verifica se a chave Pix existe
    public boolean chaveExiste(String chavePix) {
        return chavesPix.containsKey(chavePix);
    }
}
