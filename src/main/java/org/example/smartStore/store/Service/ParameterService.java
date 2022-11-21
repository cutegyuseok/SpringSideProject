package org.example.smartStore.store.Service;

import org.example.smartStore.store.DAO.ParameterDAO;
import org.example.smartStore.store.Entity.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParameterService implements iParameterService{

    @Autowired
    private ParameterDAO parameterDAO;

    public List<Parameter> getAllParameter(String userID){
        return parameterDAO.getAllParameter(userID);
    }

    public boolean insertParameter(Parameter parameter){
        return parameterDAO.insertParameter(parameter)>0;
    }

    public boolean updateParameter(Parameter parameter){
        return parameterDAO.updateParameter(parameter)>0;
    }

    public boolean deleteParameter(String grade){
        return parameterDAO.deleteParameter(grade)>0;
    }
}
