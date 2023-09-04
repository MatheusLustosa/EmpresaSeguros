package cesar.next.desafio.spring.demo.dto;
import java.util.List;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InsuranceHouseDTO {
    
    @NotNull
    private List<Boolean> risk_questions;
    @Size(min = 0, max = 100)
    private String observation;
    @NotNull
    @Min(1)
    private long client_id;
    @NotNull
    @Min(1)
    private long house_id;
}