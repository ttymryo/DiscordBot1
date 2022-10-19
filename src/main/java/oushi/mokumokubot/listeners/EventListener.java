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

//	@Override
//	public void onMessageReceived(MessageReceivedEvent event) {
//		String message = event.getMessage().getContentRaw();
//		if (message.contains("ping")) {
//			((MessageChannel) event.getChannel()).sendMessage("pong").queue();
//		}
//	}
	
	@Override
    public void onMessageReceived(MessageReceivedEvent event)
    {
        if (event.getAuthor().isBot()) return;
        // We don't want to respond to other bot accounts, including ourself
        net.dv8tion.jda.api.entities.Message message = event.getMessage();
        String content = message.getContentRaw(); 
        // getContentRaw() is an atomic getter
        // getContentDisplay() is a lazy getter which modifies the content for e.g. console view (strip discord formatting)
        if (content.equals("!ping"))
        {
            MessageChannel channel = event.getChannel();
            channel.sendMessage("Pong!").queue(); // Important to call .queue() on the RestAction returned by sendMessage(...)
        }
    }
	
}
