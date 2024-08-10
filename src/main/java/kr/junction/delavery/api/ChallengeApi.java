package kr.junction.delavery.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.junction.delavery.common.annotation.RequestUserId;
import kr.junction.delavery.controller.dto.response.ChallengeResponse;
import kr.junction.delavery.controller.dto.response.PercentileResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Tag(name = "챌린지 API")
@RequestMapping("/challenges")
public interface ChallengeApi {

    @Operation(summary = "챌린지 백분위 조회")
    @GetMapping("/percentile")
    PercentileResponse getChallengePercentile(
            @RequestUserId String memberId
    );

    @Operation(summary = "챌린지 언락 시도 현황 변경")
    @PatchMapping("/unlock-trial-count")
    ChallengeResponse updateUnlockTrialCount(
            @RequestUserId String memberId
    );

    @Operation(summary = "챌린지 언락 현황 변경")
    @PatchMapping("/unlock-done-count")
    ChallengeResponse updateUnlockDoneCount(
            @RequestUserId String memberId
    );
}
