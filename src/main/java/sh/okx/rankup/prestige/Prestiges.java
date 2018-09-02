package sh.okx.rankup.prestige;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import sh.okx.rankup.RankList;
import sh.okx.rankup.Rankup;

public class Prestiges extends RankList<Prestige> {
  public Prestiges(Rankup plugin, FileConfiguration config) {
    super(plugin, config, section -> Prestige.deserialize(plugin, section));
  }

  @Override
  public Prestige getByPlayer(Player player) {
    return ranks.stream()
        .filter(rank -> rank.isIn(player))
        .findFirst()
        .orElseGet(this::getFirst);
  }
}