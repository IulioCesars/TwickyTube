package Helpers;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSource;

public class Pool {
    
    public static DataSource dataSource;
    
    public static  String db = "twickytube";
    public static  String host = "localhost";
    public static  String url = "jdbc:mysql://"+ host +"/"+db;
    public static  String user = "root";
    public static  String pass = "J1565970";
    
    
    public static void IniciarPool(){
        if(dataSource != null){ return; }
        BasicDataSource basicDataSource = new BasicDataSource();
        
        basicDataSource.setDriverClassName("org.gjt.mm.mysql.Driver");
        basicDataSource.setUsername(user);
        basicDataSource.setPassword(pass);
        basicDataSource.setUrl(url);
        basicDataSource.setMaxActive(50);
        
        dataSource = basicDataSource;
    }
    /*
        Retorna una lista de diccionarios segun el query
        Diccionario = Objeto con un ElementoDiccionario
        ElementoDiccionario = Alias de una HashTable<String,Object>
    */
    public static List<Diccionario> EjecutarQuery(String query){
        IniciarPool();
        List<Diccionario> result = new ArrayList<Diccionario>();
        java.sql.Connection cn = null;
        try {
            cn= dataSource.getConnection();
            if(cn!=null){
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(query);
                ResultSetMetaData rsmd = rs.getMetaData();
                
                while(rs.next()){
                    Diccionario d = new Diccionario();
                    for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                        d.elementos.put(rsmd.getColumnName(i), rs.getObject(i));
                    }
                    result.add(d);
                }
            }

        } catch (SQLException e) {
            System.out.println(e);
            result = null;
        }finally{
                try {
                    cn.close();
                } catch (SQLException ex) {
                    System.out.println(ex);
                    result = null;
                }
        }
        return result;
    }
    
    public static Object EjecutarQuerySimple(String query){
        IniciarPool();
        Object result = null;
        java.sql.Connection cn = null;
        try {
            cn= dataSource.getConnection();
            if(cn!=null){
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(query);
                ResultSetMetaData rsmd = rs.getMetaData();
                rs.next();
                result = rs.getObject(0);
            }
        } catch (SQLException e) {
            System.out.println(e);
            result = null;
        }finally{
                try {
                    cn.close();
                } catch (SQLException ex) {
                    System.out.println(ex);
                    result = null;
                }
        }
        return result;
    }
    
    public static Object EjecutarStoredProcedureSimple(String stored, Object[] args){
        IniciarPool();
        Object result = null;
        java.sql.Connection cn = null;
        String params = "";
        for (int i = 0; i < args.length; i++) {
            if(args.length == 1) { params += "(?)"; continue;}
            if(i==0) {params += "(?"; continue;}
            params += ", ?";
            if(i== args.length - 1){ params += ")"; continue; }
        }
        try {
            cn= dataSource.getConnection();
            if(cn!=null){
                CallableStatement proc = null;
                proc = cn.prepareCall("{ call " + db + "." + stored + params +" }"); 
                
                for (int i=0; i<args.length; i++) {
                    proc.setObject(i+1, args[i]);
                    
                }
                
                ResultSet rs = proc.executeQuery();
                ResultSetMetaData rsmd = rs.getMetaData();
                
                return "OK";
                //rs.next();
                //result = rs.getObject(0);
            }

        } catch (SQLException e) {
            System.out.println(e);
            result = null;
        }finally{
                try {
                    cn.close();
                } catch (SQLException ex) {
                    System.out.println(ex);
                    result = null;
                }
        }
        return result;
    }
    
    public static List<Diccionario> EjecutarStoredProcedure(String query){
        return EjecutarStoredProcedure(query, null);
    }
    public static List<Diccionario> EjecutarStoredProcedure(String stored, Object[] args){
        IniciarPool();
        List<Diccionario> result = new ArrayList<Diccionario>();
        java.sql.Connection cn = null;
        String params = "";
        for (int i = 0; i < args.length; i++) {
            if(args.length == 1) { params += "(?)"; continue;}
            if(i==0) {params += "(?"; continue;}
            params += ", ?";
            if(i== args.length - 1){ params += ")"; continue; }
        }
        try {
            cn= dataSource.getConnection();
            if(cn!=null){
                CallableStatement proc = null;
                proc = cn.prepareCall("{ call " + db + "." + stored + params +" }"); 
                
                for (int i=0; i<args.length; i++) {
                    proc.setObject(i+1, args[i]);
                    
                }
                
                ResultSet rs = proc.executeQuery();
                ResultSetMetaData rsmd = rs.getMetaData();
                
                while(rs.next()){
                    Diccionario d = new Diccionario();
                    for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                        Object parametro = rs.getObject(i) == null ? "NULL" : rs.getObject(i);
                        d.elementos.put(rsmd.getColumnName(i), parametro);
                    }
                    result.add(d);
                }
            }

        } catch (SQLException e) {
            System.out.println(e);
            result = null;
        }finally{
                try {
                    cn.close();
                } catch (SQLException ex) {
                    System.out.println(ex);
                    result = null;
                }
        }
        return result;
    }
    
}
