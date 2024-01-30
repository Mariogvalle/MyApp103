package Configuracion;

public class Transacciones
{
    public static final String DBName = "PM012024"; //creación de la base de datos
    public static final String TablePersonas = "personas"; //creación de las tablas

    public static final String id = "id";
    public static final String nombres = "nombres";
    public static final String apellidos = "apellidos";
    public static final String edad = "edad";
    public static final String correo = "correo";
    public static final String telefono = "telefono";

    //ddl create
    public static final String CreateTablePersonas = "create table "+ TablePersonas + "("+
            "id INTEGER PRIMARY KEY AUTOINCREMENT, nombres TEXT, apellidos, edad integer, "+
            "telefono integer, correo text)";
    //ddl drop
    public static final String DropTablePersonas = "DROP TABLE IF EXISTS"+ TablePersonas;

    //dml
    public static final String SelectAllPersonas = "SELECT * FROM TABLE "+ TablePersonas;


}
