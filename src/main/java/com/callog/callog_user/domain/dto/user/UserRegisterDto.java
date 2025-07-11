package com.callog.callog_user.domain.dto.user;

import com.callog.callog_user.domain.entity.User;
import com.callog.callog_user.remote.userstatus.Gender;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@PasswordMatch
public class UserRegisterDto {

    @Email(message = "유효한 이메일 형식이 아닙니다.")
    @NotBlank(message = "아이디를 입력하세요.")
    private String username;

    @NotBlank(message = "비밀번호를 입력하세요.")
    private String password;

    @NotBlank(message = "비밀번호 확인을 입력하세요.")
    private String passwordCheck;

    @NotBlank(message = "닉네임을 입력하세요.")
    private String nickname;

    @NotNull(message = "키를 입력하세요.")
    @Min(value = 0, message = "키는 0cm 이상이어야 합니다.")
    @Max(value = 200, message = "키는 200cm 이하여야 합니다.")
    private Long height;

    @NotNull(message = "출생년도를 입력하세요.")
    @Min(value = 1900, message = "출생년도는 1900년 이상이어야 합니다.")
    @Max(value = 2025, message = "출생년도는 2025년 이하여야 합니다.")
    private Long age;  // 출생년도만 받기! (예: 1998)

    @NotNull(message = "몸무게를 입력하세요.")
    @Min(value = 0, message = "몸무게는 0kg 이상이어야 합니다.")
    @Max(value = 200, message = "몸무게는 200kg 이하여야 합니다.")
    private Long weight;

    @NotNull(message = "성별을 선택하세요.")
    private Gender gender;

    public User toUserEntity() {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setNickname(nickname);
        return user;
    }

}
