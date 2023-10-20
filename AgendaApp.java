package exercicio_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Contato {
    private String nome;
    private String numeroTelefone;
    private String email;
    private String aniversario;

    public Contato(String nome, String numeroTelefone, String email, String aniversario) {
        this.nome = nome;
        this.numeroTelefone = numeroTelefone;
        this.email = email;
        this.aniversario = aniversario;
    }

    public String getNome() {
        return nome;
    }

    public String getNumeroTelefone() {
        return numeroTelefone;
    }

    public String getEmail() {
        return email;
    }

    public String getAniversario() {
        return aniversario;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + "\nTelefone: " + numeroTelefone + "\nEmail: " + email + "\nAniversario: "
                + aniversario;
    }
}

class Agenda {
    private List<Contato> contatos = new ArrayList<>();

    public void adicionarContato(Contato contato) {
        contatos.add(contato);
    }

    public void removerContato(int indice) {
        if (indice >= 0 && indice < contatos.size()) {
            contatos.remove(indice);
        } else {
            System.out.println("Índice inválido");
        }
    }

    public void listarContatos() {
        for (int i = 0; i < contatos.size(); i++) {
            System.out.println("Contato #" + i);
            System.out.println(contatos.get(i));
            System.out.println("------------");
        }
    }
}

public class AgendaApp {
    public static void main(String[] args) {
        Agenda agenda = new Agenda();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Adicionar contato");
            System.out.println("2 - Remover contato");
            System.out.println("3 - Listar contatos");
            System.out.println("4 - Sair");
            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = scanner.next();
                    System.out.print("Telefone: ");
                    String telefone = scanner.next();
                    System.out.print("Email: ");
                    String email = scanner.next();
                    System.out.print("Aniversário: ");
                    String aniversario = scanner.next();
                    Contato novoContato = new Contato(nome, telefone, email, aniversario);
                    agenda.adicionarContato(novoContato);
                    break;
                case 2:
                    System.out.print("Índice do contato a ser removido: ");
                    int indice = scanner.nextInt();
                    agenda.removerContato(indice);
                    break;
                case 3:
                    agenda.listarContatos();
                    break;
                case 4:
                    System.out.println("Saindo da aplicação.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
