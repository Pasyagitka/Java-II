package meow.pasyagitka.findtrainingvideos.repository;

import meow.pasyagitka.findtrainingvideos.model.Video;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoRepository extends CrudRepository<Video, Integer> {
}