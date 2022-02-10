package dto.user;

import com.google.gson.annotations.SerializedName;
import dto.GenericDto;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(builderMethodName = "childBuilder")
public class UserDto extends GenericDto {

    @SerializedName("first_name")
    private String firstName;

    @SerializedName("last_name")
    private String lastName;

    private String username;

    private Integer status;

    @SerializedName("depart_id")
    private Long departId;

    private String role;

}
