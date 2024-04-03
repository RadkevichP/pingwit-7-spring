package pl.pingwit.springdemo.controller.status;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.pingwit.springdemo.service.status.StatusService;

import java.util.List;

@RestController
@RequestMapping("/status")
public class StatusController {

    private final StatusService statusService;

    public StatusController(StatusService statusService) {
        this.statusService = statusService;
    }

    @GetMapping
    public List<StatusDto> findAllStatuses() {
        return statusService.findAll();
    }

    @GetMapping("/description")
    public List<StatusDto> findByDescriptionLike(@RequestParam(name = "fragment") String descriptionFragment) {
        return statusService.findAllByDescriptionFragment(descriptionFragment);
    }
}
