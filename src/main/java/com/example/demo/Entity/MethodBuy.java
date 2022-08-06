package com.example.demo.Entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "MethodsBuy", schema = "SistemaVentas", catalog = "")
public class MethodBuy {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "nameMethod")
    private String nameMethod;
    @OneToMany(mappedBy = "methodBuy")
    private Collection<Cart> carts;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameMethod() {
        return nameMethod;
    }

    public void setNameMethod(String nameMethod) {
        this.nameMethod = nameMethod;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MethodBuy methodBuy = (MethodBuy) o;

        if (id != null ? !id.equals(methodBuy.id) : methodBuy.id != null) return false;
        if (nameMethod != null ? !nameMethod.equals(methodBuy.nameMethod) : methodBuy.nameMethod != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (nameMethod != null ? nameMethod.hashCode() : 0);
        return result;
    }

    public Collection<Cart> getCarts() {
        return carts;
    }

    public void setCarts(Collection<Cart> carts) {
        this.carts = carts;
    }
}
