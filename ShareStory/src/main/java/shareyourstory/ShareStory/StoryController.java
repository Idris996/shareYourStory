package shareyourstory.ShareStory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/story")
public class StoryController {

    public final StoryRepository storyRepository;

    @Autowired
    public StoryController(StoryRepository storyRepository) {
        this.storyRepository = storyRepository;
    }

    @PostMapping
    public Story addStory (@RequestBody Story story){
        return storyRepository.save(story);
    }

    @GetMapping
    public List<Story> getStory (){
        return storyRepository.findAll();
    }
    @GetMapping("/{id}")
    public Story getStory(@PathVariable("id") Long id ){

        return storyRepository.findById(id)
                .orElseThrow(() -> new NullPointerException());
    }

    @PutMapping("/{id}")
    public void approveStory (@PathVariable("id") Long id){
        Story story = storyRepository.getOne(id);
        Boolean approved = story.getApproved();
        story.setApproved(true);

        storyRepository.save(story);
    }
    @PutMapping("/like/{id}")
    public void likeStory(@PathVariable("id") Long id){
        Story story = storyRepository.getOne(id);


        Long likes = story.getLikes();
        story.setLikes(likes + 1);

        storyRepository.save(story);

    }

    @PutMapping("/dislike/{id}")
    public void dislikeStory(@PathVariable("id") Long id){
        Story story = storyRepository.getOne(id);

            Long dislikes = story.getDislikes();
            story.setDislikes(dislikes + 1);

            storyRepository.save(story);

    }


    @DeleteMapping("/{id}")
    void deleteStory(@PathVariable Long id){
        storyRepository.deleteById(id);
    }
}
