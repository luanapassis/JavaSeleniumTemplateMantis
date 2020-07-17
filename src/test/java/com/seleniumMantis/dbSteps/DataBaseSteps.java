package com.seleniumMantis.dbSteps;

import com.seleniumMantis.utils.DbUtils;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class DataBaseSteps extends DbUtils
{

    public ArrayList<String> retoraUsuario(String usuario)
    {
        String query = "select * from bugtracker.mantis_user_mantis where username = 'administrator'";
        ArrayList<String> resultado = getQueryResult(query);
        return  resultado;
    }

}
