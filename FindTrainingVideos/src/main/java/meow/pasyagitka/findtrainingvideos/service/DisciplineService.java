package meow.pasyagitka.findtrainingvideos.service;

import meow.pasyagitka.findtrainingvideos.dto.DisciplineDto;
import meow.pasyagitka.findtrainingvideos.model.Discipline;
import meow.pasyagitka.findtrainingvideos.repository.DisciplineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static meow.pasyagitka.findtrainingvideos.utils.Mapper.map;
import static meow.pasyagitka.findtrainingvideos.utils.Mapper.mapAll;

@Service
@Transactional
public class DisciplineService {
    final DisciplineRepository repo;

    public DisciplineService(DisciplineRepository repo) {
        this.repo = repo;
    }

    public void save(DisciplineDto dto) {
        repo.save(map(dto, Discipline.class));
    }

    public List<DisciplineDto> listAll() {
        return mapAll((List<Discipline>)repo.findAll(), DisciplineDto.class);
    }

   /* public DisciplineDto get(int id) {
        return map(repo.findById(id).get(), DisciplineDto.class);
    }*/
     public Discipline get(int id) {
        return repo.findById(id).get();
    }

    public void delete(int id) {
        repo.deleteById(id);
    }
}

