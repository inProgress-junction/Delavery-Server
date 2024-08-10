package kr.junction.delavery.controller.dto.response;

public record PercentileResponse(
        Double percentile
) {
    public static PercentileResponse of(
            final Double percentile
    ) {
        return new PercentileResponse(
                percentile
        );
    }
}
