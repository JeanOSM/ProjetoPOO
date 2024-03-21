import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class Menu {
    static Turma[]turmas = new Turma[10];
    static int quantidadeTurma = 0;
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        
        int opcao = 0;
        do{
            exibirMenu();
            opcao = scanner.nextInt();
            roteador(opcao);
        }while(opcao != 0);
    }

    public static void roteador(int opcao) {
        switch (opcao) {
            case 1:
                cadastrarTurma();
                break;
            case 2:
                cadastroCampus(); //fazer cadastro de campus
                break;
            case 3:
                cadastrarCurso();//fazer cadastro de curso
                break;
            case 4:
                cadastroAluno();//fazer cadastro de estudante
                break;
            case 5:
                //fazer cadastro de matricula
                break;
            case 6:
                gerarRelatorio();
                break;
                
        
            default:
                if(opcao!=0){
                    System.out.println("opção invalida");
                }
                break;
        }
        
    }
    public static void gerarRelatorio() {
        for (int i = 0; i < quantidadeTurma;i++){
            System.out.println("Nome de aluno: "+ turmas[i].nome);
            System.out.println("Nome da turma "+ turmas[i].numeroMinimo);
            System.out.println("Ano Ingresso "+ turmas[i].anoIngresso);
        }
        
    
    }

   
    

    public static void cadastrarTurma() {
        scanner.nextLine(); // Apagar o \n
        Turma turma = new Turma();
        System.out.println("Nome da turma: ");
        turma.nome = scanner.nextLine();
        
        System.out.println("Numero de alunos: ");
        turma.numeroMinimo = scanner.nextInt();
        
        System.out.println("Ano Ingresso: ");
        turma.anoIngresso = scanner.nextInt();
        turmas[quantidadeTurma] = turma;
        quantidadeTurma++;
    }
    public static void cadastrarCurso() {
        Curso curso = new Curso();
        System.out.println("Nome do curso: ");
        curso.nome = scanner.nextLine();
        System.out.println("Descrição do curso: ");
        curso.descricao = scanner.nextLine();
        System.out.println("Ementa: ");
        curso.ementa = scanner.nextLine();
    }
    public static void cadastroCampus() {
        Campus campus = new Campus();
        System.out.println("Nome do Campus: ");
        campus.nome = scanner.nextLine();
        System.out.println("Cidade: ");
        campus.cidade = scanner.nextLine();
        System.out.println("Estado: ");
        campus.estado = scanner.nextLine();
    }
    public static void cadastroAluno(){
        Aluno aluno = new Aluno();
        System.out.println("Nome do aluno: ");
        aluno.nome = scanner.nextLine();
        System.out.println("Data de nascimento: ");
        String nasc = scanner.nextLine();
        DateTimeFormatter ns = DateTimeFormatter.ofPattern("dd/mm/yyyy");
        aluno.dataNascimento = LocalDate.parse(nasc,ns);
    }

    public static void exibirMenu() {
        System.out.println("**********");
        System.out.println("Digite 1 para cadastro de turma");
        System.out.println("Digite 2 para cadastro de campus");
        System.out.println("Digite 3 para cadastro de curso");
        System.out.println("Digite 4 para cadastro de estudante");
        System.out.println("Digite 5 para cadastro de matricula");
        System.out.println("Digite 6 para exibir tudo:");
        System.out.println("Digite 0 para sair");
        System.out.println("**********");

    }
}
