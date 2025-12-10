package kz.ruzgaliyev.kcell.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@Entity
@Table(name = "currencyHistory")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ConversionHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fromCurrency;
    private String toCurrency;
    private double amount;
    private double result;

    private LocalDateTime conversionTime;
}
