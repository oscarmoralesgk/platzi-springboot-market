package com.platzi.market.persistence.mapper;

import com.platzi.market.domain.PurchaseItem;
import com.platzi.market.persistence.entity.CompraProducto;
import com.platzi.market.persistence.entity.CompraProductoPK;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-02-15T16:20:14-0500",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.4.jar, environment: Java 11.0.10 (Oracle Corporation)"
)
@Component
public class PurchaseItemMapperImpl implements PurchaseItemMapper {

    @Override
    public PurchaseItem toPurchaseItem(CompraProducto producto) {
        if ( producto == null ) {
            return null;
        }

        PurchaseItem purchaseItem = new PurchaseItem();

        Integer idProducto = productoIdIdProducto( producto );
        if ( idProducto != null ) {
            purchaseItem.setProductId( idProducto );
        }
        if ( producto.getCantidad() != null ) {
            purchaseItem.setQuantity( producto.getCantidad() );
        }
        purchaseItem.setActive( producto.getEstado() );
        if ( producto.getTotal() != null ) {
            purchaseItem.setTotal( producto.getTotal() );
        }

        return purchaseItem;
    }

    @Override
    public CompraProducto toCompraProducto(PurchaseItem item) {
        if ( item == null ) {
            return null;
        }

        CompraProducto compraProducto = new CompraProducto();

        compraProducto.setId( purchaseItemToCompraProductoPK( item ) );
        compraProducto.setCantidad( item.getQuantity() );
        compraProducto.setEstado( item.getActive() );
        compraProducto.setTotal( (int) item.getTotal() );

        return compraProducto;
    }

    private Integer productoIdIdProducto(CompraProducto compraProducto) {
        if ( compraProducto == null ) {
            return null;
        }
        CompraProductoPK id = compraProducto.getId();
        if ( id == null ) {
            return null;
        }
        Integer idProducto = id.getIdProducto();
        if ( idProducto == null ) {
            return null;
        }
        return idProducto;
    }

    protected CompraProductoPK purchaseItemToCompraProductoPK(PurchaseItem purchaseItem) {
        if ( purchaseItem == null ) {
            return null;
        }

        CompraProductoPK compraProductoPK = new CompraProductoPK();

        compraProductoPK.setIdProducto( purchaseItem.getProductId() );

        return compraProductoPK;
    }
}
