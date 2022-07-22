package com.example.demoapi.services.impl;

import com.example.demoapi.model.Status;
import com.example.demoapi.model.response.StatusResponse;
import com.example.demoapi.repository.StatusRepository;
import com.example.demoapi.services.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StatusServiceImpl implements StatusService {
    @Autowired
    StatusRepository statusRepository;
    @Override
    public List<StatusResponse> getAll() {
        return ToStatusReponse(statusRepository.findAll());
    }

    @Override
    public StatusResponse getById(Long id) {
        return ToStatusReponse(statusRepository.findByStatusId(id));
    }

    @Override
    public boolean IsExist(Long id) {
        return statusRepository.existsById(id);
    }

    private StatusResponse ToStatusReponse(Status status){
        StatusResponse statusResponse = new StatusResponse();
        statusResponse.setStatusId(status.getStatusId());
        statusResponse.setName(status.getName());
        statusResponse.setDescription(status.getDescription());
        return statusResponse;
    }
    private List<StatusResponse> ToStatusReponse(List<Status> statusList)
    {
        List<StatusResponse> statusResponses = new ArrayList<>();
        for (Status status:statusList){
            statusResponses.add(ToStatusReponse(status));
        }
        return statusResponses;
    }
}
