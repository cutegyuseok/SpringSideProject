package org.example.smartStore.store.Service;

import org.example.smartStore.store.DAO.ParameterDAO;
import org.example.smartStore.store.DTO.CustomerDTO;
import org.example.smartStore.store.DTO.ParameterDTO;
import org.example.smartStore.store.Entity.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class ParameterService implements iParameterService{

    @Autowired
    private ParameterDAO parameterDAO;

    public List<ParameterDTO> getAllParameter(String userID){
        List<ParameterDTO> parameterList = new LinkedList<>();
        for(int i=0;i<parameterDAO.getAllParameter(userID).size();i++){
            parameterList.add(parameterDAO.getAllParameter(userID).get(i).toDTO());
        }
        return parameterList;
    }

    public boolean insertParameter(Parameter parameter){
        return parameterDAO.insertParameter(parameter)>0;
    }

    public boolean updateParameter(Parameter parameter){
        return parameterDAO.updateParameter(parameter)>0;
    }

    public boolean deleteParameter(String grade,String userID){
        return parameterDAO.deleteParameter(grade,userID)>0;
    }
}
