package com.platzi.market.persistence.mapper;

import com.platzi.market.domain.Purchase;
import com.platzi.market.domain.PurchaseItem;
import com.platzi.market.persistence.entity.Compra;
import com.platzi.market.persistence.entity.CompraProducto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-02-15T16:20:14-0500",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.4.jar, environment: Java 11.0.10 (Oracle Corporation)"
)
@Component
public class PurchaseMapperImpl implements PurchaseMapper {

    @Autowired
    private PurchaseItemMapper purchaseItemMapper;

    @Override
    public Purchase toPurchase(Compra compra) {
        if ( compra == null ) {
            return null;
        }

        Purchase purchase = new Purchase();

        if ( compra.getIdCompra() != null ) {
            purchase.setPurchaseId( compra.getIdCompra() );
        }
        purchase.setClientId( compra.getIdCliente() );
        purchase.setDate( compra.getFecha() );
        purchase.setPaymentMethod( compra.getMedioPago() );
        purchase.setComment( compra.getComentario() );
        purchase.setState( compra.getEstado() );
        purchase.setItems( compraProductoListToPurchaseItemList( compra.getProductos() ) );

        return purchase;
    }

    @Override
    public List<Purchase> toPurchases(List<Compra> compras) {
        if ( compras == null ) {
            return null;
        }

        List<Purchase> list = new ArrayList<Purchase>( compras.size() );
        for ( Compra compra : compras ) {
            list.add( toPurchase( compra ) );
        }

        return list;
    }

    @Override
    public Compra toCompra(Purchase purchase) {
        if ( purchase == null ) {
            return null;
        }

        Compra compra = new Compra();

        compra.setIdCompra( purchase.getPurchaseId() );
        compra.setIdCliente( purchase.getClientId() );
        compra.setFecha( purchase.getDate() );
        compra.setMedioPago( purchase.getPaymentMethod() );
        compra.setComentario( purchase.getComment() );
        compra.setEstado( purchase.getState() );
        compra.setProductos( purchaseItemListToCompraProductoList( purchase.getItems() ) );

        return compra;
    }

    protected List<PurchaseItem> compraProductoListToPurchaseItemList(List<CompraProducto> list) {
        if ( list == null ) {
            return null;
        }

        List<PurchaseItem> list1 = new ArrayList<PurchaseItem>( list.size() );
        for ( CompraProducto compraProducto : list ) {
            list1.add( purchaseItemMapper.toPurchaseItem( compraProducto ) );
        }

        return list1;
    }

    protected List<CompraProducto> purchaseItemListToCompraProductoList(List<PurchaseItem> list) {
        if ( list == null ) {
            return null;
        }

        List<CompraProducto> list1 = new ArrayList<CompraProducto>( list.size() );
        for ( PurchaseItem purchaseItem : list ) {
            list1.add( purchaseItemMapper.toCompraProducto( purchaseItem ) );
        }

        return list1;
    }
}
