package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
    static final String AGED_BRIE = "Aged Brie";

    public void updateQuality() {
        for (Item item : items) {
            switch (item.name) {
                case SULFURAS:
                    continue;

                case AGED_BRIE:
                    increaseQuality(item);
                    break;
                case BACKSTAGE:
                    increaseQuality(item);
                    if (item.sellIn < 11) increaseQuality(item);
                    if (item.sellIn < 6) increaseQuality(item);
                    break;
                default:
                    decreaseQuality(item);
                    break;
            }

            item.sellIn--;

            if (item.sellIn < 0) {
                if (item.name.equals(AGED_BRIE)) {
                    increaseQuality(item);
                } else if (item.name.equals(BACKSTAGE)) {
                    item.quality = 0;
                } else {
                    decreaseQuality(item);
                }
            }
        }
    }

    private void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality++;
        }
    }

    private void decreaseQuality(Item item) {
        if (item.quality > 0) {
            item.quality--;
        }
    }
}