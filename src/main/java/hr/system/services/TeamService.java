package hr.system.services;

import hr.system.entities.Employee;
import hr.system.entities.Team;
import hr.system.repositories.TeamRepository;
import hr.system.utils.exceptions.TeamNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TeamService {
    @Autowired
    private final TeamRepository repository;

    public TeamService(TeamRepository repository) {
        this.repository = repository;
    }

    public List<Employee> getTeamMembers(UUID id) {
        Team team = this.repository.findById(id).orElseThrow(() -> new TeamNotFoundException(id));
        return team.getMembers();
    }
}
