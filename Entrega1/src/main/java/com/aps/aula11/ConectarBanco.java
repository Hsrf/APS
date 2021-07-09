import java.sql.*;

public class ConectarBanco {

    private static void connect() {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:../../../../resources/banco.db")) {
            System.out.println("Conexão realizada !!!!");
            Statement statement = connection.createStatement();

            // criando uma tabela
            statement.execute("CREATE TABLE IF NOT EXISTS USER( EMAIL VARCHAR, SENHA VARCHAR )");

            // inserindo registros
            statement.execute("INSERT INTO USER( EMAIL, SENHA ) VALUES ('VITOR', '123456'), ('CARLOS', '987654')");

            // lendo os registros
            PreparedStatement stmt = connection.prepareStatement("select * from USER");
            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                Integer id = resultSet.getInt("ID");
                String nome = resultSet.getString("NOME");

                System.out.println( id + " - " + nome);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        connect();
    }
}