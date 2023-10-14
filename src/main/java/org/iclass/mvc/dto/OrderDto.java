package org.iclass.mvc.dto;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDto {
    private int bidx;
    private String email;
    private String pcode;
    private int quantity;
    @DateTimeFormat(pattern = "yyyy-MM-dd") private LocalDate orderdate;
}
