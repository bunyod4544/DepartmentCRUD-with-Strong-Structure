package dto;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GenericDto implements BaseGenericDto {
    private Long id;
}
