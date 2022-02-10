package dto.user;

import com.google.gson.annotations.SerializedName;
import dto.GenericDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
//@Builder(builderMethodName = "childBuilder")
@NoArgsConstructor
public class UserUpdateDto extends GenericDto {

    @SerializedName("first_name")
    private String firstName;

    @SerializedName("last_name")
    private String lastName;

    private String username;

    @SerializedName("depart_id")
    private Long departId;

}
