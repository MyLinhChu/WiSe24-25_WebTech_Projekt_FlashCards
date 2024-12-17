package de.htwberlin.webtech.wi2425.web;

import de.htwberlin.webtech.wi2425.FlashCard;

import java.util.List;

public class Deck {
    private int id;
    private String name;
    private String description;
    private List<FlashCard> cards;
    private List<String> tags;
    private String createdAt;
    private String updatedAt;

    public Deck() {}

    // Getter und Setter für alle Felder
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public List<FlashCard> getCards() { return cards; }
    public void setCards(List<FlashCard> cards) { this.cards = cards; }

    public List<String> getTags() { return tags; }
    public void setTags(List<String> tags) { this.tags = tags; }

    public String getCreatedAt() { return createdAt; }
    public void setCreatedAt(String createdAt) { this.createdAt = createdAt; }

    public String getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(String updatedAt) { this.updatedAt = updatedAt; }
}
