import com.example.veterinaria.controller.*;
import com.example.veterinaria.dao.*;
import com.example.veterinaria.util.ConfiguracaoBancoDados;
import com.example.veterinaria.view.SistemaVeterinarioView;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            // Conectando ao banco de dados
            connection = ConfiguracaoBancoDados.getConnection();

            // Inicializando DAOs
            DonoDAO donoDAO = new DonoDAO(connection);
            AnimalDAO animalDAO = new AnimalDAO(connection);
            FuncionarioDAO funcionarioDAO = new FuncionarioDAO(connection);
            ConsultaDAO consultaDAO = new ConsultaDAO(connection);
            ServicoDAO servicoDAO = new ServicoDAO(connection);

            // Inicializando Controllers
            DonoController donoController = new DonoController(donoDAO);
            AnimalController animalController = new AnimalController(animalDAO);
            FuncionarioController funcionarioController = new FuncionarioController(funcionarioDAO);
            ConsultaController consultaController = new ConsultaController(consultaDAO);
            ServicoController servicoController = new ServicoController(servicoDAO);

            // Inicializando View
            SistemaVeterinarioView sistemaVeterinarioView = new SistemaVeterinarioView(donoController, animalController, funcionarioController, consultaController, servicoController);

            // Iniciando o sistema
            sistemaVeterinarioView.iniciar();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                ConfiguracaoBancoDados.closeConnection(connection);
            }
        }
    }
}



