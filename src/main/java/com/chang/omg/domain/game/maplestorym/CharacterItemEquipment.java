package com.chang.omg.domain.game.maplestorym;

import java.util.List;

public record CharacterItemEquipment(List<ItemEquipment> itemEquipment) {

    record ItemEquipment(String itemName, String itemEquipmentPageName, String itemEquipmentSlotName) {

    }
}
