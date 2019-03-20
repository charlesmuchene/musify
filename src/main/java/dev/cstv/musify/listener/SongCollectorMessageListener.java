package dev.cstv.musify.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;


import dev.cstv.musify.domain.Song;
import dev.cstv.musify.domain.SongOutput;

public class SongCollectorMessageListener  implements MessageListener {

	@Override
	public void onMessage(Message message) {
		System.out.println("Main App - Song Collector Listener - Message Received: ");
		ObjectMessage objectMessage = (ObjectMessage) message;
		try {
			SongOutput song = (SongOutput) objectMessage.getObject();
			System.out.println("     ReleaseDate: " + song.getReleaseDate());
		} catch (JMSException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
}
