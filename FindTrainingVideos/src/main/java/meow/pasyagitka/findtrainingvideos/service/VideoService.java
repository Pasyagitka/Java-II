package meow.pasyagitka.findtrainingvideos.service;

import meow.pasyagitka.findtrainingvideos.dto.SearchDto;
import meow.pasyagitka.findtrainingvideos.dto.VideoDto;
import meow.pasyagitka.findtrainingvideos.model.Video;
import meow.pasyagitka.findtrainingvideos.repository.VideoRepository;
import meow.pasyagitka.findtrainingvideos.specification.VideoSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import static meow.pasyagitka.findtrainingvideos.utils.Mapper.*;
import static meow.pasyagitka.findtrainingvideos.utils.Mapper.map;

@Service
@Transactional
//все методы этого класса будут перехвачены Spring Data JPA для управления транзакциями
public class VideoService {
    @Autowired
    VideoRepository repo;

    public VideoDto save(VideoDto video) {
        video.setDate(new Date());
        Video v = repo.save(map(video, Video.class));
        return map(v, VideoDto.class);
    }

    public List<VideoDto> listAll() {
        return mapAll((List<Video>)repo.findAll(), VideoDto.class);
    }

    public List<VideoDto> listAllCriteria(String criteria) {
        VideoSpecification spec = new VideoSpecification(new SearchDto("title", ":", criteria));
        VideoSpecification spec2 = new VideoSpecification(new SearchDto("theme", ":", criteria));
        List<Video> list = (List<Video>)repo.findAll(Specification.where(spec).or(spec2));
        return mapAll(list, VideoDto.class);
    }

    public List<VideoDto> filterVideos(String theme, String author) {
        VideoSpecification spec1 = new VideoSpecification(new SearchDto("theme", ":", theme));
        VideoSpecification spec2 = new VideoSpecification(new SearchDto("author", ":", author));
        List<Video> list;
        if (Objects.equals(author, "All")) list = repo.findAll(spec1);
        else if (Objects.equals(theme, "All")) list = repo.findAll(spec2);
        else list = repo.findAll(Specification.where(spec1).and(spec2));
        return mapAll(list, VideoDto.class);
    }

    public Page<Video> findAll(org.springframework.data.domain.Pageable pageable) {
        return repo.findAll(pageable);
    }


    public Page<Video> findPaginatedCriteria(int pageNo, int pageSize, String sortField, String sortDirection, Specification<Video> spec) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ?
                Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return repo.findAll(spec, pageable);
    }

    public Page<Video> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ?
                Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.repo.findAll(pageable);
    }
    public List<String> getAuthors(){
        List<Video> list = repo.findAll();
        return list.stream().map(Video::getAuthor).distinct().collect(Collectors.toList());
    }
    public List<String> getThemes(){
        List<Video> list = repo.findAll();
        return list.stream().map(Video::getTheme).distinct().collect(Collectors.toList());
    }

    public VideoDto get(int id) {
        Optional<Video> optionalVideoDto = repo.findById(id);
        return optionalVideoDto.map(video -> map(video, VideoDto.class)).orElse(null);
    }//if present return object, otherwise null

    public void delete(int id) {
        repo.deleteById(id);
    }
}
