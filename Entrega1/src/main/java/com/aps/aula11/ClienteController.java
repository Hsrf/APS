package com.aps.aula11;
import java.sql.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class ClienteController {

    @GetMapping("/homepage")

    private static void connect() {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:/home/vitor/Documentos/APS/Projeto/Spring/src/main/resources/banco.db")) {
            System.out.println("Conexão realizada !!!!");
            Statement statement = connection.createStatement();

            // criando uma tabela
            statement.execute("CREATE TABLE IF NOT EXISTS USER( EMAIL VARCHAR NOT NULL UNIQUE, SENHA NOT NULL UNIQUE )");

            // inserindo registros
            // statement.execute("INSERT INTO USER( EMAIL, SENHA ) VALUES ('VITOR', '123456'), ('CARLOS', '987654')");

            // lendo os registros
            PreparedStatement stmt = connection.prepareStatement("select * from USER");
            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                // Integer id = resultSet.getInt("EMAIL");
                String nome = resultSet.getString("EMAIL");

                System.out.println("User identificado: " + nome);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public String getCliente(Model model) {
        connect();
        return "homepage";
    }

}