package comp3350.grocerystoreassistant.application;

public class Main {

    private static String dbName = "gsadb";

    public static void setDBPathName(final String name) {
        try {
            Class.forName("org.hsqldb.jdbcDriver").newInstance();
        } catch (InstantiationException e) {
            throw new IllegalStateException("Can not instantiate instance of class org.hsqldb.jdbcDriver!", e);
        } catch (IllegalAccessException e) {
            throw new IllegalStateException("Can not access to the definition of class org.hsqldb.jdbcDriver while executing its methods!", e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        dbName = name;
    }

    public static String getDBPathName() {
        return dbName;
    }

}
