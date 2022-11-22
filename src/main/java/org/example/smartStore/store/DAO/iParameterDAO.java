package org.example.smartStore.store.DAO;

import org.example.smartStore.store.Entity.Parameter;

import java.util.List;

public interface iParameterDAO {
    List<Parameter> getAllParameter(String userID);
    int insertParameter(Parameter parameter);
    int deleteParameter(String grade,String userID);
    int updateParameter(Parameter parameter);
    int deleteAllParameter(String userID);

}
