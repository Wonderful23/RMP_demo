package ty0207.example.demo.dto;

import java.io.Serializable;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class LoginRequest extends Request implements Serializable {
  @NotNull
  private String password;

  private String phone;

  private String type;
}
