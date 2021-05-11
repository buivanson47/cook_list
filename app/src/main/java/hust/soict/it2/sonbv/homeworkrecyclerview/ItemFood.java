package hust.soict.it2.sonbv.homeworkrecyclerview;

import java.io.Serializable;

public class ItemFood implements Serializable {
    public static final int TYPE_HORIZONTAL = 1;

    private String title;
    private String description;
    private int resImage;
    private String ingredient;
    private String process;
    private int type;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public ItemFood() {
    }

    public ItemFood(int type) {
        this.type = type;
    }

    public ItemFood(String title, String description, int resImage, String ingredient, String process) {
        this.title = title;
        this.description = description;
        this.resImage = resImage;
        this.ingredient = ingredient;
        this.process = process;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getResImage() {
        return resImage;
    }

    public void setResImage(int resImage) {
        this.resImage = resImage;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }
}
