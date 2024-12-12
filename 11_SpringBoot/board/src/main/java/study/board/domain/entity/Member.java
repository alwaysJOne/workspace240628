package study.board.domain.entity;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member {
    private String email;           // 이메일 (Primary Key)
    private String password;        // 비밀번호
    private String nickname;        // 닉네임
    private LocalDateTime createAt; // 생성 일시
    private LocalDateTime updateAt; // 수정 일시
}
