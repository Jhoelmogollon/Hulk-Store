package com.kardex.hulkstore.persistence.mapper;

import com.kardex.hulkstore.persistence.entity.Purchase;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PurchaseItemMapper.class})
public interface PurchaseMapper {

    @Mappings({
            @Mapping(source = "idPurchase", target = "idPurchase"),
            @Mapping(source = "idCustomer", target = "idUser"),
            @Mapping(source = "datePurchase", target = "date"),
            @Mapping(source = "paymentMethod", target = "paymentMethod"),
            @Mapping(source = "status", target = "status"),
            @Mapping(source = "products", target = "items")
    })
    com.kardex.hulkstore.domain.Purchase toPurchaseDomain(Purchase purchase);
    List<com.kardex.hulkstore.domain.Purchase> toPurchasesDomain(List<Purchase> purchase);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping( target = "user", ignore = true),
    })
    Purchase toPurchaseEntity(com.kardex.hulkstore.domain.Purchase purchase);

}
