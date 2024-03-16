package pl.pingwit.springdemo.service;


import org.springframework.stereotype.Service;
import pl.pingwit.springdemo.controller.StatusDto;
import pl.pingwit.springdemo.repository.StatusEntity;
import pl.pingwit.springdemo.repository.StatusRepository;

import java.util.List;

@Service
public class StatusService {

    private final StatusRepository statusRepository;

    public StatusService(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }


    public List<StatusDto> findAll() {
        List<StatusEntity> all = statusRepository.findAll();
        return all.stream()
                .map(entity -> new StatusDto(entity.getId(), entity.getName(), entity.getDescription()))
                .toList();
    }

    public List<StatusDto> findAllByDescriptionFragment(String descriptionFragment) {
        String likeString = "%" + descriptionFragment + "%";
        return statusRepository.findAllByDescriptionLikeIgnoreCase(likeString).stream()
                .map(entity -> new StatusDto(entity.getId(), entity.getName(), entity.getDescription()))
                .toList();
    }
}
