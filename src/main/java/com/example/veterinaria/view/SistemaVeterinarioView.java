package com.example.veterinaria.view;


import com.example.veterinaria.controller.*;
import com.example.veterinaria.model.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class SistemaVeterinarioView {
    private DonoController donoController;
    private AnimalController animalController;
    private FuncionarioController funcionarioController;
    private ConsultaController consultaController;
    private ServicoController servicoController;
    @SuppressWarnings("unused")
    private Date novaDataConsulta;
    @SuppressWarnings("unused")
    private Date novaHoraConsulta;

    public SistemaVeterinarioView(DonoController donoController, AnimalController animalController, 
                                  FuncionarioController funcionarioController, ConsultaController consultaController, 
                                  ServicoController servicoController) {
        this.donoController = donoController;
        this.animalController = animalController;
        this.funcionarioController = funcionarioController;
        this.consultaController = consultaController;
        this.servicoController = servicoController;
    }

    public void iniciar() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Gerenciar Donos");
            System.out.println("2. Gerenciar Animais");
            System.out.println("3. Gerenciar Funcionários");
            System.out.println("4. Gerenciar Consultas");
            System.out.println("5. Gerenciar Serviços");
            System.out.println("0. Sair");
            int opcao = scanner.nextInt();
            scanner.nextLine();  // Consuma a nova linha
    
            try {
                switch (opcao) {
                    case 1:
                        gerenciarDonos(scanner);
                        break;
                    case 2:
                        gerenciarAnimais(scanner);
                        break;
                    case 3:
                        gerenciarFuncionarios(scanner);
                        break;
                    case 4:
                        gerenciarConsultas(scanner);
                        break;
                    case 5:
                        gerenciarServicos(scanner);
                        break;
                    case 0:
                        return;
                    default:
                        System.out.println("Opção inválida");
                }
            } catch (SQLException | ParseException e) {
                e.printStackTrace();
            }
        }
    }
    

    private void gerenciarDonos(Scanner scanner) throws SQLException {
        System.out.println("1. Adicionar Dono");
        System.out.println("2. Listar Donos");
        System.out.println("3. Atualizar Dono");
        System.out.println("4. Excluir Dono");
        int opcao = scanner.nextInt();
        scanner.nextLine();  // Consuma a nova linha

        switch (opcao) {
            case 1:
                System.out.println("Nome: ");
                String nome = scanner.nextLine();
                System.out.println("Endereço: ");
                String endereco = scanner.nextLine();
                System.out.println("Telefone: ");
                String telefone = scanner.nextLine();
                Dono dono = new Dono();
                dono.setNome(nome);
                dono.setEndereco(endereco);
                dono.setTelefone(telefone);
                donoController.adicionarDono(dono);
                break;
            case 2:
                List<Dono> donos = donoController.listarDonos();
                for (Dono d : donos) {
                    System.out.println(d);
                }
                break;
            case 3:
                System.out.println("ID do Dono: ");
                int id = scanner.nextInt();
                scanner.nextLine();  // Consuma a nova linha
                System.out.println("Nome: ");
                nome = scanner.nextLine();
                System.out.println("Endereço: ");
                endereco = scanner.nextLine();
                System.out.println("Telefone: ");
                telefone = scanner.nextLine();
                dono = new Dono();
                dono.setId(id);
                dono.setNome(nome);
                dono.setEndereco(endereco);
                dono.setTelefone(telefone);
                donoController.atualizarDono(dono);
                break;
            case 4:
                System.out.println("ID do Dono: ");
                id = scanner.nextInt();
                scanner.nextLine();  // Consuma a nova linha
                donoController.excluirDono(id);
                break;
            default:
                System.out.println("Opção inválida");
        }
    }

    private void gerenciarAnimais(Scanner scanner) throws SQLException {
        System.out.println("1. Adicionar Animal");
        System.out.println("2. Listar Animais");
        System.out.println("3. Atualizar Animal");
        System.out.println("4. Excluir Animal");
        int opcao = scanner.nextInt();
        scanner.nextLine();  // Consuma a nova linha

        switch (opcao) {
            case 1:
                System.out.println("Nome: ");
                String nome = scanner.nextLine();
                System.out.println("Espécie do Animal: ");
                String especie = scanner.nextLine();
                System.out.println("Raça: ");
                String raca = scanner.nextLine();
                System.out.println("Idade: ");
                int idade = scanner.nextInt();
                scanner.nextLine();  // Consuma a nova linha
                System.out.println("ID do Dono: ");
                int donoId = scanner.nextInt();
                scanner.nextLine();  // Consuma a nova linha
                Animal animal = new Animal();
                animal.setNome(nome);
                animal.setEspecie(especie);
                animal.setRaca(raca);
                animal.setIdade(idade);
                animal.setDonoId(donoId);
                animalController.adicionarAnimal(animal);
                break;
            case 2:
                List<Animal> animais = animalController.listarAnimais();
                for (Animal a : animais) {
                    System.out.println(a);
                }
                break;
            case 3:
                System.out.println("ID do Animal: ");
                int id = scanner.nextInt();
                scanner.nextLine();  // Consuma a nova linha
                System.out.println("Novo Nome: ");
                nome = scanner.nextLine();
                System.out.println("Espécie do Animal: ");
                especie = scanner.nextLine();
                System.out.println("Nova Raça: ");
                raca = scanner.nextLine();
                System.out.println("Nova Idade: ");
                idade = scanner.nextInt();
                scanner.nextLine();  // Consuma a nova linha
                System.out.println("Novo ID do Dono: ");
                donoId = scanner.nextInt();
                scanner.nextLine();  // Consuma a nova linha
                animal = new Animal();
                animal.setId(id);
                animal.setNome(nome);
                animal.setEspecie(especie);
                animal.setRaca(raca);
                animal.setIdade(idade);
                animal.setDonoId(donoId);
                animalController.atualizarAnimal(animal);
                break;
            case 4:
                System.out.println("ID do Animal: ");
                id = scanner.nextInt();
                scanner.nextLine();  // Consuma a nova linha
                animalController.excluirAnimal(id);
                break;
            default:
                System.out.println("Opção inválida");
        }
    }

    private void gerenciarFuncionarios(Scanner scanner) throws SQLException {
        System.out.println("1. Adicionar Funcionário");
        System.out.println("2. Listar Funcionários");
        System.out.println("3. Atualizar Funcionário");
        System.out.println("4. Excluir Funcionário");
        int opcao = scanner.nextInt();
        scanner.nextLine();  // Consuma a nova linha

        switch (opcao) {
            case 1:
                System.out.println("Nome: ");
                String nome = scanner.nextLine();
                System.out.println("Email: ");
                String email = scanner.nextLine();
                System.out.println("Telefone: ");
                String telefone = scanner.nextLine();
                Funcionario funcionario = new Funcionario();
                funcionario.setNome(nome);
                funcionario.setEmail(email);
                funcionario.setTelefone(telefone);
                funcionarioController.adicionarFuncionario(funcionario);
                break;
            case 2:
                List<Funcionario> funcionarios = funcionarioController.listarFuncionarios();
                for (Funcionario f : funcionarios) {
                    System.out.println(f);
                }
                break;
            case 3:
                System.out.println("ID do Funcionário: ");
                int id = scanner.nextInt();
                scanner.nextLine();  // Consuma a nova linha
                System.out.println("Novo Nome: ");
                nome = scanner.nextLine();
                System.out.println("Novo Email: ");
                email = scanner.nextLine();
                System.out.println("Novo Telefone: ");
                telefone = scanner.nextLine();
                funcionario = new Funcionario();
                funcionario.setId(id);
                funcionario.setNome(nome);
                funcionario.setEmail(email);
                funcionario.setTelefone(telefone);
                funcionarioController.atualizarFuncionario(funcionario);
                break;
            case 4:
                System.out.println("ID do Funcionário: ");
                id = scanner.nextInt();
                scanner.nextLine();  // Consuma a nova linha
                funcionarioController.excluirFuncionario(id);
                break;
            default:
                System.out.println("Opção inválida");
        }
    }

    private void gerenciarConsultas(Scanner scanner) throws SQLException, ParseException {
        System.out.println("1. Adicionar Consulta");
        System.out.println("2. Listar Consultas");
        System.out.println("3. Atualizar Consulta");
        System.out.println("4. Excluir Consulta");
        int opcao = scanner.nextInt();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        scanner.nextLine();  // Consuma a nova linha
    
        switch (opcao) {
            case 1:
                System.out.println("Data da Consulta (YYYY-MM-DD): ");
                String dataConsultaStr = scanner.nextLine();
                System.out.println("Hora da Consulta (HH:MM:SS): ");
                String horaConsultaStr = scanner.nextLine();
                System.out.println("ID do Animal: ");
                int animalId = scanner.nextInt();
                scanner.nextLine();  // Consuma a nova linha
                System.out.println("ID do Funcionário: ");
                int funcionarioId = scanner.nextInt();
                scanner.nextLine();  // Consuma a nova linha
                
                // Converte as strings de data e hora para objetos Date
                Date dataConsulta = dateFormat.parse(dataConsultaStr);
                Date horaConsulta = timeFormat.parse(horaConsultaStr);
                
                Consulta consulta = new Consulta();
                consulta.setDataConsulta(dataConsulta);
                consulta.setHoraConsulta(horaConsulta);
                consulta.setAnimalId(animalId);
                consulta.setFuncionarioId(funcionarioId);
                consultaController.adicionarConsulta(consulta);
                break;
            case 2:
                List<Consulta> consultas = consultaController.listarConsultas();
                for (Consulta c : consultas) {
                    System.out.println(c);
                }
                break;
            case 3:
                // Atualizar consulta
                System.out.println("ID da Consulta: ");
                int id = scanner.nextInt();
                scanner.nextLine();  // Consuma a nova linha
                System.out.println("Nova Data da Consulta (YYYY-MM-DD): ");
                String novaDataConsultaStr = scanner.nextLine();
                System.out.println("Nova Hora da Consulta (HH:MM:SS): ");
                String novaHoraConsultaStr = scanner.nextLine();
                System.out.println("Novo ID do Animal: ");
                int novoAnimalId = scanner.nextInt();
                scanner.nextLine();  // Consuma a nova linha
                System.out.println("Novo ID do Funcionário: ");
                int novoFuncionarioId = scanner.nextInt();
                scanner.nextLine();  // Consuma a nova linha
    
                // Converte as strings de data e hora em objetos Date
                Date novaDataConsulta = dateFormat.parse(novaDataConsultaStr);
                Date novaHoraConsulta = timeFormat.parse(novaHoraConsultaStr);
    
                // Crie uma nova consulta com os valores atualizados
                Consulta consultaAtualizada = new Consulta();
                consultaAtualizada.setId(id);
                consultaAtualizada.setDataConsulta(novaDataConsulta);
                consultaAtualizada.setHoraConsulta(novaHoraConsulta);
                consultaAtualizada.setAnimalId(novoAnimalId);
                consultaAtualizada.setFuncionarioId(novoFuncionarioId);
    
                // Atualize a consulta utilizando o método adequado da controller
                consultaController.atualizarConsulta(consultaAtualizada);
                break;
            case 4:
                System.out.println("ID da Consulta: ");
                id = scanner.nextInt();
                scanner.nextLine();  // Consuma a nova linha
                consultaController.excluirConsulta(id);
                break;
            default:
                System.out.println("Opção inválida");
        }
    }
    
    @SuppressWarnings("null")
    private void gerenciarServicos(Scanner scanner) throws SQLException {
        System.out.println("1. Adicionar Serviço");
        System.out.println("2. Listar Serviços");
        System.out.println("3. Atualizar Serviço");
        System.out.println("4. Excluir Serviço");
        int opcao = scanner.nextInt();
        scanner.nextLine();  // Consuma a nova linha

        switch (opcao) {
            case 1:
                System.out.println("Nome do Serviço: ");
                String nome = scanner.nextLine();
                System.out.println("Preço do Serviço: ");
                double preco = scanner.nextDouble();
                scanner.nextLine();  // Consuma a nova linha
                System.out.println("ID do Animal (ou deixe vazio se não aplicável): ");
                String input = scanner.nextLine();
                Integer animalId = input.isEmpty() ? null : Integer.parseInt(input);
                // Verifica se animalId é nulo antes de chamar o método intValue()
                int animalIdValue = (animalId != null) ? animalId.intValue() : 0;
                Servico servico = new Servico();
                servico.setNome(nome);
                servico.setPreco(BigDecimal.valueOf(preco));//mensagem de erro:The method setPreco(BigDecimal) in the type Servico is not applicable for the arguments (double)Java(67108979)void com.example.veterinaria.model.Servico.setPreco(BigDecimal preco)
                servico.setAnimalId(animalIdValue);//mensagem de erro:The method setIdAnimal(Integer) is undefined for the type ServicoJava(67108964)
                servicoController.adicionarServico(servico);
                break;
            case 2:
                List<Servico> servicos = servicoController.listarServicos();
                for (Servico s : servicos) {
                    System.out.println(s);
                }
                break;
            case 3:
                System.out.println("ID do Serviço: ");
                int id = scanner.nextInt();
                scanner.nextLine();  // Consuma a nova linha
                System.out.println("Novo Nome do Serviço: ");
                nome = scanner.nextLine();
                System.out.println("Novo Preço do Serviço: ");
                preco = scanner.nextDouble();
                scanner.nextLine();  // Consuma a nova linha
                System.out.println("Novo ID do Animal (ou deixe vazio se não aplicável): ");
                input = scanner.nextLine();
                animalId = input.isEmpty() ? null : Integer.parseInt(input);
                // Verifica se animalId é nulo antes de chamar o método intValue()
                animalIdValue = (animalId != null) ? animalId.intValue() : 0;
                servico = new Servico();
                servico.setId(id);
                servico.setNome(nome);
                servico.setPreco(BigDecimal.valueOf(preco));
                servico.setAnimalId(animalIdValue);
                servicoController.atualizarServico(servico);
                break;
            case 4:
                System.out.println("ID do Serviço: ");
                id = scanner.nextInt();
                scanner.nextLine();  // Consuma a nova linha
                servicoController.excluirServico(id);
                break;
            default:
                System.out.println("Opção inválida");
        }
    }
}

