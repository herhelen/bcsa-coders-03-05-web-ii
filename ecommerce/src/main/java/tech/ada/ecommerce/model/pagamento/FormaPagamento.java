package tech.ada.ecommerce.model.pagamento;

import jakarta.persistence.*;
import tech.ada.ecommerce.model.Compra;

import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class FormaPagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Compra compra;

    public FormaPagamento() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FormaPagamento that = (FormaPagamento) o;
        return Objects.equals(id, that.id) && Objects.equals(compra, that.compra);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, compra);
    }
}
