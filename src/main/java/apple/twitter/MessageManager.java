package apple.twitter;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MessageManager {

	private Map<String, List<Subscriber>> topicSub = new HashMap<String, List<Subscriber>>();

	public void publish(String topic, String message) {
		if (!topicSub.containsKey(topic)) {
			topicSub.put(topic, new ArrayList<Subscriber>());
			return;
		}

		List<Subscriber> sub = topicSub.get(topic);
		{
			sub.forEach(s -> s.subscribe());

		}

	}

	public void getSubscription(String topic) {
		Subscriber s = new EmailSubsciber();
		List<Subscriber> sub = topicSub.get(topic);
		sub.add(s);

	}
}
