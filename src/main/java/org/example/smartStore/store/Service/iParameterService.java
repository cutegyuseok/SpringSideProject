package org.example.smartStore.store.Service;

import org.example.smartStore.store.DTO.ParameterDTO;
import org.example.smartStore.store.Entity.Parameter;

import java.util.List;

public interface iParameterService {
    List<ParameterDTO> getAllParameter(String userID);
    boolean insertParameter(Parameter parameter);
    boolean updateParameter(Parameter parameter);
    boolean deleteParameter(String grade,String userID);
    boolean deleteAllParameter(String userID);

}
