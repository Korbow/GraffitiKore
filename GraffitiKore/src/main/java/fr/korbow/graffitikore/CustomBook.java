package fr.korbow.graffitikore;

import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

import java.util.HashMap;
import java.util.Map;

public class CustomBook {
    private final Map<Integer, Integer> pageModelDataMap = new HashMap<>();

    // Method for create a page, here for 1 graffiti/page
    public BaseComponent[] createCustomPage(int pageIndex, String title, String FontTitle, String FontSelect, String hoverText1, String hoverText2, String command, Integer CMD, String CustomSound) {
        pageModelDataMap.put(pageIndex, CMD);
        return new ComponentBuilder(FontTitle+ " §4" + title + "                            " +
                "                                                       " +
                "                                                       " +
                "                                                       " +
                "                                                       " +
                "                                                       ")
                .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(hoverText1).create()))
                .append(FontSelect + "                         " +
                        "                      ")
                .event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(hoverText2).create()))
                .event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, command))
                .create();
    }

    public int getCustomModelData(int pageIndex) {
        return pageModelDataMap.getOrDefault(pageIndex, 0); // Retourne 0 si la page n'existe pas
    }

    // Create the custom book
    public ItemStack createCustomBook(Player player) {
        ItemStack book = new ItemStack(Material.WRITTEN_BOOK);
        BookMeta bookMeta = (BookMeta) book.getItemMeta();

        if (bookMeta != null) {
            // Create pages as you want with the createCustomPage method
            BaseComponent[] page1 = createCustomPage(1, "     ", "§f\uF02D", "§f\uF801","grafitti acgam", "Choose ?", "/graffiti 1", 1, "custom.graffiti");
            BaseComponent[] page2 = createCustomPage(2, "     ", "§f\uF03D", "§f\uF801","grafitti caca", "Choose ?", "/graffiti 2", 2, "custom.graffiti");
            BaseComponent[] page3 = createCustomPage(3, "     ", "§f\uF04D", "§f\uF801","grafitti caca", "Choose ?", "/graffiti 3", 3, "custom.graffiti");
            BaseComponent[] page4 = createCustomPage(4, "     ", "§f\uF05D", "§f\uF801","grafitti caca", "Choose ?", "/graffiti 4", 4, "custom.graffiti");
            BaseComponent[] page5 = createCustomPage(5, "     ", "§f\uF06D", "§f\uF801","grafitti caca", "Choose ?", "/graffiti 5", 5, "custom.graffiti");
            BaseComponent[] page6 = createCustomPage(6, "     ", "§f\uF07D", "§f\uF801","grafitti caca", "Choose ?", "/graffiti 6", 6, "custom.graffiti");
            BaseComponent[] page7 = createCustomPage(7, "     ", "§f\uF08D", "§f\uF801","grafitti caca", "Choose ?", "/graffiti 7", 7, "custom.graffiti");
            BaseComponent[] page8 = createCustomPage(8, "     ", "§f\uF09D", "§f\uF801","grafitti caca", "Choose ?", "/graffiti 8", 8, "custom.graffiti");
            BaseComponent[] page9 = createCustomPage(9, "     ", "§f\uF01E", "§f\uF801","grafitti caca", "Choose ?", "/graffiti 9", 9, "custom.graffiti");
            BaseComponent[] page10 = createCustomPage(10, "     ", "§f\uF02E", "§f\uF801","grafitti caca", "Choose ?", "/graffiti 10", 10, "custom.graffiti");
            BaseComponent[] page11 = createCustomPage(11, "     ", "§f\uF03E", "§f\uF801","grafitti caca", "Choose ?", "/graffiti 11", 11, "custom.graffiti");
            BaseComponent[] page12 = createCustomPage(12, "     ", "§f\uF04E", "§f\uF801","grafitti caca", "Choose ?", "/graffiti 12", 12, "custom.graffiti");

            // Ajout des pages au livre
            bookMeta.spigot().addPage(page1, page2, page3, page4, page5, page6, page7, page8, page9, page10, page11, page12);


            bookMeta.setCustomModelData(1);
            // méta properties of the book
            bookMeta.setTitle("ArtBook");
            bookMeta.setAuthor(player.getName());


            book.setItemMeta(bookMeta);
        }

        return book;
    }
}