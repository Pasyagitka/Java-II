package meow.pasyagitka.findtrainingvideos.repository;

import meow.pasyagitka.findtrainingvideos.model.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoRepository extends JpaRepository<Video, Integer>, JpaSpecificationExecutor<Video> {
}