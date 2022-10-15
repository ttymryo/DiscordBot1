package oushi.mokumokubot.listeners;

import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class EventListener extends ListenerAdapter{

	@Override
	public void onMessageReactionAdd(MessageReactionAddEvent event) {
		User user = event.getUser();
		String emoji = event.getReaction().getEmoji().toString();
		String channelMention = event.getChannel().getAsMention();
		String jumpLink = event.getJumpUrl();
		
		String message = user.getAsTag() + "reacted to a message with" + emoji + " in the " + channelMention + "channel!";
		((MessageChannel) event.getGuild().getDefaultChannel()).sendMessage(message).queue();
		}

	@Override
	public void onMessageReceived(MessageReceivedEvent event) {
		String message = event.getMessage().getContentRaw();
		if (message.contains("ping")) {
			event.getChannel().sendMessage("pong").queue();
		}
	}
	
	
}
