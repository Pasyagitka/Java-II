package meow.pasyagitka.findtrainingvideos.service;

import meow.pasyagitka.findtrainingvideos.model.Discipline;
import meow.pasyagitka.findtrainingvideos.repository.DisciplineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DisciplineService {
    @Autowired
    DisciplineRepository repo;

    public void save(Discipline discipline) {
        repo.save(discipline);
    }

    public List<Discipline> listAll() {
        return (List<Discipline>) repo.findAll();
    }

    public Discipline get(int id) {
        return repo.findById(id).get();
    }

    public void delete(int id) {
        repo.deleteById(id);
    }
}

