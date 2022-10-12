package oushi.mokumokubot;
import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import net.dv8tion.jda.api.sharding.ShardManager;

public class App 
{
	private final ShardManager shardManager;
    private static final String BOT_TOKEN = (System.getenv("TOKEN"));
    
    public App() throws LoginException {
    	DefaultShardManagerBuilder builder = DefaultShardManagerBuilder.createDefault(BOT_TOKEN);
    	builder.setStatus(OnlineStatus.ONLINE);
    	builder.setActivity(Activity.watching("もくもく"));
    	shardManager = builder.build();
    }
    
    public ShardManager getShardManager() {
    	return shardManager;
    }
    
    public static void main( String[] args ) {
    		try {
    			App bot = new App();
    		} catch (LoginException e) {
    			System.out.println("ERROR: provided bot token is invalid!");
    		}
    }
}