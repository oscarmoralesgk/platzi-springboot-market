
package com.platzi.market.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "platzi_compras_productos", schema = "IVR_CONSULTA")
public class CompraProducto {

    @EmbeddedId
    private CompraProductoPK id;

    private Integer cantidad;

    private Integer total;

    private String estado;

    @ManyToOne
    @MapsId("idCompra")
    @JoinColumn(name = "id_compra", insertable = false, updatable = false)
    private Compra compra;

    @ManyToOne
    @JoinColumn(name = "id_producto", insertable = false, updatable = false)
    private Producto producto;

    public CompraProductoPK getId() {
        return id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public Integer getTotal() {
        return total;
    }

    public void setId(CompraProductoPK id) {
        this.id = id;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}
