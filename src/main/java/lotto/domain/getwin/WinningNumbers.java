package lotto.domain.getwin;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.getwin.domain.Bonus;
import lotto.domain.getwin.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class WinningNumbers {
    static final String ERROR_ONLY_NUMBER = "[ERROR] 숫자만 입력 가능합니다.";
    static final String ERROR_NO_DUPLICATE_BETWEEN_LOTTO_AND_BONUS = "[ERROR] 보너스 번호는 로또 번호와 중복되면 안 됩니다.";
    static final String ERROR_ONLY_ONE_BONUS = "[ERROR] 보너스 번호는 1개입니다.";

    public final List<Integer> lotto;
    public final int bonus;

    public WinningNumbers() {
        List<Integer> tmpLotto = getLotto();
        this.lotto = new Lotto(tmpLotto).numbers;
        int tmpBonus = getBonus();
        this.bonus = new Bonus(tmpBonus).bonus;
        validate(lotto, bonus);

    }

    private List<Integer> getLotto() {
        List<Integer> lotto = new ArrayList<>();
        System.out.println("당첨 번호를 입력해 주세요.");
        String numbers = Console.readLine();
        String[] tmp = numbers.split(",");
        for (int i = 0; i < tmp.length; i++) {
            try {
                lotto.add(Integer.parseInt(tmp[i]));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(ERROR_ONLY_NUMBER);
            }
        }
        return lotto;
    }

    private int getBonus() {
        int bonus;
        System.out.println("보너스 번호를 입력해주세요");
        String bonusNumber = Console.readLine();
        String[] tmp = bonusNumber.split(",");
        if (tmp.length != 1)
            throw new IllegalArgumentException(ERROR_ONLY_ONE_BONUS);
        try {
            bonus = Integer.parseInt(tmp[0]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_ONLY_NUMBER);
        }
        return bonus;
    }

    private void validate(List<Integer> lotto, int bonus) {
        if (lotto.contains(bonus)) {
            throw new IllegalArgumentException(ERROR_NO_DUPLICATE_BETWEEN_LOTTO_AND_BONUS);
        }
    }
}
