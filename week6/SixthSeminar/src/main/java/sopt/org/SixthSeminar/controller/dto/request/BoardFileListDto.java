package sopt.org.SixthSeminar.controller.dto.request;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BoardFileListDto {

    @NotBlank
    private String title;

    @NotBlank
    private String content;

    @NotNull
    private Boolean isPublic;

    @NotNull
    private List<MultipartFile> imageList;
}
