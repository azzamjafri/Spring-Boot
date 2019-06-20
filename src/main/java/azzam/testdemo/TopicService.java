package azzam.testdemo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {
     private List<Topic> topics = new ArrayList<>(Arrays.asList(
             new Topic("Spring", "Spring framework", "Spring framework description"),
                new Topic("Java", "Core java", "Core java description"),
                new Topic("Javascript", "Javascript framework", "Javascript framework description")
        ));
     public List<Topic> getAllTopics() {
         return topics;
     }

     public Topic getTopic(String id) {
        return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
     }

     public void addTopic(Topic topic) {
         topics.add(topic);
//         System.out.println(topics);
     }

     public void updateTopic(String id, Topic topic) {
         for(int i =0; i<topics.size(); i++) {

             Topic t = topics.get(i);
             if(t.getId().equals(id)) {
                 topics.set(i, topic);
                 return;
             }
         }
     }

     public void deleteTopic(String id) {
         topics.removeIf(t -> t.getId().equals(id));
         System.out.println("Removed !");

     }
}