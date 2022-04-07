package com.bayyand.spring_app.common.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.math.RoundingMode;

@NoArgsConstructor @Getter @Setter
public class ProductDto {
    private Long id;
    @NotEmpty(message = "the name is required") @Size(max = 50, message = "the length of the name must be between 1 and 100 characters.")
    private String name;

    @NotNull(message = "the price is required")
    private BigDecimal price;

    @NotNull(message = "the categoryId is required")
    private Short categoryId;

    @JsonCreator
    public ProductDto(@JsonProperty("id") Long id,
                      @JsonProperty("name") String name,
                      @JsonProperty("price") BigDecimal price,
                      @JsonProperty("categoryId") Short categoryId){
        this.id =id;
        this.name = name;
        this.price = price.setScale(2, RoundingMode.HALF_EVEN);
        this.categoryId =categoryId;
    }
}
