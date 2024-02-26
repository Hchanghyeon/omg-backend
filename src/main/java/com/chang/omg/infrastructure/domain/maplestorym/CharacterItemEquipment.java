package com.chang.omg.infrastructure.domain.maplestorym;

import java.util.List;

public record CharacterItemEquipment(List<ItemEquipment> itemEquipment) {

    record ItemEquipment(String itemName, String itemEquipmentPageName, String itemEquipmentSlotName) {

    }
}
