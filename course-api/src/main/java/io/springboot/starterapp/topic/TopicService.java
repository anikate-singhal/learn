package io.springboot.starterapp.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	private List<Topic> topics=new ArrayList<>(Arrays.asList(
			
			new Topic("1","spring1","framework1"),
			new Topic("2","spring2","framework2"),
			new Topic("3","spring3","framework3"))
			
			
			);
	public List<Topic> getAllTopics(){
		
		return topics;
	}
 	
	public Topic getTopic(String id) {
		return topics.parallelStream().filter(t -> t.getId().equals(id)).findFirst().get();
	}
	
	public void addTopic(Topic topic)
	{
		topics.add(topic);
	}

	public void updateTopic(String id, Topic topic) {
		for(int i=0;i<topics.size(); i++)
		{
			Topic t=topics.get(i);
			if(t.getId().equals(id))
			{
				topics.set(i, topic);
				return;
				
			}
		}
		
		
	}

	public void deleteTopic(String id) {
	/*	for(int i=0;i<topics.size(); i++)
		{
			Topic t=topics.get(i);
			if(t.getId().equals(id))
			{
				topics.remove(id);
				return;
				
			}
		}
		*/
		topics.removeIf(t -> t.getId().equals(id));
		
		
	}
	
	
}
