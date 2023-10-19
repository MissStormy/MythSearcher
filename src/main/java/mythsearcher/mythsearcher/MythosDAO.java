package mythsearcher.mythsearcher;

import javafx.collections.ObservableList;
import mythsearcher.mythsearcher.domain.Mytho;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class MythosDAO {
    private Connection conexion;

    public void conectar() throws ClassNotFoundException, SQLException, IOException {
        Properties properties= new Properties();
        String host="";
        String port="";
        String name="";
        String username="";
        String password="";

        try {
            System.out.println("Cok");
            properties.load(new FileInputStream(new File("src/main/resources/configurations/database.properties")));

            //System.out.println(properties.get("driver"));
            host=String.valueOf(properties.get("host"));
            port=String.valueOf(properties.get("port"));
            name=String.valueOf(properties.get("name"));
            username=String.valueOf(properties.get("username"));
            password=String.valueOf(properties.get("password"));
            System.out.println(host+"  "+port+"  "+name+"  "+username+"  "+password);
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + name + "?serverTimezone=UTC",
                    username, password);
            if (conexion!=null)
                System.out.println("Conexion ok");
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }

    public void desconectar() throws SQLException {
        conexion.close();
    }

    public void guardarMytho(Mytho mytho) throws SQLException {
        String sql = "INSERT INTO mythos (nombre, tipo, genero, origen) VALUES (?, ?, ?, ?)";

        //Esto evita los ataques de inyeccion SQL
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setString(1, mytho.getNombre());
        sentencia.setString(2, mytho.getTipo());
        sentencia.setString(3, mytho.getGenero());
        sentencia.setString(4, mytho.getOrigen());
        sentencia.executeUpdate();
    }

    public void eliminarMytho(Mytho mytho) throws SQLException {
        String sql = "DELETE FROM mythos WHERE nombre = ?";

        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setString(1, mytho.getNombre());
        sentencia.executeUpdate();
    }

    public void modificarMytho(Mytho mythoAnt, Mytho mythoNew) throws SQLException {
        String sql = "UPDATE mythos SET nombre = ?, tipo = ?, genero = ?, origen = ? WHERE id = ?";

        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setString(1, mythoNew.getNombre());
        sentencia.setString(2, mythoNew.getTipo());
        sentencia.setString(3, mythoNew.getOrigen());
        sentencia.setString(4, mythoNew.getGenero());
        sentencia.setInt(5, mythoAnt.getId());
        sentencia.executeUpdate();
    }

    public List<Mytho> obtenerMythos() throws SQLException {
        List<Mytho> mythos = new ArrayList<>();
        String sql = "SELECT * FROM mythos";
        PreparedStatement sentencia = conexion.prepareStatement(sql);

        ResultSet resultado = sentencia.executeQuery();

        while (resultado.next()) {

            Mytho mytho = new Mytho();
            mytho.setId(resultado.getInt(1));
            mytho.setNombre(resultado.getString(2));
            mytho.setTipo(resultado.getString(3));
            mytho.setGenero(resultado.getString(4));
            mytho.setOrigen(resultado.getString(5));
            mytho.setBio(resultado.getString(6));

            mythos.add(mytho);

        }
        System.out.println(mythos);
        return mythos;
    }

    public boolean existeMytho(String nombre) throws SQLException {
        String sql = "SELECT * FROM mythos WHERE nombre = ?";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        ResultSet resultado = sentencia.executeQuery();

        return resultado.next();
    }

}
