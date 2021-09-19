package com.sensei.savedesk.domain.productmaster;

import com.sensei.savedesk.domain.core.AbstractAuditingEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="product_master")
public class ProductMaster extends AbstractAuditingEntity {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "com.sensei.savedesk.domain.core.SequenceGenerator")
    private Long id;

    @Version
    private Integer version;


    @NotNull
    @Column(name="customer_name", nullable=false)
    private String customerName;

    @NotNull
    @Column(name="customer_product_code", nullable=false)
    private String customerProductCode;

    @NotNull
    @Column(name="customer_detail", nullable=false)
    private String customerDetail;

}
