package me.abbas.sdszd;

import com.avaje.ebeaninternal.server.lib.sql.Prefix;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

public class ScoreboardWZ implements Listener {

    @EventHandler
    public void join(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        ScoreboardManager m = Bukkit.getScoreboardManager();
        Scoreboard b = m.getNewScoreboard();

        Objective o = b.registerNewObjective("Gold", "");
        o.setDisplaySlot(DisplaySlot.SIDEBAR);
        o.setDisplayName(ChatColor.BLUE + "" + ChatColor.BOLD + "Test Baord");

        Score score2 = o.getScore(ChatColor.DARK_AQUA + "Online:");
        Score score3 = o.getScore(ChatColor.WHITE + "   ");
        Score score4 = o.getScore(ChatColor.GRAY + "Blicklistmc.com");
        Score score5 = o.getScore(ChatColor.DARK_AQUA + "ServerIp");
        Score score6 = o.getScore(ChatColor.WHITE + "  ");
        Score score7 = o.getScore(ChatColor.GRAY + "Countdown Timer");
        Score score8 = o.getScore(ChatColor.DARK_AQUA + "Timer:");
        Score score9 = o.getScore(ChatColor.WHITE + " ");
        Score score10 = o.getScore(ChatColor.GRAY + "Prefix");
        Score score11 = o.getScore(ChatColor.DARK_AQUA + "Rank:");
        Score score12 = o.getScore(ChatColor.WHITE + "");

        score2.setScore(2);
        score3.setScore(3);
        score4.setScore(4);
        score5.setScore(5);
        score6.setScore(6);
        score7.setScore(7);
        score8.setScore(8);
        score9.setScore(9);
        score10.setScore(10);
        score11.setScore(11);
        score12.setScore(12);

        Team onlineCounter = b.registerNewTeam("onlineCounter");
        onlineCounter.addEntry(ChatColor.BLACK + "" + ChatColor.WHITE + "");
        if(Bukkit.getOnlinePlayers().size() == 0) {
            onlineCounter.setPrefix(ChatColor.GRAY + "" + "0" + ChatColor.GRAY + "/" + "" + ChatColor.GRAY + Bukkit.getServer().getMaxPlayers());
        }else {
            onlineCounter.setPrefix(String.valueOf(ChatColor.GRAY + "" + Bukkit.getServer().getOnlinePlayers().size() + "" + ChatColor.GRAY + "/" + ChatColor.GRAY + "" + Bukkit.getServer().getMaxPlayers()));
        }
        o.getScore(ChatColor.BLACK + "" + ChatColor.WHITE + "").setScore(1);

        player.setScoreboard(b);
    }

    public void updateScoreBoard(Player player) {
        Scoreboard board = player.getScoreboard();
        if(Bukkit.getOnlinePlayers().size() == 0) {
            board.getTeam("onlineCounter").setPrefix(ChatColor.GRAY + "" + "0" + ChatColor.GRAY + "/" + "" + ChatColor.GRAY + Bukkit.getServer().getMaxPlayers());
        }else {
            board.getTeam("onlineCounter").setPrefix(String.valueOf(ChatColor.GRAY + "" + Bukkit.getServer().getOnlinePlayers().size() + "" + ChatColor.GRAY + "/" + ChatColor.GRAY + "" + Bukkit.getServer().getMaxPlayers()));
        }
    }

}