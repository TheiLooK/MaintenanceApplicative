package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ItemTest {

    @Test
    void testToString() {
        Item item = new Item("foo", 0, 0);
        assertEquals("foo, 0, 0", item.toString());
    }

}
