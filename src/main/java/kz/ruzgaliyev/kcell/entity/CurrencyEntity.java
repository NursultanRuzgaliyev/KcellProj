package kz.ruzgaliyev.kcell.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "currency")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CurrencyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String currencyCode;
    private double rateToKzt;
}
