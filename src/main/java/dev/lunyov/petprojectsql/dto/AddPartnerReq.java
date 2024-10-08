package dev.lunyov.petprojectsql.dto;

import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Setter
@Getter
public class AddPartnerReq {
    @NotEmpty(message = "Email can't be empty")
    @Email(message = "Incorrect email format")
    private String email;

    public AddPartnerReq() {
    }

    public AddPartnerReq(String email) {
        this.email = email;
    }
}