package dto.department;

import com.google.gson.annotations.SerializedName;
import dto.BaseGenericDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Builder
public class DepartmentCreateDto implements BaseGenericDto {

    private String name;

    @SerializedName("phone_number")
    private String phoneNumber;

}
