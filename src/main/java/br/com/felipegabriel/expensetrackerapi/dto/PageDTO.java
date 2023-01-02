package br.com.felipegabriel.expensetrackerapi.dto;

import br.com.felipegabriel.expensetrackerapi.util.MapUtil;
import lombok.*;
import org.springframework.data.domain.Page;
import java.util.List;

@Builder
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class PageDTO<T> {
    private Long totalOfElements;
    private Integer page;
    private Integer totalOfPages;
    private List<T> content;
    private boolean isLastPage;

    public PageDTO<T> map(Page<?> page, List<T> content) {
        return PageDTO.<T>builder()
                .page(page.getNumber())
                .content(content)
                .totalOfElements(page.getTotalElements())
                .totalOfPages(page.getTotalPages())
                .isLastPage(page.isLast())
                .build();
    }
}
