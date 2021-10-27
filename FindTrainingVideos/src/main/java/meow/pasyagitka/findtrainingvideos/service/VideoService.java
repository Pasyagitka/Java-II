package meow.pasyagitka.findtrainingvideos.service;

import meow.pasyagitka.findtrainingvideos.model.Video;
import meow.pasyagitka.findtrainingvideos.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
//все методы этого класса будут перехвачены Spring Data JPA для управления транзакциями
public class VideoService {
    @Autowired
    VideoRepository repo;

    public void save(Video video) {
        repo.save(video);
    }

    public List<Video> listAll() {
        return (List<Video>) repo.findAll();
    }

    public Video get(int id) {
        return repo.findById(id).get();
    }

    public void delete(int id) {
        repo.deleteById(id);
    }
}
