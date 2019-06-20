package azzam.testdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class topicController {
    @Autowired
    private TopicService topicService;

    @RequestMapping(value = "/topics",method = RequestMethod.GET)
    public List<Topic> getAlltopics() {
        return topicService.getAllTopics();
    }

    @RequestMapping("topics/{id}")
    public Topic getTopic(@PathVariable String id) {
        return topicService.getTopic(id);
    }

    @PostMapping("/topics")
    public void addTopic(@RequestBody Topic topic) {
        topicService.addTopic(topic);
    }

    @PutMapping("topics/{id}")
    public void updateTopic(@RequestBody Topic topic, @PathVariable String id) {
        topicService.updateTopic(id, topic);
    }

    @DeleteMapping("topics/{id}")
    public void deleteTopic( @PathVariable String id, @RequestBody Topic topic) {
        topicService.deleteTopic(id);
    }
}