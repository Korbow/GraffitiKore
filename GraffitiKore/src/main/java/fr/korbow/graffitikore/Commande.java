package fr.korbow.graffitikore;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.ItemFrame;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class Commande implements CommandExecutor {
    private final CustomBook customBook;

    // Constructor for the instance of CustomBook
    public Commande(CustomBook customBook) {
        this.customBook = customBook;
    }
    //get the block face where the player is looking at
    public BlockFace getBlockFace(Player player) {
        List<Block> lastTwoTargetBlocks = player.getLastTwoTargetBlocks(null, 100);
        if (lastTwoTargetBlocks.size() != 2 || !lastTwoTargetBlocks.get(1).getType().isOccluding()) return null;
        Block targetBlock = lastTwoTargetBlocks.get(1);
        Block adjacentBlock = lastTwoTargetBlocks.get(0);
        return targetBlock.getFace(adjacentBlock);
    }

    //Command for making a graffiti
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            if (cmd.getName().equalsIgnoreCase("graffiti") && args.length > 0) {
                try {
                    int pageIndex = Integer.parseInt(args[0]);
                    int customModelData = customBook.getCustomModelData(pageIndex);

                    Location playerLocation = player.getLocation();
                    Block blockInFront = player.getTargetBlockExact(5);

                    if (blockInFront != null && blockInFront.getType() != Material.AIR) {
                        double distance = playerLocation.distance(blockInFront.getLocation());

                        if (distance <= 5) {
                            BlockFace blockFace = getBlockFace(player);
                            if (blockFace != null) {
                                Location itemFrameLocation = blockInFront.getRelative(blockFace).getLocation();
                                ItemFrame itemFrame = blockInFront.getWorld().spawn(itemFrameLocation, ItemFrame.class);
                                itemFrame.setVisible(false);
                                


                                ItemStack item = new ItemStack(Material.CARROT_ON_A_STICK);
                                ItemMeta meta = item.getItemMeta();
                                if (meta != null) {
                                    meta.setCustomModelData(customModelData); // Use the CustomModelData
                                    item.setItemMeta(meta);

                                }

                                itemFrame.setItem(item);


                                // Play the Custom Sound
                                player.playSound(playerLocation, "custom.graffiti", 1.0f, 1.0f);
                                return true;
                            } else {
                                player.sendMessage("Impossible de déterminer la face du bloc.");
                            }
                        } else {
                            player.sendMessage("Too far!");
                        }
                    }
                } catch (NumberFormatException e) {
                    player.sendMessage("Argument de commande invalide !");
                }
            } else if (cmd.getName().equalsIgnoreCase("book")) { // Command to give book to the player
                ItemStack book = customBook.createCustomBook(player);
                ItemMeta meta = book.getItemMeta();
                if (meta != null) {
                    meta.setCustomModelData(1);
                    book.setItemMeta(meta);

                }
                if (book.getItemMeta() instanceof BookMeta && book.getItemMeta().hasCustomModelData()) {
                    player.getInventory().addItem(book);
                    player.updateInventory(); // Forcer la mise à jour de l'inventaire
                    player.sendMessage("Réussite");
                } else {
                    player.sendMessage("Échec");
                }
                return true;
            }
        }
        return false;
    }
}
