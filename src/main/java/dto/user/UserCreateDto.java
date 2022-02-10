package dto.user;

import com.google.gson.annotations.SerializedName;
import dto.BaseGenericDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder(builderMethodName = "childBuilder")
public class UserCreateDto implements BaseGenericDto {

    @SerializedName("first_name")
    private String firstName;

    @SerializedName("last_name")
    private String lastName;

    private String username;

    private String password;

    @SerializedName("depart_id")
    private Long departId;

}
