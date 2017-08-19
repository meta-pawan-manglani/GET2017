package com.metacube.DAO;

import com.metacube.enums.DBType;

/**
 * A factory for creating DAO objects.
 *
 * @author Pawan Manglani
 * @version 1.1 18-Aug-2017
 */
public class DAOFactory {

    /**
     * Gets the single instance of DAOFactory.
     *
     * @param dbType tells the type of database
     * @return single instance of DAOFactory
     */
    private static BaseDao dao = null;

    public static BaseDao getInstance(DBType dbType) {
        if (dao == null) {
            synchronized (DAOFactory.class) {
                if (dao == null) {

                    switch (dbType) {
                        case FileDao:
                            dao =  new FileDao();
                            break;
                        case InMemoryDao:
                            dao =  new InMemoryDao();
                            break;
                        case MySQLDao:
                            dao =  new MySqlDao();
                            break;
                        default:
                            dao =  null;
                    }
                }
            }
        }
        return dao;
    }
}
