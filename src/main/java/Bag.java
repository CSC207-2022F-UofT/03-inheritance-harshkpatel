/*
 * This file defines an abstract class named Bag.
 * In this exercise, you will be writing a larger class according to
 * the TODOs we have left you. You may find the readings in chapter
 * 1. Introduction to Java helpful.
 */


public abstract class Bag {
    String color;
    int numberOfContents;
    int capacity;
    String[] contents;

    public Bag(String color, int capacity) {
        this.color = color;
        this.capacity = capacity;
        this.numberOfContents = 0;
        this.contents = new String[]{};
    }
    public String getColor() {
        return this.color;
    }
    public int getNumberOfContents() {
        return this.numberOfContents;
    }
    public int getCapacity() {
        return this.capacity;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public boolean addItem(String item) {
        if (this.numberOfContents < this.capacity){
            String[] newContents = new String[numberOfContents + 1];
            for (int i = 0; i < this.numberOfContents; i++)
                newContents[i] = this.contents[i];
            newContents[newContents.length - 1] = item;
            this.contents = newContents;
            numberOfContents++;
            return true;
        }
        else
            return false;
    }
    public String popItem() {
        if (this.contents.length == 0)
            return null;
        else {
            String toRemove = this.contents[this.numberOfContents - 1];
            String[] removed = new String[this.numberOfContents - 1];
            for (int i = 0; i < this.numberOfContents - 1; i++) {
                removed[i] = this.contents[i];
            }
            this.contents = removed;
            this.numberOfContents--;
            return toRemove;
        }
    }

    /**
     * Increase this bag's capacity by n.
     *
     * @param n the amount to increase this Bag's capacity by
     */
    public void increaseCapacity(int n) {
        this.capacity += n;
    }

    /**
     * Return the details of this Bag.
     * This method requires you to have created the private
     * instance variables mentioned above.
     *
     * @return
     */
    @Override
    public String toString() {
        return this.color + " Bag (" + this.numberOfContents + " / " +
                this.capacity + ")";
    }

    /*
     * Below we have defined an abstract method.
     * This method takes no arguments and does not return anything.
     * It increases the capacity of this Bag.
     *
     * You will need to implement this method in
     * HandBag.java and CrossbodyBag.java.
     *
     * We recommend you look at HandBag.java first.
     */
    public abstract void enhance();
}