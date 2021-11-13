package com.kardex.hulkstore.persistence.mapper;

import com.kardex.hulkstore.domain.PurchaseItem;
import com.kardex.hulkstore.persistence.entity.Product;
import com.kardex.hulkstore.persistence.entity.PurchaseProduct;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {Product.class})
public interface PurchaseItemMapper {

    @Mappings({
            @Mapping(source = "id.idProduct", target = "idProduct"),
            @Mapping(source = "amount", target = "amount"),
            @Mapping(source = "status", target = "active")
    })
    PurchaseItem toPurchaseItem(PurchaseProduct product);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping( target = "id.idSell", ignore = true),
            @Mapping( target = "product", ignore = true),
            @Mapping( target = "sell", ignore = true)
    })
    PurchaseProduct toPurchaseProduct(PurchaseItem item);
}
