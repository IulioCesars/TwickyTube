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
    
    public static class host_data
    {
        protected static final String host = "TWICKYTUBE";
        protected static final String local_esteban = "ESTEBAN";
        protected static final String local_julio = "JULIO";
        
        //PARA CAMBIAR LA CONEXION, SOLO HAY QUE CAMBIAR EL VALOR DE "WHAT_HOST_USE"
        protected static String WHAT_HOST_USE = local_esteban;
        
        protected static  String db_host = "DB_TWICKYTUBE";
        protected static  String host_host = "twicky.com.mx";
        protected static  String url_host = "jdbc:mysql://"+ host_host +"/"+db_host;
        protected static  String user_host = "twickytube";
        protected static  String pass_host = "twickytube"; //J1565970 
        
        protected static String db_local_e = "DB_TWICKYTUBE_RES_3";
        protected static String host_local_e = "localhost";
        protected static String url_local_e = "jdbc:mysql://"+ host_local_e +"/"+db_local_e;
        protected static String user_local_e = "root";
        protected static String pass_local_e = "root";
        
        protected static  String db_local_j = "twickytube";
        protected static  String host_local_j = "localhost";
        protected static  String url_local_j = "jdbc:mysql://"+ host_local_j +"/"+ db_local_j;
        protected static  String user_local_j = "root";
        protected static  String pass_local_j = "J1565970 "; //J1565970 
    }
    
    
    public static DataSource dataSource;
    
    public static  String db = "";
    public static  String host = "";
    public static  String url = "";
    public static  String user = "";
    public static  String pass = "";
    
    
    
    public static void IniciarPool(){
        switch(host_data.WHAT_HOST_USE)
        {
            case host_data.host:
                db = host_data.db_host;
                host = host_data.host_host;
                url = host_data.url_host;
                user = host_data.user_host;
                pass = host_data.pass_host;
            break;
            case host_data.local_esteban:
                db = host_data.db_local_e;
                host = host_data.host_local_e;
                url = host_data.url_local_e;
                user = host_data.user_local_e;
                pass = host_data.pass_local_e;
            break;
            case host_data.local_julio:
                db = host_data.db_local_j;
                host = host_data.host_local_j;
                url = host_data.url_local_j;
                user = host_data.user_local_j;
                pass = host_data.pass_local_j;
            break;
            default: break;
        }
        
        
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
