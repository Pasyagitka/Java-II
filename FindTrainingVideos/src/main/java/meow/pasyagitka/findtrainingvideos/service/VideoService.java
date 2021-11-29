package meow.pasyagitka.findtrainingvideos.service;

import io.swagger.v3.oas.annotations.Operation;
import meow.pasyagitka.findtrainingvideos.dto.VideoDto;
import meow.pasyagitka.findtrainingvideos.model.Video;
import meow.pasyagitka.findtrainingvideos.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static meow.pasyagitka.findtrainingvideos.utils.Mapper.*;
import static meow.pasyagitka.findtrainingvideos.utils.Mapper.map;

@Service
@Transactional
//все методы этого класса будут перехвачены Spring Data JPA для управления транзакциями
public class VideoService {
    @Autowired
    VideoRepository repo;

    public VideoDto save(VideoDto video) {
        Video v = repo.save(map(video, Video.class));
        return map(v, VideoDto.class);
    }

    public List<VideoDto> listAll() {
        return mapAll((List<Video>)repo.findAll(), VideoDto.class);
    }

    public VideoDto get(int id) {
        Optional<Video> optionalVideoDto = repo.findById(id);
        return optionalVideoDto.map(video -> map(video, VideoDto.class)).orElse(null);
    }//if present return object, otherwise null


    public void delete(int id) {
        repo.deleteById(id);
    }
}
