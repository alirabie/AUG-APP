package examplew.midopc.aug_app.POJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mido PC on 2/24/2016.
 */
public class Cat {
    @SerializedName("name")
@Expose
private String name;
    @SerializedName("picName")
    @Expose
    private String picName;
    @SerializedName("items")
    @Expose
    private List<Item> items = new ArrayList<Item>();

    private boolean checked;

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    /**
     *
     * @return
     * The name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     * The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     * The picName
     */
    public String getPicName() {
        return picName;
    }

    /**
     *
     * @param picName
     * The picName
     */
    public void setPicName(String picName) {
        this.picName = picName;
    }

    /**
     *
     * @return
     * The items
     */
    public List<Item> getItems() {
        return items;
    }

    /**
     *
     * @param items
     * The items
     */
    public void setItems(List<Item> items) {
        this.items = items;
    }

}
