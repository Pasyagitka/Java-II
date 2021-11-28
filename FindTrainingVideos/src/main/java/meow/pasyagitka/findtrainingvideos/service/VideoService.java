package meow.pasyagitka.findtrainingvideos.service;

import meow.pasyagitka.findtrainingvideos.dto.VideoDto;
import meow.pasyagitka.findtrainingvideos.model.Role;
import meow.pasyagitka.findtrainingvideos.model.User;
import meow.pasyagitka.findtrainingvideos.model.Video;
import meow.pasyagitka.findtrainingvideos.repository.VideoRepository;
import meow.pasyagitka.findtrainingvideos.utils.Mapping;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static meow.pasyagitka.findtrainingvideos.utils.Mapper.*;

@Service
@Transactional
//все методы этого класса будут перехвачены Spring Data JPA для управления транзакциями
public class VideoService {
    @Autowired
    VideoRepository repo;

    public void save(VideoDto video) {
        repo.save(map(video, Video.class));
    }

    public List<VideoDto> listAll() {
        return mapAll((List<Video>)repo.findAll(), VideoDto.class);
    }

    public VideoDto get(int id) {
        return map(repo.findById(id).get(), VideoDto.class);
    }
    //todo convert entity to dto

    public void delete(int id) {
        repo.deleteById(id);
    }
}
