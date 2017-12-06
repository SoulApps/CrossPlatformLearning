package es.alesagal.dabeef_bot;

import de.btobastian.sdcf4j.CommandHandler;
import de.btobastian.sdcf4j.handler.JDA3Handler;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.exceptions.RateLimitedException;

import javax.security.auth.login.LoginException;

public class Main {

    public static void main(String[] args) {
        try {
            // TODO actualizar token.
            JDA jda = new JDABuilder(AccountType.BOT)
                    .setToken("MzM4NzE4NTU2MDg0NjMzNjAw.DFZmyA.Gr-4I3goNtjLSJimvknbiXxbIRk")
                    .buildBlocking();

            jda.setAutoReconnect(true);

            CommandHandler cmdHandler = new JDA3Handler(jda);
            cmdHandler.registerCommand(new DabeefBot());
        } catch (LoginException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (RateLimitedException e) {
            e.printStackTrace();
        }
    }
}
