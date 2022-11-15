package lotto.domain.result.domain;

public enum Win {
    FIRST(2_000_000_000, "6개 일치 (2,000,000,000원) - "),
    SECOND(30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    THIRD(1_500_000, "5개 일치 (1,500,000원) - "),
    FOURTH(50_000, "4개 일치 (50,000원) - "),
    FIFTH(5_000, "3개 일치 (5,000원) - ");

    private final int prize;
    private final String winning;

    Win(int prize, String winning) {
        this.prize = prize;
        this.winning = winning;
    }

    public int prize() {
        return prize;
    }
    public String winning() { return winning; }
}
