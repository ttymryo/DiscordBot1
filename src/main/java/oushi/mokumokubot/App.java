package oushi.mokumokubot;
import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;

public class App 
{
	private static JDA jda = null;
    private static final String BOT_TOKEN = (System.getenv("TOKEN"));
    
    public static void main( String[] args ) throws LoginException {
    		jda = JDABuilder.createDefault(BOT_TOKEN, GatewayIntent.GUILD_MESSAGES)
                    .setRawEventsEnabled(true)
                    .setActivity(Activity.playing("もくもく監視中"))
                    .build();
    }
}