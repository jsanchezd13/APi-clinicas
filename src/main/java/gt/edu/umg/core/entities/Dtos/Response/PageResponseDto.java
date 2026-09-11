package gt.edu.umg.core.entities.Dtos.Response;

import java.util.List;

public record PageResponseDto<T>(
    List<T> data,
    PageMetadata metadata
) {
    public record PageMetadata(
        long totalRecords,
        int page,
        int pageSize,
        int totalPages,
        boolean hasPreviousPage,
        boolean hasNextPage
    ) {}
}
