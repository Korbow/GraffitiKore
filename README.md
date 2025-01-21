
# GraffitiKore
Works on a way to make graffitis in minecraft by using a plugin and a resource pack

![image](https://github.com/user-attachments/assets/82c99938-5273-433a-8faa-7e726a28f1bb)

## <ins>  How does it work ?</ins>

- The graffitis are CustomModelData of Carrot on a Stick, so with custom models and custom textures; they are displayed on an invisible Item Frame.
- The selection of the graffitis is made by a book, you can select a graffiti by clicking on a button displayed on the page of the book. Each page represents a different graffiti.
![ezgif-4-f71525b694](https://github.com/user-attachments/assets/73f8911b-0635-4e86-9b6e-76c926c5ae95)


## <ins>  How to make a Graffiti ?</ins>

You have to change the plugin and the resource pack:

**- 1/ Create a new BaseComponent in the plugin :**

By using the createCustomPage method, create a BaseComponent bellow the other one, following the same scheme.

Follow this patern:

```BaseComponent[] page{int_number_of_the_page} = createCustomPage({int_number_of_the_page}, "     ", "§f{font_for_the_title}", "§f{font_for_the_select}","{string_text_hover_font_title}", "{string_text_hover_font_select}", "/graffiti {int_number_of_the_page}", {int_number_of_the_page}, "{path_of_the_custom_sounds}");```




