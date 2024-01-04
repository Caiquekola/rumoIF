/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package rumoif.model.bean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public interface ConnectionDataBase {
    //CRIADO PARA A NECESSIDADE DE CONEXÃO COM DIFERENTES BANCOS DE DADOS
    public abstract Connection getConnection();
    public abstract void closeConnection(Connection con);
    public abstract void closeConnection(Connection con,PreparedStatement stmt);
    public abstract void closeConnection(Connection con,PreparedStatement stmt, ResultSet rs);
}
