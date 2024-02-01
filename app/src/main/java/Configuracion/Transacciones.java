package Configuracion;

public class Transacciones
{
    public static final String DBName = "BD012024"; //creación de la base de datos
    public static final String TablePersonas = "personas"; //creación de las tablas

    public static final String id = "id";
    public static final String nombres = "nombres";
    public static final String apellidos = "apellidos";
    public static final String edad = "edad";
    public static final String correo = "correo";
    public static final String telefono = "telefono";

    //ddl create
    public static final String CreateTablePersonas = "CREATE TABLE "+ TablePersonas + "("+
            "id INTEGER PRIMARY KEY AUTOINCREMENT, nombres TEXT, apellidos TEXT, edad INTEGER, "+
            "telefono INTEGER, correo TEXT)";
    //ddl drop
    public static final String DropTablePersonas = "DROP TABLE IF EXISTS "+ TablePersonas;

    //dml
    public static final String SelectAllPersonas = "SELECT * FROM "+ TablePersonas;


}
