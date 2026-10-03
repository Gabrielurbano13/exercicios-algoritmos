import java.util.Scanner;

public class AtividadeAlgoritmos {
    public static void main(String[] args) {
        algoritmo1();
    }

    // 1) calculadora com opção de repetir ou sair
    private static void algoritmo1() {
        System.out.println("Algoritmo 1");
        Scanner teclado = new Scanner(System.in);
        int opcao = 1;

        while (opcao != 0) {
            System.out.print("digite o primeiro numero inteiro: ");
            int num1 = teclado.nextInt();
            System.out.print("digite o segundo numero inteiro: ");
            int num2 = teclado.nextInt();

            System.out.println("escolha a operacao:");
            System.out.println("1 - Soma");
            System.out.println("2 - Subtracao");
            System.out.println("3 - Multiplicacao");
            System.out.println("4 - Quociente inteiro");
            int operacao = teclado.nextInt();

            if (operacao == 1) {
                System.out.println("Resultado: " + (num1 + num2));
            } else if (operacao == 2) {
                System.out.println("Resultado: " + (num1 - num2));
            } else if (operacao == 3) {
                System.out.println("Resultado: " + (num1 * num2));
            } else if (operacao == 4) {
                if (num2 != 0) {
                    System.out.println("Resultado: " + (num1 / num2));
                } else {
                    System.out.println("Erro: nao da pra dividir por zero!");
                }
            } else {
                System.out.println("Operacao invalida!");
            }

            System.out.print("Deseja continuar? (1 para Sim, 0 para Encerrar): ");
            opcao = teclado.nextInt();
        }
        System.out.println();
    }

    // 2) Soma de ímpares múltiplos de 3 entre 1 e 500
    private static void algoritmo2() {
        System.out.println("Algoritmo 2");
        int soma = 0;

        for (int i = 1; i <= 500; i++) {
            if (i % 2 != 0 && i % 3 == 0) {
                soma += i;
            }
        }
        System.out.println("A soma dos impares multiplos de 3 entre 1 e 500 eh: " + soma);
        System.out.println();
    }

    // 3) Empregado mais recente e mais antigo (limite 300, para com 0 e 0)
    private static void algoritmo3() {
        System.out.println("Algoritmo 3");
        Scanner teclado = new Scanner(System.in);

        int idMaisAntigo = 0;
        int mesesMaisAntigo = -1; // Começa baixo para qualquer um ser maior

        int idMaisRecente = 0;
        int mesesMaisRecente = 99999; // Começa alto para qualquer um ser menor

        int contador = 0;

        while (contador < 300) {
            System.out.print("digite o numero do empregado (ou 0 para parar): ");
            int id = teclado.nextInt();
            System.out.print("digite os meses de trabalho (ou 0 para parar): ");
            int meses = teclado.nextInt();

            if (id == 0 && meses == 0) {
                break;
            }

            // Na primeira repetição, define os valores iniciais
            if (contador == 0) {
                idMaisAntigo = id;
                mesesMaisAntigo = meses;
                idMaisRecente = id;
                mesesMaisRecente = meses;
            } else {
                if (meses > mesesMaisAntigo) {
                    mesesMaisAntigo = meses;
                    idMaisAntigo = id;
                }
                if (meses < mesesMaisRecente) {
                    mesesMaisRecente = meses;
                    idMaisRecente = id;
                }
            }
            contador++;
        }

        if (contador > 0) {
            System.out.println("Mais antigo: Empregado " + idMaisAntigo + " com " + mesesMaisAntigo + " meses.");
            System.out.println("Mais recente: Empregado " + idMaisRecente + " com " + mesesMaisRecente + " meses.");
        } else {
            System.out.println("Nenhum dado digitado.");
        }
        System.out.println();
    }

    // 4) Altura e sexo de 15 pessoas
    private static void algoritmo4() {
        System.out.println("Algoritmo 4");
        Scanner teclado = new Scanner(System.in);

        double menorAltura = 9.0;
        double somaAlturaMulheres = 0;
        int totalMulheres = 0;
        int totalHomens = 0;

        double maiorAltura = 0;
        char sexoMaisAlto = ' ';

        for (int i = 1; i <= 15; i++) {
            System.out.print("Digite a altura da pessoa " + i + ": ");
            double altura = teclado.nextDouble();
            System.out.print("digite o sexo (M/F) da pessoa " + i + ": ");
            char sexo = teclado.next().toUpperCase().charAt(0);

            if (altura < menorAltura) {
                menorAltura = altura;
            }

            if (altura > maiorAltura) {
                maiorAltura = altura;
                sexoMaisAlto = sexo;
            }

            if (sexo == 'F') {
                somaAlturaMulheres += altura;
                totalMulheres++;
            } else if (sexo == 'M') {
                totalHomens++;
            }
        }

        System.out.println("a. Menor altura do grupo: " + menorAltura);
        if (totalMulheres > 0) {
            System.out.println("b. Media de altura das mulheres: " + (somaAlturaMulheres / totalMulheres));
        } else {
            System.out.println("b. Nao foram registradas mulheres.");
        }
        System.out.println("c. Numero de homens: " + totalHomens);
        System.out.println("d. Sexo da pessoa mais alta: " + sexoMaisAlto);
        System.out.println();
    }

    // 5) Pesquisa da prefeitura (para com salário negativo)
    private static void algoritmo5() {
        System.out.println("Algoritmo 5");
        Scanner teclado = new Scanner(System.in);

        double somaSalarios = 0;
        int somaFilhos = 0;
        double maiorSalario = 0;
        int pessoasAte250 = 0;
        int totalPessoas = 0;

        while (true) {
            System.out.print("Digite o salario (ou valor negativo para sair): ");
            double salario = teclado.nextDouble();

            if (salario < 0) {
                break;
            }

            System.out.print("Digite o numero de filhos: ");
            int filhos = teclado.nextInt();

            totalPessoas++;
            somaSalarios += salario;
            somaFilhos += filhos;

            if (salario > maiorSalario) {
                maiorSalario = salario;
            }

            if (salario <= 250.0) {
                pessoasAte250++;
            }
        }

        if (totalPessoas > 0) {
            double percentual = ((double) pessoasAte250 / totalPessoas) * 100;
            System.out.println("a) Media do salario da populacao: " + (somaSalarios / totalPessoas));
            System.out.println("b) Media do numero de filhos: " + ((double) somaFilhos / totalPessoas));
            System.out.println("c) Maior salario: " + maiorSalario);
            System.out.println("d) Percentual de pessoas com salario ate R$250,00: " + percentual + "%");
        } else {
            System.out.println("Nenhum dado cadastrado.");
        }
        System.out.println();
    }

    // 6) Valores indetermindados: médias e percentuais de positivos/negativos
    private static void algoritmo6() {
        System.out.println("Algoritmo 6");
        Scanner teclado = new Scanner(System.in);

        double somaValores = 0;
        int qtdePositivos = 0;
        int qtdeNegativos = 0;
        int totalValores = 0;

        System.out.print("Deseja digitar um valor? (1-Sim / 0-Nao): ");
        int continuar = teclado.nextInt();

        while (continuar == 1) {
            System.out.print("Digite o valor: ");
            double valor = teclado.nextDouble();

            somaValores += valor;
            totalValores++;

            if (valor > 0) {
                qtdePositivos++;
            } else if (valor < 0) {
                qtdeNegativos++;
            }

            System.out.print("Deseja digitar outro valor? (1-Sim / 0-Nao): ");
            continuar = teclado.nextInt();
        }

        if (totalValores > 0) {
            double media = somaValores / totalValores;
            double pctPositivos = ((double) qtdePositivos / totalValores) * 100;
            double pctNegativos = ((double) qtdeNegativos / totalValores) * 100;

            System.out.println("Media aritmetica dos valores: " + media);
            System.out.println("Quantidade de valores positivos: " + qtdePositivos);
            System.out.println("Quantidade de valores negativos: " + qtdeNegativos);
            System.out.println("Percentual de valores positivos: " + pctPositivos + "%");
            System.out.println("Percentual de valores negativos: " + pctNegativos + "%");
        } else {
            System.out.println("Nenhum valor inserido.");
        }
        System.out.println();
    }
    // 7) Média de 75 valores inteiros e positivos
    private static void algoritmo7() {
        System.out.println("--- Algoritmo 7 ---");
        Scanner teclado = new Scanner(System.in);

        int soma = 0;
        int totalLidos = 75;

        for (int i = 1; i <= totalLidos; i++) {
            System.out.print("Digite o valor " + i + " (inteiro e positivo): ");
            int valor = teclado.nextInt();
            soma += valor;
        }

        double media = (double) soma / totalLidos;
        System.out.println("Media dos valores: " + media);
        System.out.println("Quantidade de numeros lidos: " + totalLidos);
        System.out.println();
    }

    // 8) Cadastro de 15 amigos (Nome, altura, sexo [1 ou 2])
    private static void algoritmo8() {
        System.out.println("Algoritmo 8");
        Scanner teclado = new Scanner(System.in);

        String nomeMaior = "", nomeMenor = "";
        double maiorAltura = 0, menorAltura = 9.0;

        double somaMasc = 0, somaFem = 0, somaTurma = 0;
        int qtdMasc = 0, qtdFem = 0;

        for (int i = 1; i <= 15; i++) {
            System.out.print("Nome do amigo " + i + ": ");
            String nome = teclado.next();
            System.out.print("Altura do amigo " + i + ": ");
            double altura = teclado.nextDouble();
            System.out.print("Sexo (1-Masc / 2-Fem) do amigo " + i + ": ");
            int sexo = teclado.nextInt();

            somaTurma += altura;

            if (altura > maiorAltura) {
                maiorAltura = altura;
                nomeMaior = nome;
            }
            if (altura < menorAltura) {
                menorAltura = altura;
                nomeMenor = nome;
            }

            if (sexo == 1) {
                somaMasc += altura;
                qtdMasc++;
            } else if (sexo == 2) {
                somaFem += altura;
                qtdFem++;
            }
        }

        System.out.println("Maior altura: " + maiorAltura + " (Nome: " + nomeMaior + ")");
        System.out.println("Menor altura: " + menorAltura + " (Nome: " + nomeMenor + ")");

        if (qtdFem > 0) {
            System.out.println("Media de altura das mulheres: " + (somaFem / qtdFem));
        } else {
            System.out.println("Nao ha mulheres na turma.");
        }

        if (qtdMasc > 0) {
            System.out.println("Media de altura os homens: " + (somaMasc / qtdMasc));
        } else {
            System.out.println("Nao ha homens na turma.");
        }

        System.out.println("Media de altura da turma: " + (somaTurma / 15));
        System.out.println();
    }

    // 9) Notas de uma turma de n alunos (Escala de 0 a 15)
    private static void algoritmo9() {
        System.out.println("Algoritmo 9");
        Scanner teclado = new Scanner(System.in);

        System.out.print("Digite o numero de alunos (n): ");
        int n = teclado.nextInt();

        double maiorNota = -1;
        double menorNota = 16;

        for (int i = 1; i <= n; i++) {
            System.out.print("Digite a nota do aluno " + i + " (0 a 15): ");
            double nota = teclado.nextDouble();

            if (nota > maiorNota) {
                maiorNota = nota;
            }
            if (nota < menorNota) {
                menorNota = nota;
            }
        }

        if (n > 0) {
            System.out.println("Maior nota da turma: " + maiorNota);
            System.out.println("Menor nota da turma: " + menorNota);
        } else {
            System.out.println("Turma sem alunos registrados.");
        }
        System.out.println();
    }

    // 10) Tabela de polegadas para centímetros (1 a 20)
    private static void algoritmo10() {
        System.out.println("Algoritmo 10");
        System.out.println("polegadas | centimetros");
        System.out.println("----...");

        for (int polegada = 1; polegada <= 20; polegada++) {
            double centimetros = polegada / 2.54;
            System.out.printf("%9d | %12.2f\n", polegada, centimetros);
        }
        System.out.println();
    }

    // 11) Soma de pares em um intervalo (limites positivos)
    private static void algoritmo11() {
        System.out.println("Algoritmo 11");
        Scanner teclado = new Scanner(System.in);

        System.out.print("Digite o limite inferior: ");
        int inferior = teclado.nextInt();
        System.out.print("Digite o limite superior: ");
        int superior = teclado.nextInt();

        int somaPares = 0;

        for (int i = inferior; i <= superior; i++) {
            if (i % 2 == 0) {
                somaPares += i;
            }
        }

        System.out.println("A soma dos numeros pares no intervalo eh: " + somaPares);
        System.out.println();
    }

    // 12) dduas maiores notas de 100 alunos e suas matrículas
    private static void algoritmo12() {
        System.out.println("Algoritmo 12");
        Scanner teclado = new Scanner(System.in);

        int matPrimeira = 0;
        double notaPrimeira = -1;

        int matSegunda = 0;
        double notaSegunda = -1;

        for (int i = 1; i <= 100; i++) {
            System.out.print("Matricula do aluno " + i + ": ");
            int matricula = teclado.nextInt();
            System.out.print("Nota do aluno " + i + ": ");
            double nota = teclado.nextDouble();

            if (nota > notaPrimeira) {
                notaSegunda = notaPrimeira;
                matSegunda = matPrimeira;

                notaPrimeira = nota;
                matPrimeira = matricula;
            } else if (nota > notaSegunda) {
                notaSegunda = nota;
                matSegunda = matricula;
            }
        }

        System.out.println("1a Maior Nota: " + notaPrimeira + " (Matricula: " + matPrimeira + ")");
        System.out.println("2a Maior Nota: " + notaSegunda + " (Matricula: " + matSegunda + ")");
        System.out.println();
    }
}
